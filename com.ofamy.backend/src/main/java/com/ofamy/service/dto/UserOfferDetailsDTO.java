package com.ofamy.service.dto;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ofamy.model.Offer;
import com.ofamy.model.RatingRelationShip;
import com.ofamy.util.JsonDateSerializer;
/**
 * 
 * @author Mohamed
 *
 */
public class UserOfferDetailsDTO {
private static final Logger logger=LoggerFactory.getLogger(UserOfferDetailsDTO.class);

	private long offerId;
	private String offerTitle;	
	private double price;
	private String rate;
	private String offerCity;
		
	private long companyId;
	private String companyName;
	
	
	private String descriptionLong;
	private String rewardTitle	;
	private String rewardDescription;
	
	
	
	private String offerBigPicture1;
	private String offerBigPicture2;
	private String offerBigPicture3;
	private String rewardPicture;
	private String companyPicture;
	
	private long followers_count;
	private long like_count;
	private long comments_count;

	@JsonSerialize(using=JsonDateSerializer.class)
	private Date creation_date;
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date end_date;
	private String currentStatus;
	
	private List<UserCommentDTO> comments;



	public UserOfferDetailsDTO() {
	}

	public long getOfferId() {
		return offerId;
	}

	public void setOfferId(long offerId) {
		this.offerId = offerId;
	}

	
	
	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
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

	
	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
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

	public String getOfferBigPicture3() {
		return offerBigPicture3;
	}

	public void setOfferBigPicture3(String offerBigPicture3) {
		this.offerBigPicture3 = offerBigPicture3;
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

	public String calculateRate(Offer offer) {
	double rate=0.0;
	int s=0;
	Iterable<RatingRelationShip> ratings=offer.getRatings();
	if(ratings !=null ){
	for (Iterator<RatingRelationShip> it = ratings.iterator(); it.hasNext();) {
		RatingRelationShip rating = (RatingRelationShip) it.next();
		 rate+=rating.getStars();
			s++;
		}
		logger.info("Rate:S =="+rate+":"+s);	
		rate= rate/s;
	}
//	logger.info("Decimal Format :"+getFormatter().format(rate));
	return  getFormatter().format(rate);
	
	}
	
	private NumberFormat getFormatter(){
		 NumberFormat formatter ;
		/**		 Arrondir au centime		*/
		formatter = new DecimalFormat("#0.00");
	return formatter;
	}

	
	
	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	@Override
	public String toString() {
		return "OfferDetailsDTO [offerId=" + offerId + ", offerTitle="
				+ offerTitle + ", price=" + price + ", rate=" + rate
				+ ", offerCity=" + offerCity + ", companyId=" + companyId
				+ ", companyName=" + companyName + ", descriptionLong="
				+ descriptionLong + ", rewardTitle=" + rewardTitle
				+ ", rewardDescription=" + rewardDescription
				+ ", offerBigPicture1=" + offerBigPicture1
				+ ", offerBigPicture2=" + offerBigPicture2
				+ ", offerBigPicture3=" + offerBigPicture3 + ", rewardPicture="
				+ rewardPicture + ", companyPicture=" + companyPicture
				+ ", followers_count=" + followers_count + ", like_count="
				+ like_count + ", comments_count=" + comments_count
				+ ", comments=" + comments + "]";
	}
	
	
	

	
		
	
}
