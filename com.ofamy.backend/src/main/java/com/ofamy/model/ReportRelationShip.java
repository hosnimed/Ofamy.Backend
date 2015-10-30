package com.ofamy.model;

import java.util.Date;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

import com.ofamy.util.RelationShipTypes;

/**
 * Simple JavaBean domain object representing a RelationShip report between User
 * two users
 * 
 * @author Haithem
 * 
 * 
 */

@RelationshipEntity(type = RelationShipTypes.REPORT_USER)
public class ReportRelationShip {

	@GraphId
	private Long id;

	@StartNode
	private User currentUser;
	@EndNode
	private User reportedUser;

	private Date reportDate;
	private String comment;

	// add boolean attribute to handle the notifications
	// add cause of report

	public ReportRelationShip() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReportRelationShip(User currentUser, User reportedUser,
			String comment) {
		super();
		this.currentUser = currentUser;
		this.reportedUser = reportedUser;
		this.comment = comment;
		this.reportDate = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public User getReportedUser() {
		return reportedUser;
	}

	public void setReportedUser(User reportedUser) {
		this.reportedUser = reportedUser;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
