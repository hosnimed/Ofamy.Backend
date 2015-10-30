package com.ofamy.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedToVia;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ofamy.util.OfferStatusEnum;

/**
 * Simple JavaBean domain object representing Offer's Status
 *      The status can be Public,Private or Closed
 *      
 * @author Haithem
 * 
 *
 */

@NodeEntity
public class OfferStatus {
	
	@GraphId
	private Long offerStatusId;
	private OfferStatusEnum status;
	
	private Date creationDate;
	
	@RelatedToVia(direction=Direction.INCOMING)
	@JsonIgnore
	private Set<OfferStatusRelationShip> offers=new HashSet<OfferStatusRelationShip>();
	
	

	public OfferStatus() {
		super();
		creationDate = new Date();
		//  Default status is private
		status = OfferStatusEnum.PRIVATE;
	}
	
	

	public OfferStatus(OfferStatusEnum status) {
		super();
		this.status = status;
		creationDate = new Date();
	}



	public Long getOfferStatusId() {
		return offerStatusId;
	}

	public void setOfferStatusId(Long offerStatusId) {
		this.offerStatusId = offerStatusId;
	}

	public OfferStatusEnum getStatus() {
		return status;
	}

	public void setStatus(OfferStatusEnum status) {
		this.status = status;
	}

	public Set<OfferStatusRelationShip> getOffers() {
		return offers;
	}

	public void setOffers(Set<OfferStatusRelationShip> offers) {
		this.offers = offers;
	}



	public Date getCreationDate() {
		return creationDate;
	}



	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((offerStatusId == null) ? 0 : offerStatusId.hashCode());
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
		OfferStatus other = (OfferStatus) obj;
		if (offerStatusId == null) {
			if (other.offerStatusId != null)
				return false;
		} else if (!offerStatusId.equals(other.offerStatusId))
			return false;
		return true;
	}

	

	
	
	

}
