package com.ofamy.model;


import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ofamy.util.RelationShipTypes;

/**
 * Simple JavaBean domain object representing a User's Location
 * 
 * @author Haithem
 * 
 *
 */

@NodeEntity
public class Location {
	
	@GraphId
	private Long locationId;
	
	private String adress;
	
	@RelatedTo(type=RelationShipTypes.IS_LOCATED_IN)
	private @Fetch City city;
	
	@RelatedTo(type=RelationShipTypes.IS_FROM,direction=Direction.INCOMING)
	@JsonIgnore
	private MainUser user;
	

	public Location() {
		super();
	}
	
	public Location(String adress) {
		super();
		this.adress = adress;
	}
	
	
	
	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public MainUser getUser() {
		return user;
	}
	public void setUser(MainUser user) {
		this.user = user;
	}
	
	

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((locationId == null) ? 0 : locationId.hashCode());
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
		Location other = (Location) obj;
		if (locationId == null) {
			if (other.locationId != null)
				return false;
		} else if (!locationId.equals(other.locationId))
			return false;
		return true;
	}
	


	

	

}
