package com.ofamy.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ofamy.model.CommentsRelationShip;
import com.ofamy.model.Offer;
import com.ofamy.model.OfferStatusRelationShip;
import com.ofamy.model.User;
import com.ofamy.repository.OfferDefinitionRepository;
import com.ofamy.repository.OfferRepository;
import com.ofamy.repository.UserRepository;
import com.ofamy.service.dto.HistoDTO;
import com.ofamy.service.dto.HistoDetailsDTO;
import com.ofamy.service.dto.OfferMSDTO;
import com.ofamy.service.dto.OfferMSDetailDTO;
import com.ofamy.service.dto.UserCommentDTO;
import com.ofamy.service.dto.UserOfferDTO;
import com.ofamy.service.dto.UserOfferDetailsDTO;
import com.ofamy.service.dto.UserDTOForUserInterface;

@Transactional
@Service
public class UserOfferService {

	@Autowired
	private OfferRepository offerRepository;
	@Autowired
	private OfferDefinitionRepository offerDefinitionRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserMainService userMainService;
	@Autowired
	Neo4jTemplate neo4j;
	private static final Logger logger = LoggerFactory
			.getLogger(UserOfferService.class);

	public List<UserOfferDTO> createListOfferDTOFromOffers(long user_id, int page,
			int maxResults) {

		List<UserOfferDTO> offers = new ArrayList<UserOfferDTO>();
		Page<Offer> results = executeQueryFindByUser(page, maxResults, user_id);
		List<Offer> listOffers = results.getContent();
		for (Offer offer : listOffers) {
			// logger.info("createListOfferDTOFromOffers :"+offer.getOwner().getName());
			offers.add(createOfferDTOfromOfferBeta(offer));
		}
		return offers;
	}

	public Offer findOfferById(Long offer_id) {

		return offerRepository.findOne(offer_id);
	}

	public UserOfferDTO findOfferDTOById(long id) {
		Offer offer = offerRepository.findOne(id);
		UserOfferDTO dto = createOfferDTOfromOfferBeta(offer);

		return dto;
	}

	public UserOfferDetailsDTO findOfferDetailsById(long id) {
		Offer offer = offerRepository.findOne(id);
		UserOfferDetailsDTO dto = createOfferDetailsDTOfromOfferBeta(offer);
		return dto;
	}

	public Offer findOfferByName(String name) {
		return offerRepository.findByName(name);
	}

	


	public List<UserCommentDTO> findComments(Long offerId) {
		Offer offer = offerRepository.findOne(offerId);
		Iterable<CommentsRelationShip> relations = offer.getComments();
		List<UserCommentDTO> comments = adaptCommentRelationShipToCommentDTO(relations);
		return comments;
	}

	private List<UserCommentDTO> adaptCommentRelationShipToCommentDTO(
			Iterable<CommentsRelationShip> comments) {
		CommentsRelationShip comment;
		UserCommentDTO dto;
		List<UserCommentDTO> dtos = new ArrayList<UserCommentDTO>();
//		logger.info("Comments :");
		for (Iterator<CommentsRelationShip> it = comments.iterator(); it
				.hasNext();) {
			comment = (CommentsRelationShip) it.next();
			dto = new UserCommentDTO();
			dto.setCommentId(comment.getId());
			dto.setUserId(comment.getUser().getUserId());
			dto.setFirst_name(comment.getUser().getFirstName());
			dto.setLast_name(comment.getUser().getLastName());
			dto.setPicture(comment.getUser().getProfilePicture());
			dto.setComment(comment.getComment());
			dto.setDate(comment.getCommentDate());
//			logger.info("Comment :" + dto);
			dtos.add(dto);
		}
		Collections.reverse(dtos);
		 return dtos;
	}

	public Set<UserDTOForUserInterface> UserAdhereToOffer(Long user_id, Long offerId) {
		User current = userRepository.findOne(user_id);
		Offer offer = offerRepository.findOne(offerId);
		return userMainService.adaptUserForUserDTO(current,
				offerRepository.getAdheres(offer));
	}

	private Page<Offer> executeQueryFindByUser(int page, int maxResults,Long user_id) {
		final PageRequest pageRequest = new PageRequest(page - 1, maxResults, sortByDateDESC());
		User user = userRepository.findOne(user_id);
		Page<Offer> page_offer = offerRepository.findTimelineOffers(user,pageRequest);

		logger.info("Page Number: " + page_offer.getNumber()+1);
		logger.info("Total page :" + page_offer.getTotalPages());
		logger.info("Total Elements : " + page_offer.getTotalElements());
		return page_offer;
	}

	private Sort sortByDateDESC() {
		return new Sort(Sort.Direction.DESC, "o.creationDate");
	}

