package com.ofamy.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ofamy.util.RelationShipTypes;

/**
 * Simple JavaBean domain object representing OfferDefinition
 * 
 * @author Haithem
 * 
 *
 */

@NodeEntity
public class OfferDefinition implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2804268467871360796L;

	@GraphId
	private Long offerDefId;
	@Indexed(unique=true)
	private String offerDefName;
	private int minDeal;
	private int maxDeal;
	
	private Date creationDate;
	private Date lastUpdate;
	
	private String longDescription;
	private String shortDescription;
	
	
	@RelatedTo(type=RelationShipTypes.CONCERNS)
	private @Fetch Product product;
	
	@RelatedTo(type=RelationShipTypes.REWARDED)
	private @Fetch Reward reward;
	
	@RelatedTo(type=RelationShipTypes.PREPARE,direction=Direction.INCOMING)
	@JsonIgnore
	private   Company owner;
	
	@RelatedTo(type=RelationShipTypes.IS_BASED_ON,direction=Direction.INCOMING)
	@JsonIgnore
	private @Fetch Set<Offer> offersBasedOn;
	
	private int giftPoint;

	
	public OfferDefinition() {
		super();
	}
	
	public OfferDefinition(Product product,Reward reward) {
		super();
		creationDate=new Date();
        this.product=product;
        this.reward=reward;
        int budget=(int)this.product.getBudget();
        // just an example
		if(budget > 100) {
			giftPoint=5;
		} else
			if(budget > 100 && budget <500){
				giftPoint=10;

			}else{
				giftPoint=20;

			}
	}
	
	public Long getOfferDefId() {
		return offerDefId;
	}
	public void setOfferDefId(Long offerDefId) {
		this.offerDefId = offerDefId;
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
	
	
	
	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public int getMinDeal() {
		return minDeal;
	}

	public void setMinDeal(int minDeal) {
		this.minDeal = minDeal;
	}

	public int getMaxDeal() {
		return maxDeal;
	}

	public void setMaxDeal(int maxDeal) {
		this.maxDeal = maxDeal;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getGiftPoint() {
		return giftPoint;
	}

	public void setGiftPoint(int giftPoint) {
		this.giftPoint = giftPoint;
	}
	
	

	public Company getOwner() {
		return owner;
	}

	public void setOwner(Company owner) {
		this.owner = owner;
	}
	

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((offerDefId == null) ? 0 : offerDefId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OfferDefinition other = (OfferDefinition) obj;
		if (offerDefId == null) {
			if (other.offerDefId != null)
				return false;
		} else if (!offerDefId.equals(other.offerDefId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OfferDefinition []";
	}

	public String getOfferDefName() {
		return offerDefName;
	}

	public void setOfferDefName(String offerDefName) {
		this.offerDefName = offerDefName;
	}

	public Set<Offer> getOffersBasedOn() {
		return offersBasedOn;
	}

	public void setOffersBasedOn(Set<Offer> offersBasedOn) {
		this.offersBasedOn = offersBasedOn;
	}
	
	
	
	

}
