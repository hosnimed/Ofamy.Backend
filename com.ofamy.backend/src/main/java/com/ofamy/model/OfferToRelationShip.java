package com.ofamy.model;


import java.util.Date;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

import com.ofamy.util.RelationShipTypes;


/**
 * Simple JavaBean domain object representing a RelationShip type Offer_To between Offer and User
 * 
 * @author Haithem
 * 
 *
 */

@RelationshipEntity(type=RelationShipTypes.OFFER_TO)
public class OfferToRelationShip {
	

	@GraphId 
	private Long id;
	
	@StartNode
	private Offer offer;
	@EndNode
	private User targetUser;
	
	private Date sentDate;
	
	

	public OfferToRelationShip() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public OfferToRelationShip(Offer offer, User targetUser) {
		super();
		this.offer = offer;
		this.targetUser = targetUser;
		this.sentDate = new Date();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public User getTargetUser() {
		return targetUser;
	}

	public void setTargetUser(User targetUser) {
		this.targetUser = targetUser;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		OfferToRelationShip other = (OfferToRelationShip) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
}
