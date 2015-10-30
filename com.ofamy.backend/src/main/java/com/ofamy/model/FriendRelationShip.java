package com.ofamy.model;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

import com.ofamy.util.RelationShipTypes;

/**
 * Simple JavaBean domain object representing a Friendship relation between two users
 *
 * @author Haithem
 *
 */

@RelationshipEntity(type=RelationShipTypes.FRIEND)
public class FriendRelationShip {
	
	@GraphId
	private Long id;
	
	@StartNode
	private User currentUser;
	@EndNode
	@Fetch
	private User followedUser;
	
	private Date since;
	
	

	public FriendRelationShip(User currentUser, User followedUser, Date since) {
		super();
		this.currentUser = currentUser;
		this.followedUser = followedUser;
		this.since = since;
	}



	public FriendRelationShip() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public User getCurrentUser() {
		return currentUser;
	}



	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}



	public User getFollowedUser() {
		return followedUser;
	}



	public void setFollowedUser(User followedUser) {
		this.followedUser = followedUser;
	}



	public Date getSince() {
		return since;
	}



	public void setSince(Date since) {
		this.since = since;
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
		FriendRelationShip other = (FriendRelationShip) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}




}
