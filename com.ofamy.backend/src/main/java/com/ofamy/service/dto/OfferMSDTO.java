package com.ofamy.service.dto;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ofamy.model.Company;
import com.ofamy.model.Offer;
import com.ofamy.util.JsonDateSerializer;




public class OfferMSDTO {

	
	private long offerId;
	private String name;
	private String product;
	private String reward;
	private double price ; 
	
	private long companyId;
	private String companyName;
	
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date creation_date;
	
	private String  description;
	private String product_picture;
	private String reward_picture;
	
	
	//________________
	
	public long getOfferId() {
		return offerId;
	}
	public void setOfferId(long offerId) {
		this.offerId = offerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getReward() {
		return reward;
	}
	public void setReward(String reward) {
		this.reward = reward;
	}
	

	public OfferMSDTO()
	{
		System.out.println("default");
	}
	
	public OfferMSDTO(Offer offer) {
		super();
		this.offerId = offer.getOfferId();
		this.name = offer.getName();
		this.product = offer.getOfferDefinition().getProduct().getName();
		this.reward = offer.getOfferDefinition().getReward().getName();
		this.creation_date = offer.getCreationDate();
		this.setProduct_picture(offer.getOfferDefinition().getProduct().getTimelinePicture());
		this.setReward_picture(offer.getOfferDefinition().getReward().getTimlinePicture());
		this.setPrice(offer.getOfferDefinition().getProduct().getBudget());
		this.setCompanyId(offer.getOfferDefinition().getOwner().getUserId());
		this.setCompanyName(offer.getOfferDefinition().getOwner().getName() );
	}
	
	
	
	
	public String getProduct_picture() {
		return product_picture;
	}
	public void setProduct_picture(String product_picture) {
		this.product_picture = product_picture;
	}
	public String getReward_picture() {
		return reward_picture;
	}
	public void setReward_picture(String reward_picture) {
		this.reward_picture = reward_picture;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
		return price ;
	}
	public void setPrice(double price) {
		 this.price = price;
	}
	
	
	
	
}
