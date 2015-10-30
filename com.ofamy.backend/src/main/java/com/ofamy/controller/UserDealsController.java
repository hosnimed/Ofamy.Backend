package com.ofamy.controller;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ofamy.model.Offer;
import com.ofamy.security.AuthenticationService;
import com.ofamy.service.UserMainService;
import com.ofamy.service.UserOfferService;
import com.ofamy.service.dto.UserCommentDTO;
import com.ofamy.service.dto.UserCommentDTOPost;
import com.ofamy.service.dto.UserDTOForUserInterface;
import com.ofamy.service.dto.UserOfferDTO;
import com.ofamy.service.dto.UserOfferDetailsDTO;

/**
 * 
 * @author Mohamed
 *
 */
@RestController
@RequestMapping("/deals")
public class UserDealsController {

	@Autowired
	UserOfferService OfferService;
	@Autowired
	UserMainService UserService;
	@Autowired
	AuthenticationService authenticationService;
	// @Value("5")
	// private int maxResults;
	private static final String DEFAULT_PAGE_DISPLAYED_TO_USER = "1";
	private static final String DEFAULT_MAX_RESULT_DISPLAYED_TO_USER = "5";
	private static final Logger logger = LoggerFactory
			.getLogger(UserDealsController.class);

	@RequestMapping(value = "/myofaline/", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<UserOfferDTO> getAllOffers(
			@RequestParam(required = false, defaultValue = DEFAULT_PAGE_DISPLAYED_TO_USER, value = "page") int page,
			@RequestParam(required = false, defaultValue = DEFAULT_MAX_RESULT_DISPLAYED_TO_USER, value = "maxResult") int maxResult) {
		long currentId = authenticationService.getCurrentUser().getUserId();
		logger.info("currentId : "+currentId);
		return OfferService.createListOfferDTOFromOffers(currentId, page,
				maxResult);
	}

	@RequestMapping(value = "/findOffer/{offerId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody UserOfferDTO findOffer(
			@PathVariable("offerId") long offerId) {

		return OfferService.findOfferDTOById(offerId);
	}

	@RequestMapping(value = "/findOfferDetails/{offerId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody UserOfferDetailsDTO findOfferDetails(
			@PathVariable("offerId") long offerId) {
		UserOfferDetailsDTO dto = OfferService.findOfferDetailsById(offerId);
		return dto;
	}

	@RequestMapping(value = "/likeOffer/{offerd}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody UserOfferDTO likeOffer(
			@PathVariable("offerId") long offerId) {
		long currentId = authenticationService.getCurrentUser().getUserId();
		return UserService.likesOffer(currentId, offerId);

	}

	@RequestMapping(value = "/commentOffer/", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody List<UserCommentDTO> commentOffer(
			@RequestBody UserCommentDTOPost comment) {
		logger.info("Comment :" + comment.getComment());
		UserService.commentOffer(comment.getUserId(), comment.getComment(),
				comment.getOfferId());
		return OfferService.findComments(comment.getOfferId());
	}

	@RequestMapping(value = "/deleteOfferComment/{offerId}/{commentId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<UserCommentDTO> deleteOfferComment(
			@PathVariable("offerId") long offerId,
			@PathVariable("commentId") long commentId) {
		Offer offer = UserService.deleteOfferComment(offerId, commentId);
		return OfferService.findComments(offer.getOfferId());
	}

	@RequestMapping(value = "/adhereToOffer/{id}", method = RequestMethod.GET, produces = "application/json")
	public void adhereToOffer(@PathVariable("id") Long id) {
		long currentId = authenticationService.getCurrentUser().getUserId();
		UserService.adhereToOffer(currentId, id);
	}

	@RequestMapping(value = "/rateOffer/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void rateOffer(@PathVariable("id") Long id,
			@RequestParam(required = true, value = "stars") double stars) {
		long currentId = authenticationService.getCurrentUser().getUserId();
		UserService.rateOffer(currentId, id, stars);
	}

	@RequestMapping(value = "/followersLikes/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Set<UserDTOForUserInterface> followersLikes(
			@PathVariable("id") Long id) {
		long currentId = authenticationService.getCurrentUser().getUserId();
		return UserService.UsersLikeOffer(currentId, id);
	}

	@RequestMapping(value = "/followersComments/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<UserCommentDTO> followersComments(
			@PathVariable("id") Long id) {

		return OfferService.findComments(id);
	}

	@RequestMapping(value = "/followersAdheres/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Set<UserDTOForUserInterface> followersAdheres(
			@PathVariable("id") Long id) {
		long currentId = authenticationService.getCurrentUser().getUserId();
		return OfferService.UserAdhereToOffer(currentId, id);
	}

}