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
import com.ofamy.util.RelationShipTypes;

/**
 * Simple JavaBean domain object representing a Product
 * 
 * @author Haithem
 * 
 *
 */

@NodeEntity
public class Product implements Serializable {
		
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 161928607890979537L;

	@GraphId
	private Long productId;
	
	@Indexed(unique=true)
	private String name;
	private double budget;
	private String description;
	private Date creationDate;
	private Date lastUpdate;
	private String timelinePicture;
	private String detailPicture1;
	private String detailPicture2;
	private String detailPicture3;
	private int quantity;
	
	@RelatedTo(type=RelationShipTypes.OWNER)
	@JsonIgnore
	private Company company;
	
	@RelatedTo(type=RelationShipTypes.CONCERNS,direction=Direction.INCOMING)
	@JsonIgnore
	private  Iterable<OfferDefinition> offersDefinition;

	@RelatedTo(type=RelationShipTypes.IS_UNDER)
	private @Fetch Trend trend;

	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String name, double budget, String description
			) {
		super();
		this.name = name;
		this.budget = budget;
		this.description = description;
		this.creationDate = new Date();
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getTimelinePicture() {
		return timelinePicture;
	}

	public void setTimelinePicture(String timelinePicture) {
		this.timelinePicture = timelinePicture;
	}

	public String getDetailPicture1() {
		return detailPicture1;
	}

	public void setDetailPicture1(String detailPicture1) {
		this.detailPicture1 = detailPicture1;
	}

	public String getDetailPicture2() {
		return detailPicture2;
	}

	public void setDetailPicture2(String detailPicture2) {
		this.detailPicture2 = detailPicture2;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Iterable<OfferDefinition> getOffersDefinition() {
		return offersDefinition;
	}

	public void setOffersDefinition(Iterable<OfferDefinition> offersDefinition) {
		this.offersDefinition = offersDefinition;
	}
	
	
	
	
	public String getDetailPicture3() {
		return detailPicture3;
	}

	public void setDetailPicture3(String detailPicture3) {
		this.detailPicture3 = detailPicture3;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;
        if (productId == null) return super.equals(o);
        return productId.equals(product.productId);

    }

    @Override
    public int hashCode() {
        return productId != null ? productId.hashCode() : super.hashCode();
    }

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Trend getTrend() {
		return trend;
	}

	public void setTrend(Trend trend) {
		this.trend = trend;
	}
    
	
    


}
