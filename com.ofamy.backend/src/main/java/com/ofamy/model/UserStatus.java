package com.ofamy.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedToVia;

import com.ofamy.util.UserStatusEnum;

/**
 * Simple JavaBean domain object representing User's Status 
 *    The status can be Pending, Suspended or Active
 * 
 * @author Haithem
 *
 */

@NodeEntity
public class UserStatus {
	
	@GraphId
	private Long userStatusId;
	@Indexed
	private UserStatusEnum status;
	
	private Date creationDate;
	
	
	@RelatedToVia(direction=Direction.INCOMING)
	private Set<UserStatusRelationShip> users=new HashSet<UserStatusRelationShip>();
	

	public UserStatus() {
		super();
		// Default UserStatus is Pending
		status = UserStatusEnum.PENDING;
		creationDate = new Date();
	}

	public UserStatus(UserStatusEnum status) {
		super();
		this.status = status;
		creationDate = new Date();
	}

	
	public Long getUserStatusId() {
		return userStatusId;
	}

	public void setUserStatusId(Long userStatusId) {
		this.userStatusId = userStatusId;
	}

	public UserStatusEnum getStatus() {
		return status;
	}

	public void setStatus(UserStatusEnum status) {
		this.status = status;
	}



	public Set<UserStatusRelationShip> getUsers() {
		return users;
	}

	public void setUsers(Set<UserStatusRelationShip> users) {
		this.users = users;
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
		result = prime * result + ((userStatusId == null) ? 0 : userStatusId.hashCode());
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
		UserStatus other = (UserStatus) obj;
		if (userStatusId == null) {
			if (other.userStatusId != null)
				return false;
		} else if (!userStatusId.equals(other.userStatusId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return status.name().toString();
	}
	
	
	


}
