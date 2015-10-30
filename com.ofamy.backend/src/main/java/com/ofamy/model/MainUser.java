package com.ofamy.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.annotation.RelatedToVia;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ofamy.util.RelationShipTypes;

/**
 * Simple JavaBean domain abstract_object representing a MainUser
 * 
 * @author Haithem
 * 
 */

@NodeEntity
public abstract class MainUser {

	@GraphId
	@Indexed
	private Long userId;

	@Indexed(unique = true)
	private String email;
	private String password;

	@RelatedTo(type = RelationShipTypes.IS_FROM)
	@Fetch
	private Location location;

	@RelatedToVia
	@JsonIgnore
	private Set<UserStatusRelationShip> myStatus = new HashSet<UserStatusRelationShip>();

	public MainUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MainUser(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}


	public Set<UserStatusRelationShip> getMyStatus() {
		return myStatus;
	}

	public void setMyStatus(Set<UserStatusRelationShip> myStatus) {
		this.myStatus = myStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		MainUser other = (MainUser) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	
	

	/*
	 * @Override public String toString() { return
	 * "Email : "+email+" | Password : "
	 * +password+" | Location : "+location+" | Status : "+status; }
	 */

}
