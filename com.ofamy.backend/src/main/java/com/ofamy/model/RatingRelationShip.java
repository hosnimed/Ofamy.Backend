package com.ofamy.model;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

import com.ofamy.util.RelationShipTypes;

/**
 * Simple JavaBean domain object representing a RelationShip type rate between
 * User and Offer
 * 
 * @author Haithem
 * 
 */

@RelationshipEntity(type = RelationShipTypes.RATED)
public class RatingRelationShip {

	public static final int MAX_STARS = 5;
	public static final int MIN_STARS = 0;

	@GraphId
	private Long id;

	@StartNode
	private User user;
	@EndNode
	private Offer offer;

	private double stars;

	public RatingRelationShip() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RatingRelationShip(User user, Offer offer, int stars) {
		super();
		this.user = user;
		this.offer = offer;
		if (stars >= MIN_STARS && stars <= MAX_STARS)
			this.stars = stars;
		else
			this.stars = 1;
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

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public double getStars() {
		return stars;
	}

	public void setStars(double stars) {
		this.stars = stars;
	}

	public RatingRelationShip rate(int stars, String comment) {
		if (stars >= MIN_STARS && stars <= MAX_STARS)
			this.stars = stars;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		RatingRelationShip rating = (RatingRelationShip) o;
		if (id == null)
			return super.equals(o);
		return id.equals(rating.id);

	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : super.hashCode();
	}

}
