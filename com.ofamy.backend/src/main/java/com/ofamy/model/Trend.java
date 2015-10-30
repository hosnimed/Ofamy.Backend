package com.ofamy.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.annotation.RelatedToVia;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ofamy.util.RelationShipTypes;

/**
 * Simple JavaBean domain object representing a Trend
 * 
 * @author Haithem
 * 
 *
 */
@NodeEntity
public class Trend implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8931826080954374792L;

	@GraphId
	private Long nodeId;
	
	@Indexed(unique=true)
	private String name;
	private String category;
	private String description;
	
	private Date creationDate;
	private Date lastUpdate;
	
	@RelatedToVia(direction=Direction.INCOMING)
	@JsonIgnore
	private Set<FollowTrendRelShip> users=new HashSet<FollowTrendRelShip>();
	
	@RelatedTo(type=RelationShipTypes.COMPANY_BELONGTO_TREND,direction=Direction.INCOMING)
	@JsonIgnore
	private Set<Company> companies=new HashSet<Company>();
	
	@RelatedTo(type=RelationShipTypes.IS_UNDER,direction=Direction.INCOMING)
    @JsonIgnore
	private Set<Product> products;
	
	
	
	public Trend() {
		super();
	}
	
	
	
	public Trend(String name) {
		super();
		this.name = name;
		creationDate = new Date();
	}



	public Long getNodeId() {
		return nodeId;
	}
	public void setNodeId(Long nodeId) {
		this.nodeId = nodeId;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	public Set<FollowTrendRelShip> getUsers() {
		return users;
	}
	public void setUsers(Set<FollowTrendRelShip> users) {
		this.users = users;
	}
	public Set<Company> getCompanies() {
		return companies;
	}
	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
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

	


	public Set<Product> getProducts() {
		return products;
	}



	public void setProducts(Set<Product> products) {
		this.products = products;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nodeId == null) ? 0 : nodeId.hashCode());
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
		Trend other = (Trend) obj;
		if (nodeId == null) {
			if (other.nodeId != null)
				return false;
		} else if (!nodeId.equals(other.nodeId))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return name;
	}
	
	
	
	
	

}
