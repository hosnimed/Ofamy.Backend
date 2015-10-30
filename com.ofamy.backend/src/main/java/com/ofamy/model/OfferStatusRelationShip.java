package com.ofamy.model;

import java.util.Date;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

import com.ofamy.util.RelationShipTypes;

@RelationshipEntity(type=RelationShipTypes.OFFER_STATUS)
public class OfferStatusRelationShip {

	@GraphId
	private Long id;

	@StartNode
	private Offer offer;
	@EndNode
	private OfferStatus offerStatus;
	
	private Date startDate;
	private Date endDate;
	
	private String description;
	
	

	public OfferStatusRelationShip() {
		super();
	}

	
	
	public OfferStatusRelationShip(Offer offer, OfferStatus offerStatus,Date startDate,Date endDate) {
		super();
		this.offer = offer;
		this.offerStatus = offerStatus;
		this.startDate = startDate;
		this.endDate = endDate;
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



	public OfferStatus getOfferStatus() {
		return offerStatus;
	}

	public void setOfferStatus(OfferStatus offerStatus) {
		this.offerStatus = offerStatus;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		OfferStatusRelationShip other = (OfferStatusRelationShip) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}

