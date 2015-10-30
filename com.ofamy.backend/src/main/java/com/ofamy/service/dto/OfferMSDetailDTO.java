package com.ofamy.service.dto;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ofamy.model.Offer;
import com.ofamy.util.JsonDateSerializer;

public class OfferMSDetailDTO {
	private long offerId;
	private String name;
	private String product;
	private String reward;
	
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date creation_date;
	
	private String product_detailPicture1;
	private String product_detailPicture2;
	private String reward_detailPicture;
    private String product_description;
    private String raward_description;
    private boolean isLiked ;
	
    
    public String getProduct_detailPicture1() {
		return product_detailPicture1;
	}
	public void setProduct_detailPicture1(String product_detailPicture1) {
		this.product_detailPicture1 = product_detailPicture1;
	}
	public String getProduct_detailPicture2() {
		return product_detailPicture2;
	}
	public void setProduct_detailPicture2(String product_detailPicture2) {
		this.product_detailPicture2 = product_detailPicture2;
	}
	public String getReward_detailPicture() {
		return reward_detailPicture;
	}
	public void setReward_detailPicture(String reward_detailPicture) {
		this.reward_detailPicture = reward_detailPicture;
	}
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	public String getRaward_description() {
		return raward_description;
	}
	public void setRaward_description(String raward_description) {
		this.raward_description = raward_description;
	}
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
	
	public OfferMSDetailDTO(Offer offer) {
		super();
		this.offerId = offer.getOfferId();
		this.name = offer.getName();
		this.product = offer.getOfferDefinition().getProduct().getName();
		this.reward = offer.getOfferDefinition().getReward().getName();
		this.creation_date = offer.getCreationDate() ;
		this.setProduct_detailPicture1(offer.getOfferDefinition().getProduct().getDetailPicture1());
		this.setProduct_detailPicture2(offer.getOfferDefinition().getProduct().getDetailPicture2());

		this.setReward_detailPicture(offer.getOfferDefinition().getReward().getDetailPicture() );
		}
	public boolean isLiked() {
		return isLiked;
	}
	
	public void setLiked(boolean isLiked) {
		this.isLiked = isLiked;
	}
	
	
}
