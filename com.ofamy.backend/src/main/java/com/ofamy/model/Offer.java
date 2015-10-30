package com.ofamy.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.annotation.RelatedToVia;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ofamy.util.JsonDateSerializer;
import com.ofamy.util.RelationShipTypes;


 
/**
 * Simple JavaBean domain object representing an Offer
 * 
 * @author Haithem
 *
 */


@NodeEntity
public class Offer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5664140976003777430L;

	@GraphId
	private Long offerId;
	
	@Indexed(unique=true)
	private String name;
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date creationDate;
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date endDate;
	private Date pickupDate;
	private String pickupPlace;
	private String link;
	private String description;
	
	
	
	@RelatedTo(type=RelationShipTypes.IS_BASED_ON)
	private @Fetch OfferDefinition offerDefinition;
	
	@RelatedToVia
	@JsonIgnore
	private Set<OfferStatusRelationShip> offerstatus=new HashSet<OfferStatusRelationShip>();
	
	
	@RelatedToVia
	@JsonIgnore
	private OfferToRelationShip targetUser; // This can be a set of TargetUser in a future update
	
	@RelatedTo(type=RelationShipTypes.RELATED_TO)
	//@JsonIgnore
	private @Fetch Trend trend;						
	
	@RelatedToVia(direction=Direction.INCOMING)
	@JsonIgnore
	private @Fetch Iterable<CommentsRelationShip> comments;		//il y a un probleme ici!!!
	
	@RelatedToVia(direction=Direction.INCOMING)
	@JsonIgnore
	private Iterable<RatingRelationShip> ratings;
	
	@RelatedToVia(direction=Direction.INCOMING)
	@JsonIgnore
	private Iterable<AdhereToRelationShip> confirmedUsers;
	
	@RelatedToVia(direction=Direction.INCOMING)
	@JsonIgnore
	private @Fetch Set<LikeRelationShip> likes; // unlike ??
	
	@RelatedTo(type=RelationShipTypes.PROPOSE,direction=Direction.INCOMING)
	@JsonIgnore
	private Company owner;
	

	@RelatedTo(type=RelationShipTypes.IS_IN)
	private City city;
	
	private Date lastUpdate;
	
	
	
	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Offer(String name,String description) {
		super();
		this.name = name;
		this.creationDate = new Date();
		this.description = description;
	}
	
	public void addNewStatus(OfferStatus us,Date startDate,Date endDate){
		OfferStatusRelationShip offerStatusRel=new OfferStatusRelationShip(this, us,startDate,endDate);
		offerstatus.add(offerStatusRel);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public Set<LikeRelationShip> getLikes() {
		return likes;
	}

	public void setLikes(Set<LikeRelationShip> likes) {
		this.likes = likes;
	}

	public Long getOfferId() {
		return offerId;
	}

	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}

	public String getPickupPlace() {
		return pickupPlace;
	}

	public void setPickupPlace(String pickupPlace) {
		this.pickupPlace = pickupPlace;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public OfferDefinition getOfferDefinition() {
		return offerDefinition;
	}

	public void setOfferDefinition(OfferDefinition offerDefinition) {
		this.offerDefinition = offerDefinition;
	}

	
	
	

	public Set<OfferStatusRelationShip> getOfferstatus() {
		return offerstatus;
	}

	public void setOfferstatus(Set<OfferStatusRelationShip> offerstatus) {
		this.offerstatus = offerstatus;
	}

	public OfferToRelationShip getTargetUser() {
		return targetUser;
	}

	public void setTargetUser(OfferToRelationShip targetUser) {
		this.targetUser = targetUser;
	}

	public Trend getTrend() {
		return trend;
	}

	public void setTrend(Trend trend) {
		this.trend = trend;
	}

	

	public Iterable<CommentsRelationShip> getComments() {
		return comments;
	}

	public void setComments(Iterable<CommentsRelationShip> comments) {
		this.comments = comments;
	}

	public void setComments(Set<CommentsRelationShip> comments) {
		this.comments = comments;
	}

	public Iterable<RatingRelationShip> getRatings() {
		return ratings;
	}

	public void setRatings(Iterable<RatingRelationShip> ratings) {
		this.ratings = ratings;
	}

	public Iterable<AdhereToRelationShip> getConfirmedUsers() {
		return confirmedUsers;
	}

	public void setConfirmedUsers(Iterable<AdhereToRelationShip> confirmedUsers) {
		this.confirmedUsers = confirmedUsers;
	}
	
	
	
	public Company getOwner() {
		return owner;
	}

	public void setOwner(Company owner) {
		this.owner = owner;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Offer offer = (Offer) o;
        if (offerId == null) return super.equals(o);
        return offerId.equals(offer.offerId);

    }
	
	

    public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
    public int hashCode() {
        return offerId != null ? offerId.hashCode() : super.hashCode();
    }

	@Override
	public String toString() {
		return "Offer [offerId=" + offerId + ", name=" + name
				+ ", creation_date=" + creationDate + ", company=" + owner
				+ ", trend=" + trend + "]";
	}

	
	
    
	
	
	

	
}