	public UserOfferDTO createOfferDTOfromOfferBeta(Offer offer) {
		UserOfferDTO dto = new UserOfferDTO();
		dto.setOfferId(offer.getOfferId());
		dto.setOfferTitle(offer.getName());
neo4j.fetch(offer.getOfferDefinition().getOwner());			
		dto.setCompanyId(offer.getOfferDefinition().getOwner().getUserId());
		dto.setCompanyName(offer.getOfferDefinition().getOwner().getName());
		dto.setFollowers_count(offerRepository.countFollowers(offer));
		dto.setPrice(offer.getOfferDefinition().getProduct().getBudget());
		dto.setLike_count(offerRepository.countLikes(offer));
		dto.setDescriptionShort(offer.getOfferDefinition().getShortDescription());
		dto.setOfferSmallPicture(offer.getOfferDefinition().getProduct()
				.getTimelinePicture());
		dto.setRewardPicture(offer.getOfferDefinition().getReward()
				.getTimlinePicture());
		dto.setCreation_date(offer.getCreationDate());
	//	dto.setCurrentStatus(getLastOfferStatus(offer.getOfferstatus()));
		dto.setCurrentStatus(offerRepository.getLastStatus(offer));
		return dto;
	}

	private String getLastOfferStatus(Set<OfferStatusRelationShip> offerstatus) {
		OfferStatusRelationShip ship = null;
		while( offerstatus.iterator().hasNext()){
			 ship= offerstatus.iterator().next();
		}
		return ship.getOfferStatus().getStatus().name();
	}

	public UserOfferDetailsDTO createOfferDetailsDTOfromOfferBeta(Offer offer) {
		UserOfferDetailsDTO dto = new UserOfferDetailsDTO();
		dto.setOfferId(offer.getOfferId());
 neo4j.fetch(offer.getOfferDefinition().getOwner());	
		dto.setCompanyId(offer.getOfferDefinition().getOwner().getUserId());

		dto.setCompanyName(offer.getOfferDefinition().getOwner().getName());
 neo4j.fetch(offer.getCity());		
		dto.setOfferCity(offer.getCity().getName());
		dto.setCompanyPicture(offer.getOfferDefinition().getOwner().getLogo());

		dto.setFollowers_count(offerRepository.countFollowers(offer));
		dto.setOfferTitle(offer.getName());
		dto.setPrice(offer.getOfferDefinition().getProduct().getBudget());
		dto.setRate(dto.calculateRate(offer));
		dto.setLike_count(offerRepository.countLikes(offer));
		dto.setDescriptionLong(offer.getDescription());

		dto.setOfferBigPicture1(offer.getOfferDefinition().getProduct()
				.getDetailPicture1());
		dto.setOfferBigPicture2(offer.getOfferDefinition().getProduct()
				.getDetailPicture2());
		dto.setOfferBigPicture3(offer.getOfferDefinition().getProduct()
				.getDetailPicture3());

		dto.setRewardTitle(offer.getOfferDefinition().getReward().getName());
		dto.setRewardDescription(offer.getOfferDefinition().getReward()
				.getDescription());
		dto.setRewardPicture(offer.getOfferDefinition().getReward()
						.getDetailPicture());
		
		dto.setCreation_date(offer.getCreationDate());
		dto.setEnd_date(offer.getEndDate());

//		dto.setCurrentStatus(getLastOfferStatus(offer.getOfferstatus())); 
		dto.setCurrentStatus(offerRepository.getLastStatus(offer));	

		dto.setComments_count(offerRepository.countComments(offer));
		dto.setComments(findComments(offer.getOfferId()));
			
		logger.info("OfferDetailsDTOfromOfferBeta :" + dto);
		return dto;
	}

	
	
	//ninja _______________formyspace____________________________
	public List<Offer> findMSOffers(long userId,int page, int maxResult)
	{
		User u=userRepository.findOne(userId);
		PageRequest pageRequest = new PageRequest(page, maxResult); 
	return 	 offerRepository.findPrivateOffersForUser(u,pageRequest).getContent();
	}

	public List<Offer> maliste(long userId,int page, int maxResult)
	{
		User u=userRepository.findOne(userId);
		PageRequest pageRequest = new PageRequest(page, maxResult); 
		return offerRepository.maliste(u,pageRequest).getContent();
		
	}

	public OfferMSDetailDTO createOfferMSDetailsDTOfromOffer(Offer offer) {
		// TODO Auto-generated method stub
		OfferMSDetailDTO dto= new OfferMSDetailDTO(offer);
		return dto;
	}

	public HistoDetailsDTO createHistoDetailsDTOFromOffer(Offer offer)
	{
		HistoDetailsDTO dto = new HistoDetailsDTO(offer);
	/*	dto.setComments_count(offerRepository.countComments(offer));
		dto.setComments(findComments(offer.getOfferId()));
		dto.setFollowers_count(offerRepository.countFollowers(offer));
		dto.setLike_count(offerRepository.countLikes(offer));*/
		return dto;
	}

	//ninja MSDTOList from offer list
		public List<OfferMSDTO> createMSOfferDTOFromOfferList(List<Offer> list)
		{ List<OfferMSDTO> dtos=new ArrayList<OfferMSDTO>();
		for (Offer offer : list ){
			dtos.add(new OfferMSDTO(offer));
		}
			
			return dtos;
		}

		//ninja HistDTOList from offer list
		public List<HistoDTO> createHistoDTOFromOfferList(List<Offer> list)
		{ List<HistoDTO> dtos=new ArrayList<HistoDTO>();
		for (Offer offer : list ){
		HistoDTO dto = new  HistoDTO(offer);
			dto.setAdhereCount(offerRepository.countFollowers(offer));
			dto.setStatus(offerRepository.getLastStatus(offer));
			dtos.add(dto);
		
		}
			
			return dtos;
		}


	}