package com.ofamy.model;

import java.util.Date;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

import com.ofamy.util.RelationShipTypes;

@RelationshipEntity(type=RelationShipTypes.PAYS)
public class PaysRelationShip {
	
	@GraphId
	private Long id;

	@StartNode
	private Company company;
	@EndNode
	private Mensuality mensuality;
    
	private Date paymentDate;
	
	

	public PaysRelationShip() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaysRelationShip(Company company, Mensuality mensuality,
			Date paymentDate) {
		super();
		this.company = company;
		this.mensuality = mensuality;
		this.paymentDate = paymentDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Mensuality getMensuality() {
		return mensuality;
	}

	public void setMensuality(Mensuality mensuality) {
		this.mensuality = mensuality;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
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
		PaysRelationShip other = (PaysRelationShip) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	

}
