package com.ofamy.service.dto;

import java.util.Date;

import com.ofamy.model.OfferDefinition;
import com.ofamy.model.Product;
import com.ofamy.model.Reward;

/**
 * 
 * @author Mohamed
 *
 */

public class UserOfferDefinitionDTO {
	
	private long offerDefinitionId;
	private String name;
	private Product product;
	private Reward reward;
	private Date creation_date;
	private long OffersBasedOn;
	private String description; 
	private int giftPoint;
	
	public UserOfferDefinitionDTO(OfferDefinition offerDef) {
		super();
		this.offerDefinitionId = offerDef.getOfferDefId();
		this.name = offerDef.getOfferDefName();
		this.product = offerDef.getProduct();
		this.reward = offerDef.getReward();
		this.creation_date = offerDef.getCreationDate();
		this.description = offerDef.getLongDescription();
		this.giftPoint = offerDef.getGiftPoint();
		}
	
	public long getOfferDefinitionId() {
		return offerDefinitionId;
	}
	public void setOfferDefinitionId(long offerDefinitionId) {
		this.offerDefinitionId = offerDefinitionId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Reward getReward() {
		return reward;
	}
	public void setReward(Reward reward) {
		this.reward = reward;
	}
	public Date getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	public long getOffersBasedOn() {
		return OffersBasedOn;
	}
	public void setOffersBasedOn(long offersBasedOn) {
		OffersBasedOn = offersBasedOn;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getGiftPoint() {
		return giftPoint;
	}
	public void setGiftPoint(int giftPoint) {
		this.giftPoint = giftPoint;
	}
	
	
}
