package com.ofamy.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ofamy.util.RelationShipTypes;

/**
 * Simple JavaBean domain Object representing a City
 * @author Haithem
 *
 */
@NodeEntity
public class City implements Serializable{
	
	@GraphId
	private Long cityID;
	
	@Indexed(unique=true)
	private String name;
	
	private String postalCode;
	private String country;
	
	@RelatedTo(type=RelationShipTypes.IS_LOCATED_IN,direction=Direction.INCOMING)
	@JsonIgnore
	private Set<Location> locations;
	
	@RelatedTo(type=RelationShipTypes.IS_IN,direction=Direction.INCOMING)
	@JsonIgnore
	private Set<Offer> offers;
	
	@RelatedTo(type=RelationShipTypes.IS_AVAILABLE_IN,direction=Direction.INCOMING)
	@JsonIgnore
	private Set<Reward> rewards;
	
	private Date creationDate;
	
	
	public City() {
		super();
	}

	public City(String name,String zipCode, String country) {
		super();
		this.name = name;
		this.postalCode = zipCode;
		this.country = country;
		creationDate = new Date();
	}

	public Long getCityID() {
		return cityID;
	}

	public void setCityID(Long cityID) {
		this.cityID = cityID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Set<Location> getLocations() {
		return locations;
	}

	public void setLocations(Set<Location> locations) {
		this.locations = locations;
	}

	public Set<Offer> getOffers() {
		return offers;
	}

	public void setOffers(Set<Offer> offers) {
		this.offers = offers;
	}

	public Set<Reward> getRewards() {
		return rewards;
	}

	public void setRewards(Set<Reward> rewards) {
		this.rewards = rewards;
	}
	

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		City other = (City) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	
	

}
