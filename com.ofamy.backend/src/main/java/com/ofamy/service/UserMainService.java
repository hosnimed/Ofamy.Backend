package com.ofamy.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.Result;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ofamy.model.AdhereToRelationShip;
import com.ofamy.model.CommentsRelationShip;
import com.ofamy.model.FollowTrendRelShip;
import com.ofamy.model.FriendRelationShip;
import com.ofamy.model.LikeRelationShip;
import com.ofamy.model.Offer;
import com.ofamy.model.RatingRelationShip;
import com.ofamy.model.Trend;
import com.ofamy.model.User;
import com.ofamy.repository.OfferRepository;
import com.ofamy.repository.TrendRepository;
import com.ofamy.repository.UserRepository;
import com.ofamy.service.dto.UserOfferDTO;
import com.ofamy.service.dto.UserDTOForUserInterface;
import com.ofamy.service.dto.UserDTOForUserProfile;
import com.ofamy.service.dto.UsersStatus;
import com.ofamy.util.RelationShipTypes;


@Transactional
@Service
public class UserMainService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TrendRepository trendRepository;
	@Autowired
	private OfferRepository offerRepository;
	@Autowired
	private UserOfferService userOfferService;
	@Autowired
	UserTrendsService userTrendsService;
	@Autowired
	private Neo4jTemplate neo4jTemplate;
	
	private final static Logger logger=LoggerFactory.getLogger(UserMainService.class);

	public UserOfferDTO likesOffer(long user_id, Long offer_id) {
		Offer offer=offerRepository.findOne(offer_id);
		User currentUser=userRepository.findOne(user_id);
		LikeRelationShip likeRelationShip=neo4jTemplate.createRelationshipBetween(currentUser, offer, LikeRelationShip.class, RelationShipTypes.LIKES, false);
		likeRelationShip.setDate(new Date());
		return userOfferService.createOfferDTOfromOfferBeta(offer);
	}


	public void commentOffer(long user_id , String comment, long offer_id) {
		User currentUser=userRepository.findOne(user_id);
		Offer offer = offerRepository.findOne(offer_id);
		CommentsRelationShip commentsRelationShip=	neo4jTemplate.createRelationshipBetween(currentUser, offer, CommentsRelationShip.class, RelationShipTypes.COMMENTS, true);		
		commentsRelationShip.setComment(comment);
		commentsRelationShip.setCommentDate(new Date());
		neo4jTemplate.save(commentsRelationShip);
	}
	
	public Offer deleteOfferComment(long offerId, long commentId) {
		Offer offer=offerRepository.findOne(offerId);
			Iterable<CommentsRelationShip> comments=offer.getComments();
		//	List<CommentsRelationShip> commentsList=new ArrayList<CommentsRelationShip>();
			for (Iterator<CommentsRelationShip> it = comments.iterator(); it.hasNext();) {
						CommentsRelationShip comment = (CommentsRelationShip) it.next();
			//			commentsList.add(comment);
			if(comment.getTargetOffer().getOfferId()==offer.getOfferId()){
				logger.info(comment.getTargetOffer()+" equals "+offer);
					neo4jTemplate.deleteRelationshipBetween(comment.getUser(),offer, RelationShipTypes.COMMENTS);
					return offer;
			}
		}
		return offer;
	}
	
	public void adhereToOffer(Long user_id, Long id) {
		User u=userRepository.findOne(user_id);
		Offer offer=offerRepository.findOne(id);
		AdhereToRelationShip adhereToRelationShip =	neo4jTemplate.createRelationshipBetween(u, offer, AdhereToRelationShip.class, RelationShipTypes.ADHERE_TO, false);
		adhereToRelationShip.setDate(new Date());
		neo4jTemplate.save(adhereToRelationShip);
	}


	public void rateOffer(Long user_id, Long id, double stars) {
		RatingRelationShip rating;	
		if (stars >= RatingRelationShip.MIN_STARS && stars <= RatingRelationShip.MAX_STARS){
		User u=userRepository.findOne(user_id);
		Offer o=offerRepository.findOne(id);
rating=	neo4jTemplate.createRelationshipBetween(u, o,RatingRelationShip.class, RelationShipTypes.RATED, true);
		rating.setStars(stars);
		neo4jTemplate.save(rating);
	}
	}

	
	public Set<UserDTOForUserInterface> UsersLikeOffer(Long user_id, Long offerId) {
		User current = userRepository.findOne(user_id);
		Offer offer = offerRepository.findOne(offerId);
		return adaptUserForUserDTO(current,
				offerRepository.getLikes(offer));
	}

	public Set<UserDTOForUserInterface> adaptUserForUserDTO(User current,List<User> users) {
		Set<UserDTOForUserInterface> usersProfile=new HashSet<UserDTOForUserInterface>();
		String status;
		UserDTOForUserInterface dto;
	
		for (User u : users) {
			if (u.getUserId() == current.getUserId())
			{
				status=UsersStatus.ME.toString();
			}else	
			if(isFollowed(current, u)){
				status=UsersStatus.FOLLOWED.toString();
			} 
			else  {
				status=UsersStatus.UNFOLLOWED.toString();
			}
			dto=new UserDTOForUserInterface();
			dto.setUserId(u.getUserId());
			dto.setFirstname(u.getFirstName());
			dto.setLastname(u.getLastName());
//			neo4jTemplate.fetch(u.getLocation().getCity());
//			neo4jTemplate.fetch(u.getLocation());
//			logger.info("Location Adresse :"+u.getLocation().getAdress());
	//		dto.setLocation(u.getLocation().getAdress());
			dto.setLocation("location");
			dto.setProfilepicture(u.getProfilePicture());
			dto.setStatus(status);
			dto.setPresentation(u.getPresentation());
			dto.setTrends(userTrendsService.findTrendFollowedByUserID(current.getUserId()));
			usersProfile.add(dto);
		}
		
		return usersProfile;
	}
	
	
	@Transactional(readOnly = true)
	public User getUserByLogin(String login) {
		return userRepository.findByLogin(login);
	}

	@Transactional(readOnly = true)
	public List<User> getUsersFriends(Long id) {
		return userRepository.findFriends(userRepository.findOne(id));
	}

	public void createUser(User user) {

	}

	public void registerUser(User user) {

	}

	public void validateRegistration(String key) {

	}

	// hosni
	public UserDTOForUserInterface getUserDTOProfile(long current, long other) {
	List<User> users= new ArrayList<User>();
	users.add(userRepository.findOne(other) );
return adaptUserForUserDTO(userRepository.findOne(current),users ).iterator().next() ;
	}

	

	// ninja
	public User GetUserByEmailPassword(String email, String password) {

		return userRepository.findByEmailAndPassword(email, password);

	}

	// ninja
	public User UpdateUser(User user) {
		return userRepository.save(user) ;
			
	}

	// ninja
	public Set<UserDTOForUserInterface> findFriends(long id) {
		User u=userRepository.findOne(id);
		return adaptUserForUserDTO(u, userRepository.findFriends(u)) ;
	}

	@Transactional
	public boolean followUser(long current_user_id, long other_user_id) {
		User current = userRepository.findOne(current_user_id);
		User other = userRepository.findOne(other_user_id);
		if (current != null && other != null) {
			FriendRelationShip friendRelationShip=neo4jTemplate.createRelationshipBetween(current, other,FriendRelationShip.class	, RelationShipTypes.FRIEND, false);
			friendRelationShip.setSince(new Date());
			neo4jTemplate.save(friendRelationShip);
			return true;
		}
		
		return false;
	}

	@Transactional
	public boolean unfollowUser(long current_user_id, long other_user_id) {
		User current = userRepository.findOne(current_user_id);
		User other = userRepository.findOne(other_user_id);
		if (current != null && other != null) {
			neo4jTemplate.deleteRelationshipBetween(current, other,
					RelationShipTypes.FRIEND);
		
			return true;
		}
		return false;
	}

	public Set<UserDTOForUserInterface> findFollowers(long id) {
		User u=userRepository.findOne(id);
		if(u!=null)
		return adaptUserForUserDTO(u,userRepository.findFollowers(u));
		return null;
	}

	
	public Set<UserDTOForUserInterface> findFollowings(long id) {
		User u=userRepository.findOne(id);
		if(u!=null)
		return adaptUserForUserDTO( u, userRepository.findFollowings(u));
		return null;
	}

	public List<Trend> getUserTrends(User user) {
	if(user!=null)
		return userRepository.findUserTrends(user);
		return null;
	}

	@Transactional
	public void followTrend(long user_id, long trend_id) {
		User u = userRepository.findOne(user_id);
		Trend trend = trendRepository.findOne(trend_id);
		FollowTrendRelShip followTrendRelShip=neo4jTemplate.createRelationshipBetween(u, trend, FollowTrendRelShip.class,	RelationShipTypes.FOLLOW_TREND, false);
		followTrendRelShip.setStartDate(new Date());
		neo4jTemplate.save(followTrendRelShip);
	}

	@Transactional
	public void unfollowTrend(long user_id, long trend_id) {
		User u = userRepository.findOne(user_id);
		Trend trend = trendRepository.findOne(trend_id);
		neo4jTemplate.deleteRelationshipBetween(u, trend,
				RelationShipTypes.FOLLOW_TREND);
		
	}

	public boolean isFollowed(User currentUser, User user) {
		
		return userRepository.isFollowed(currentUser, user) ;
	}

	public List<UserDTOForUserInterface> getAllUsers() {
	// List<User> allUsers = new ArrayList<User>();
	return createUsersDTOFromUsers( userRepository.findAll());
	}

	

	private List<UserDTOForUserInterface> createUsersDTOFromUsers(Result<User> findAll) {
		List<UserDTOForUserInterface> dtos=new ArrayList<UserDTOForUserInterface>() ;
		UserDTOForUserInterface dto;
		for (User user : findAll) {
			dto=new UserDTOForUserInterface();
			dto.setUserId(user.getUserId());
			dto.setFirstname(user.getFirstName());
			dto.setLastname(user.getLastName());
			dto.setProfilepicture(user.getProfilePicture());
		
		//	dto.setStatus(  user.getMyStatus().iterator().next().getUserStatus().toString() );
		dtos.add(dto);
		}
		return dtos;
	}


	public UserDTOForUserProfile getUserProfile(long currentId) {
	
		User u=userRepository.findOne(currentId);
		return adaptUserForUserProfileDTO(u) ;
	}


	private UserDTOForUserProfile adaptUserForUserProfileDTO(User u) {
		UserDTOForUserProfile dto=new UserDTOForUserProfile();
		dto.setEmail(u.getEmail());
		dto.setDescription(u.getPresentation());
		long nb_follwers=userRepository.countFollowers(u);
		dto.setNb_follwers(nb_follwers);
		long nb_followings=userRepository.countFollowings(u);
		dto.setNb_followings(nb_followings);
		return dto;
	}


	
	
	
	

}
