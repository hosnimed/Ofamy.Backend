package com.ofamy.model;

import java.util.Date;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

import com.ofamy.util.RelationShipTypes;

/**
 *  Simple JavaBean domain object representing The following RelationShip between User and Trend
 *  
 * @author Haithem
 *
 */

@RelationshipEntity(type=RelationShipTypes.FOLLOW_TREND)
public class FollowTrendRelShip {
	
	@GraphId
	private Long id;

	@StartNode
	private User user;
	@EndNode
	private Trend trend;
	
	private Date startDate;
	
	

	public FollowTrendRelShip() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FollowTrendRelShip(User user, Trend trend) {
		super();
		this.user = user;
		this.trend = trend;
		startDate=new Date();
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

	public Trend getTrend() {
		return trend;
	}

	public void setTrend(Trend trend) {
		this.trend = trend;
	}

	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
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
		FollowTrendRelShip other = (FollowTrendRelShip) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

	
	


}
