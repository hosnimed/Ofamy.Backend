package com.ofamy.model;

import java.util.Date;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

import com.ofamy.util.RelationShipTypes;

/**
 * Simple JavaBean domain object representing a RelationShip type Comments
 * between User and Offer
 * 
 * @author Haithem
 * 
 */

@RelationshipEntity(type = RelationShipTypes.COMMENTS)
public class CommentsRelationShip {

	@GraphId
	private Long id;

	@StartNode
	private @Fetch User user;
	@EndNode
	private Offer targetOffer;

	private Date commentDate;
	private String comment;

	public CommentsRelationShip() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentsRelationShip(User user, Offer targetOffer, Date date,
			String comment) {
		super();
		this.user = user;
		this.targetOffer = targetOffer;
		this.commentDate = date;
		this.comment = comment;
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

	public Offer getTargetOffer() {
		return targetOffer;
	}

	public void setTargetOffer(Offer targetOffer) {
		this.targetOffer = targetOffer;
	}

	

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
		CommentsRelationShip other = (CommentsRelationShip) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
