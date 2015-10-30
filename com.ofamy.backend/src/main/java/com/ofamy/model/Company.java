package com.ofamy.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.annotation.RelatedToVia;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ofamy.util.JsonDateSerializer;
import com.ofamy.util.RelationShipTypes;

/**
 * Simple JavaBean domain object representing a Company
 * 
 * @author Haithem
 * 
 *
 */

@TypeAlias("Company")
public class Company extends MainUser implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2258194655550698958L;
	
	@Indexed
	private String name;
	private String phone;
	private String description;
	private String logo;
	private String webSite;
	private long score;
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date creationDate;
	private Date lastUpadte;
	
	@RelatedToVia
	private Set<PaysRelationShip> mensualities;
	
	@RelatedTo(type=RelationShipTypes.PREPARE)
	private Set<OfferDefinition> offersDefinition;
	
	@RelatedTo(type=RelationShipTypes.PROPOSE)
	private Set<Offer> offers=new HashSet<Offer>();
	
	@RelatedTo(type=RelationShipTypes.COMPANY_BELONGTO_TREND)
	private @Fetch Set<Trend> trends=new HashSet<Trend>();
	
	@RelatedTo(type=RelationShipTypes.OWNER,direction=Direction.INCOMING)
	private Set<Product> myProducts=new HashSet<Product>();
	
	@RelatedTo(type=RelationShipTypes.ADDED_BY,direction=Direction.INCOMING)
	private Set<Reward> myRewards=new HashSet<Reward>();

	
	public Company() {
		super();
		creationDate=new Date();
	}
	
	public void addNewOfferTemplate(OfferDefinition template){
		if(offersDefinition==null){
			offersDefinition=new HashSet<OfferDefinition>();
		}
		offersDefinition.add(template);
	}
	
	public void addNewOffer(Offer offer){
		if(offers==null){
			offers=new HashSet<Offer>();
		}
		offers.add(offer);
	}

	public void followTrend(Trend trend){
		if(trends==null){
			trends = new HashSet<Trend>();
		}
		trends.add(trend);
	}
	
	public void addMensuality(Mensuality m){
		PaysRelationShip pays=new PaysRelationShip(this, m, new Date());
		if(mensualities==null){
			mensualities=new HashSet<PaysRelationShip>();
		}
		mensualities.add(pays);
	}
	
	public void addNewStatus(UserStatus us){
		UserStatusRelationShip userStatusRelship=new UserStatusRelationShip(this, us);
		super.getMyStatus().add(userStatusRelship);
	}
	
	public Company(String email, String password) {
		super(email, password);
		creationDate=new Date();
	}
	
	public Company(String email, String password, String name) {
		super(email, password);
		this.name = name;
		creationDate = new Date();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	
	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Set<Product> getMyProducts() {
		return myProducts;
	}

	public void setMyProducts(Set<Product> myProducts) {
		this.myProducts = myProducts;
	}

	public Set<Reward> getMyRewards() {
		return myRewards;
	}

	public void setMyRewards(Set<Reward> myRewards) {
		this.myRewards = myRewards;
	}

	public Set<PaysRelationShip> getMensualities() {
		return mensualities;
	}

	public void setMensualities(Set<PaysRelationShip> mensualities) {
		this.mensualities = mensualities;
	}

	public Set<OfferDefinition> getOffersDefinition() {
		return offersDefinition;
	}
	public void setOffersDefinition(Set<OfferDefinition> offersDefinition) {
		this.offersDefinition = offersDefinition;
	}
	public Set<Offer> getOffers() {
		return offers;
	}
	public void setOffers(Set<Offer> offers) {
		this.offers = offers;
	}
	
	public Set<Trend> getTrends() {
		return trends;
	}
	
	public void setTrends(Set<Trend> trends) {
		this.trends = trends;
	}

	public long getScore() {
		return score;
	}

	public void setScore(long score) {
		this.score = score;
	}

	public Date getLastUpadte() {
		return lastUpadte;
	}

	public void setLastUpadte(Date lastUpadte) {
		this.lastUpadte = lastUpadte;
	}

	@Override
	public String toString() {
		return "Company [:" + name + "]";
	}
	
	
	
	
	

}
