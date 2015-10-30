package com.ofamy.service.dto;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ofamy.util.JsonDateSerializer;
/**
 * 
 * @author Mohamed
 *
 */

public class UserCommentDTO {
	
	private Long commentId;
	private Long userId;
	private String first_name;
	private String last_name;
	private String picture;
	private String comment;
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date date;
	
	public UserCommentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	
	
}
