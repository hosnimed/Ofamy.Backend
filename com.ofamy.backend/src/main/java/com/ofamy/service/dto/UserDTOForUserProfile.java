package com.ofamy.service.dto;
/**
 * 
 * @author Mohamed
 *
 */
public class UserDTOForUserProfile {

	String email;
	String description;
	int score;
	long nb_follwers;
	long nb_followings;
	
	
	public UserDTOForUserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public long getNb_follwers() {
		return nb_follwers;
	}


	public void setNb_follwers(long nb_follwers) {
		this.nb_follwers = nb_follwers;
	}


	public long getNb_followings() {
		return nb_followings;
	}


	public void setNb_followings(long nb_followings) {
		this.nb_followings = nb_followings;
	}
	
	
}
