package com.ofamy.model;

import java.util.Date;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

import com.ofamy.util.RelationShipTypes;


@RelationshipEntity(type=RelationShipTypes.USER_STATUS)
public class UserStatusRelationShip {
	
	@GraphId
	private Long id;

	@StartNode
	private MainUser user;
	@EndNode
	private UserStatus userStatus;
	
	private Date startDate;
	private Date endDate;
	
	private String description;
	
	

	public UserStatusRelationShip() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public UserStatusRelationShip(MainUser user, UserStatus userStatus) {
		super();
		this.user = user;
		this.userStatus = userStatus;
		startDate= new Date();
		endDate = null;
		
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MainUser getUser() {
		return user;
	}

	public void setUser(MainUser user) {
		this.user = user;
	}

	public UserStatus getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
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
		UserStatusRelationShip other = (UserStatusRelationShip) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
