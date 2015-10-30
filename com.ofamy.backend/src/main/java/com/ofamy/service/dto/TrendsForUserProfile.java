package com.ofamy.service.dto;
/**
 * 
 * @author Mohamed
 *
 */
public class TrendsForUserProfile {

	long Id;
	String name;
	String status;
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
