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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ofamy.model.User;
import com.ofamy.security.AuthenticationService;
import com.ofamy.service.UserMainService;
import com.ofamy.service.UserTrendsService;
import com.ofamy.service.dto.TrendsForUserProfile;
import com.ofamy.service.dto.UserDTOForUserInterface;
import com.ofamy.service.dto.UserDTOForUserProfile;

/**
 * 
 * @author Mohamed
 *
 */

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserTrendsService  userTrendsService;
	@Autowired
	UserMainService userMainService;
	@Autowired
	AuthenticationService authenticationService;

	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

	@RequestMapping(value = "/profile/{otherId}", method = RequestMethod.GET)
	public @ResponseBody UserDTOForUserInterface getUserProfile(
			@PathVariable(value = "otherId") long otherId) {
		long currentId = authenticationService.getCurrentUser().getUserId();
		return userMainService.getUserDTOProfile(currentId, otherId);
	}

	@RequestMapping(value = "/myprofile/", method = RequestMethod.GET)
	public @ResponseBody UserDTOForUserProfile getMyProfile() {
		long currentId = authenticationService.getCurrentUser().getUserId();
		return userMainService.getUserProfile(currentId);
	}

	@RequestMapping(value = "/profile/", method = RequestMethod.POST, produces = "application/json")
	public void updateUser(@RequestBody(required = true) final User user) {
		userMainService.UpdateUser(user);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody List<UserDTOForUserInterface> getAllUsers() {

		return userMainService.getAllUsers();
	}

	@RequestMapping(value = "/friends/", method = RequestMethod.GET)
	public @ResponseBody Set<UserDTOForUserInterface> getFriends() {
		long id = authenticationService.getCurrentUser().getUserId();
		return userMainService.findFriends(id);
	}

	// hosni
	@RequestMapping(value = "/trends/", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<TrendsForUserProfile> getTrends() {
		long id = authenticationService.getCurrentUser().getUserId();
		return userTrendsService.adaptTrendsForUserProfile(id);
	}

	// hosni
	@RequestMapping(value = "/trends/followTrend/{trendid}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<TrendsForUserProfile> followTrend(
			@PathVariable(value = "trendid") long trend_id) {
		long currentId = authenticationService.getCurrentUser().getUserId();
		userMainService.followTrend(currentId, trend_id);
		logger.debug("/trends/" + currentId + "/followTrend/" + trend_id);

		return userTrendsService.adaptTrendsForUserProfile(currentId);
	}

	@RequestMapping(value = "/trends/unfollowTrend/{trendid}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<TrendsForUserProfile> unfollowTrend(
			@PathVariable(value = "trendid") long trend_id) {
		long currentId = authenticationService.getCurrentUser().getUserId();
		userMainService.unfollowTrend(currentId, trend_id);
		logger.debug("/trends/" + currentId + "/unfollowTrend/" + trend_id);

		return userTrendsService.adaptTrendsForUserProfile(currentId);
	}

	@RequestMapping(value = "/followers/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Set<UserDTOForUserInterface> findFollowers(
			@PathVariable(value = "id") long id) {
		return userMainService.findFollowers(id);
	}

	@RequestMapping(value = "/followings/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Set<UserDTOForUserInterface> findFollowings(
			@PathVariable(value = "id") long id) {
		return userMainService.findFollowings(id);
	}

	@RequestMapping(value = "/followUser/{otherid}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void followUser(
			@PathVariable(value = "otherid") long otherUser_id) {
		long currentUser_id = authenticationService.getCurrentUser()
				.getUserId();
		logger.debug(currentUser_id + "/followUser/" + otherUser_id);
		userMainService.followUser(currentUser_id, otherUser_id);

	}

	@RequestMapping(value = "/unfollowUser/{otherid}", method = RequestMethod.GET, produces = "application/json")
	public void unfollowUser(@PathVariable(value = "otherid") long otherUser_id) {
		long currentUser_id = authenticationService.getCurrentUser()
				.getUserId();
		logger.debug(+currentUser_id + "/unfollowUser/" + otherUser_id);
		userMainService.unfollowUser(currentUser_id, otherUser_id);
	}

}
