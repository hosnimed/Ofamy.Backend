package com.ofamy.model;

import java.util.Date;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

import com.ofamy.util.RelationShipTypes;

/**
 * Simple JavaBean domain object representing a RelationShip between User and Offer
 * 
 * @author Haithem
 * 
 */

@RelationshipEntity(type = RelationShipTypes.ADHERE_TO)
public class AdhereToRelationShip {

	@GraphId
	private Long id;

	@StartNode
	private User user;
	@EndNode
	private Offer targetOffer;

	private Date date;

	
	public AdhereToRelationShip() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdhereToRelationShip(User user, Offer target_offer, Date date) {
		super();
		this.user = user;
		this.targetOffer = target_offer;
		this.date = date;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	public Offer getTargetOffer() {
		return targetOffer;
	}

	public void setTargetOffer(Offer targetOffer) {
		this.targetOffer = targetOffer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
		AdhereToRelationShip other = (AdhereToRelationShip) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
