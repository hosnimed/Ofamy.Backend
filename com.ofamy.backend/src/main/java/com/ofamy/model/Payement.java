package com.ofamy.model;

import java.io.Serializable;
import java.util.Date;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import com.ofamy.util.RelationShipTypes;


@NodeEntity
public class Payement implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -176877153352754940L;

	@GraphId
	private Long idPayement;
	
	private String nameOnCard;
	private String typeCard;
	@Indexed(unique=true,numeric=true)
	private long cardNumber;
	private Date expirationDate;
	
	private String address1;
	private String address2;
	
	private String country;
	private String city;
	private String state;
	private String zip;

	private Date creationDate;
	
	@RelatedTo(type=RelationShipTypes.PAYEMENT_METHOD,direction=Direction.INCOMING)
	private User user;

	
	

	public Payement() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getIdPayement() {
		return idPayement;
	}


	public void setIdPayement(Long idPayement) {
		this.idPayement = idPayement;
	}


	public String getNameOnCard() {
		return nameOnCard;
	}


	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}


	public long getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}


	public Date getExpirationDate() {
		return expirationDate;
	}


	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}


	public String getAddress1() {
		return address1;
	}


	public void setAddress1(String address1) {
		this.address1 = address1;
	}


	public String getAddress2() {
		return address2;
	}


	public void setAddress2(String address2) {
		this.address2 = address2;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getTypeCard() {
		return typeCard;
	}


	public void setTypeCard(String typeCard) {
		this.typeCard = typeCard;
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
		result = prime * result
				+ ((idPayement == null) ? 0 : idPayement.hashCode());
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
		Payement other = (Payement) obj;
		if (idPayement == null) {
			if (other.idPayement != null)
				return false;
		} else if (!idPayement.equals(other.idPayement))
			return false;
		return true;
	}
	
	
	
	

}
