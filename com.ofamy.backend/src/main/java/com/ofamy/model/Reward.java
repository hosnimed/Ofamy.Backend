package com.ofamy.model;

import java.io.Serializable;
import java.util.Date;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ofamy.util.Gender;
import com.ofamy.util.RelationShipTypes;

/**
 * Simple JavaBean domain object representing a Reward
 * 
 * @author Haithem
 * 
 * 
 */
@NodeEntity
public class Reward implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3288659567251508472L;

	@GraphId
	private Long rewardId;

	@Indexed(unique = true)
	private String name;
	private String description;
	private double budget; // Less than @budget

	private Date creationDate;
	private Date lastUpdate;
	
	private String timlinePicture;
	private String detailPicture;

	private int age;
	private Gender gender;

	private double price; // only if ofamy is the owner
	private int quantity;

	@RelatedTo(type = RelationShipTypes.REWARDED, direction = Direction.INCOMING)
	@JsonIgnore
	private Iterable<OfferDefinition> offersTemplate;

	@RelatedTo(type = RelationShipTypes.IS_AVAILABLE_IN)
	private @Fetch City city; // if null, reward's location ...

	@RelatedTo(type = RelationShipTypes.ADDED_BY)
	@JsonIgnore
	private Company company; // null when the owner is ofamy

	public Reward() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reward(String name, String description, double budget) {
		super();
		this.name = name;
		this.description = description;
		this.budget = budget;
		creationDate = new Date();
	}

	public Long getRewardId() {
		return rewardId;
	}

	public void setRewardId(Long rewardId) {
		this.rewardId = rewardId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Iterable<OfferDefinition> getOffersTemplate() {
		return offersTemplate;
	}

	public void setOffersTemplate(Iterable<OfferDefinition> offersTemplate) {
		this.offersTemplate = offersTemplate;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	
	public String getTimlinePicture() {
		return timlinePicture;
	}

	public void setTimlinePicture(String timlinePicture) {
		this.timlinePicture = timlinePicture;
	}

	public String getDetailPicture() {
		return detailPicture;
	}

	public void setDetailPicture(String detailPicture) {
		this.detailPicture = detailPicture;
	}

	

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((rewardId == null) ? 0 : rewardId.hashCode());
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
		Reward other = (Reward) obj;
		if (rewardId == null) {
			if (other.rewardId != null)
				return false;
		} else if (!rewardId.equals(other.rewardId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	

}
