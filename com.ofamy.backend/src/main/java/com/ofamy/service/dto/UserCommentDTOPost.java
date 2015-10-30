package com.ofamy.service.dto;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ofamy.util.JsonDateDeserializer;
import com.ofamy.util.JsonDateSerializer;
/**
 * 
 * @author Mohamed
 *
 */
public class UserCommentDTOPost {
	
	long userId;
	long offerId;
	String comment;
	
	
	public UserCommentDTOPost(long userId, long offerId, String comment) {
		super();
		this.userId = userId;
		this.offerId = offerId;
		this.comment = comment;
	}
	
	
	
	public UserCommentDTOPost() {
		super();
		// TODO Auto-generated constructor stub
	}



	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getOfferId() {
		return offerId;
	}
	public void setOfferId(long offerId) {
		this.offerId = offerId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "CommentDTOPost [userId=" + userId + ", offerId=" + offerId
				+ ", comment=" + comment + "]";
	}
	

	
	
	
}
