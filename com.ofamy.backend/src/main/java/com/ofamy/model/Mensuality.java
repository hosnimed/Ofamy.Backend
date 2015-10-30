package com.ofamy.model;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedToVia;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ofamy.util.JsonDateSerializer;


/**
 * Simple JavaBean domain object representing a Mensuality
 * 
 * @author Haithem
 *
 */
@NodeEntity
public class Mensuality {

	@GraphId
	private Long menualityId;
	@Indexed(unique=true,numeric=true)
	private int mensulaityCode; //represent a unique code..example : for JAN 2014 the code is : 12014, FEV 2015 : 22015,etc.
	
	@RelatedToVia(direction=Direction.INCOMING)
	@JsonIgnore
	private Set<PaysRelationShip> companies;
	
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date periode;
	
	
	

	public Mensuality() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mensuality(Date periode) {
		super();
		Calendar calendar=Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH) + 1;
		this.mensulaityCode=Integer.parseInt(""+month+""+calendar.get(Calendar.YEAR));
		this.periode = periode;
	}

	public Long getMenualityId() {
		return menualityId;
	}

	public void setMenualityId(Long menualityId) {
		this.menualityId = menualityId;
	}

	public Set<PaysRelationShip> getCompanies() {
		return companies;
	}

	public void setCompanies(Set<PaysRelationShip> companies) {
		this.companies = companies;
	}

	public Date getPeriode() {
		return periode;
	}

	public void setPeriode(Date periode) {
		this.periode = periode;
	}

	public int getMensulaityCode() {
		return mensulaityCode;
	}

	public void setMensulaityCode(int mensulaityCode) {
		this.mensulaityCode = mensulaityCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mensulaityCode;
		result = prime * result
				+ ((menualityId == null) ? 0 : menualityId.hashCode());
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
		Mensuality other = (Mensuality) obj;
		if (mensulaityCode != other.mensulaityCode)
			return false;
		if (menualityId == null) {
			if (other.menualityId != null)
				return false;
		} else if (!menualityId.equals(other.menualityId))
			return false;
		return true;
	}

	



}
