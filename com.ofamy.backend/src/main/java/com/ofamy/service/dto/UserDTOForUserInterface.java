package com.ofamy.service.dto;

import java.util.List;
/**
 * 
 * @author Mohamed
 *
 */
public class UserDTOForUserInterface {
	Long userId;
	String firstname;
	String lastname;
	String location;
	String profilepicture;
	String presentation;
	List<TrendsForUserProfile> trends;
	String status;
	
	

	public UserDTOForUserInterface(Long userId, String firstname, String lastname,
			String location, String profilepicture, String status) {
		super();
		this.userId = userId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.location = location;
		this.profilepicture = profilepicture;
		this.status = status;
	}

	public UserDTOForUserInterface() {
		// TODO Auto-generated constructor stub
	}

	public Long getUserId() {
		return userId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getProfilepicture() {
		return profilepicture;
	}

	public void setProfilepicture(String profilepicture) {
		this.profilepicture = profilepicture;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPresentation() {
		return presentation;
	}

	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	public List<TrendsForUserProfile> getTrends() {
		return trends;
	}

	public void setTrends(List<TrendsForUserProfile> trends) {
		this.trends = trends;
	}
	
	
	

}
