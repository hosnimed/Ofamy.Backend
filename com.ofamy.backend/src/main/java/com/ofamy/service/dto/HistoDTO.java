package com.ofamy.service.dto;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.ofamy.model.Offer;
import com.ofamy.repository.OfferRepository;

import com.ofamy.util.OfferStatusEnum;



public class HistoDTO {
	
	
	private long offerId;
	private String name;
	


	private Date creationDate;
	private Date endDate;
	
	private String status;
	
	private long adhereCount;
	
	/** ************/
	public long getOfferId() {
		return offerId;
	}

	public void setOfferId(long offerId) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getAdhereCount() {
		return adhereCount;
	}

	public void setAdhereCount(long adhereCount) {
		this.adhereCount = adhereCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/**** constructor ****/
	
	public HistoDTO(Offer offer)
	{
		this.offerId = offer.getOfferId();
		this.creationDate = offer.getCreationDate();
		this.endDate=offer.getEndDate();
		this.name=offer.getName();
		
	}

	
}
