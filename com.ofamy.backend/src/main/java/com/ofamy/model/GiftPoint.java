package com.ofamy.model;

import java.util.Date;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import com.ofamy.util.RelationShipTypes;

/**
 * Simple JavaBean domain object representing a GiftPoint
 * 
 * @author Haithem
 *
 */

@NodeEntity
public class GiftPoint {
	
	@GraphId
	private Long giftPointId;
	private int value;
	
	private Date lastUpdate;
	
	@RelatedTo(type=RelationShipTypes.SCORE,direction=Direction.INCOMING)
	private User user;
	
	public GiftPoint() {
		super();
		value=5;
	}

	
	public void addPoints(int points){
		   value+=points;
	}


	public Long getGiftPointId() {
		return giftPointId;
	}


	public void setGiftPointId(Long giftPointId) {
		this.giftPointId = giftPointId;
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
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
				+ ((giftPointId == null) ? 0 : giftPointId.hashCode());
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
		GiftPoint other = (GiftPoint) obj;
		if (giftPointId == null) {
			if (other.giftPointId != null)
				return false;
		} else if (!giftPointId.equals(other.giftPointId))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return String.valueOf(value);
	}


	
	
	

}
