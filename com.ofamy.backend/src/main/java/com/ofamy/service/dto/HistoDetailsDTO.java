package com.ofamy.service.dto;

import java.util.List;

import com.ofamy.model.Offer;

public class HistoDetailsDTO {
	
	
	private long offerId;
	private String offerTitle;	
	private double price;
	private double rate;
	private String offerCity;
		
	private long companyId;
	private String companyName;
	
	
	private String descriptionLong;
	private String rewardTitle	;
	private String rewardDescription;
	
	
	
	private String offerBigPicture1;
	private String offerBigPicture2;
	
	private String rewardPicture;
	private String companyPicture;
	
	private long followers_count;
	private long like_count;
	private long comments_count;
	
	
	private List<UserCommentDTO> comments;

	private String status;

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getOfferCity() {
		return offerCity;
	}

	public void setOfferCity(String offerCity) {
		this.offerCity = offerCity;
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

	public String getDescriptionLong() {
		return descriptionLong;
	}

	public void setDescriptionLong(String descriptionLong) {
		this.descriptionLong = descriptionLong;
	}

	public String getRewardTitle() {
		return rewardTitle;
	}

	public void setRewardTitle(String rewardTitle) {
		this.rewardTitle = rewardTitle;
	}

	public String getRewardDescription() {
		return rewardDescription;
	}

	public void setRewardDescription(String rewardDescription) {
		this.rewardDescription = rewardDescription;
	}

	public String getOfferBigPicture1() {
		return offerBigPicture1;
	}

	public void setOfferBigPicture1(String offerBigPicture1) {
		this.offerBigPicture1 = offerBigPicture1;
	}

	public String getOfferBigPicture2() {
		return offerBigPicture2;
	}

	public void setOfferBigPicture2(String offerBigPicture2) {
		this.offerBigPicture2 = offerBigPicture2;
	}

	

	public String getRewardPicture() {
		return rewardPicture;
	}

	public void setRewardPicture(String rewardPicture) {
		this.rewardPicture = rewardPicture;
	}

	public String getCompanyPicture() {
		return companyPicture;
	}

	public void setCompanyPicture(String companyPicture) {
		this.companyPicture = companyPicture;
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

	public long getComments_count() {
		return comments_count;
	}

	public void setComments_count(long comments_count) {
		this.comments_count = comments_count;
	}

	public List<UserCommentDTO> getComments() {
		return comments;
	}

	public void setComments(List<UserCommentDTO> comments) {
		this.comments = comments;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public HistoDetailsDTO(Offer offer)
	{
		
		
		
		this.offerId=offer.getOfferId() ;
		this.offerTitle = offer.getName() ;	
		this.price = offer.getOfferDefinition().getProduct().getBudget() ;
		//this.rate = offer.calculateRate() ;
		offerCity = offer.getCity().toString() ;
			
		this.companyId = offer.getOwner().getUserId() ;
		this.companyName = offer.getOwner().getName() ;
		
		
		this.descriptionLong = offer.getDescription() ;
		this.rewardTitle =  offer.getOfferDefinition().getReward().getName()	;
		this.rewardDescription = offer.getOfferDefinition().getReward().getDescription() ;
		
		
		
		this.offerBigPicture1 = offer.getOfferDefinition().getProduct().getDetailPicture1() ;
		this.offerBigPicture2 = offer.getOfferDefinition().getProduct().getDetailPicture2() ;
		
		this.rewardPicture = offer.getOfferDefinition().getReward().getDetailPicture() ;
		this.companyPicture = offer.getOfferDefinition().getOwner().getLogo() ;

		
		
	}
	

}
