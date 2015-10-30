package com.ofamy.service.dto;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ofamy.model.Offer;
import com.ofamy.util.JsonDateSerializer;
/**
 * 
 * @author Mohamed
 *
 */
public class UserOfferDTO {
	
	private long offerId;
	private String offerTitle;
	private long companyId;
	private String companyName;
	private double price;
	private String descriptionShort;
	private String offerSmallPicture;
	private String rewardPicture;
	
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date creation_date;
	private long followers_count;
	private long like_count; 
	private String currentStatus;
	
	
	
	
	public UserOfferDTO() {
		super();
		// TODO Auto-generated constructor stub
	}




	public long getOfferId() {
		return offerId;
	}




	public void setOfferId(long offerId) {
		this.offerId = offerId;
	}




	public String getOfferTitle() {
		return offerTitle;
	}




	public void setOfferTitle(String offerTitle) {
		this.offerTitle = offerTitle;
	}




	public long getCompanyId() {
		return companyId;
	}




	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}




	public String getCompanyName() {
		return companyName;
	}




	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}




	public double getPrice() {
		return price;
	}




	public void setPrice(double price) {
		this.price = price;
	}




	public String getDescriptionShort() {
		return descriptionShort;
	}




	public void setDescriptionShort(String descriptionShort) {
		this.descriptionShort = descriptionShort;
	}




	public String getOfferSmallPicture() {
		return offerSmallPicture;
	}




	public void setOfferSmallPicture(String offerSmallPicture) {
		this.offerSmallPicture = offerSmallPicture;
	}




	public String getRewardPicture() {
		return rewardPicture;
	}




	public void setRewardPicture(String rewardPicture) {
		this.rewardPicture = rewardPicture;
	}




	public Date getCreation_date() {
		return creation_date;
	}




	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}




	public long getFollowers_count() {
		return followers_count;
	}




	public void setFollowers_count(long followers_count) {
		this.followers_count = followers_count;
	}




	public long getLike_count() {
		return like_count;
	}




	public void setLike_count(long like_count) {
		this.like_count = like_count;
	}




	public String getCurrentStatus() {
		return currentStatus;
	}




	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	
	

}