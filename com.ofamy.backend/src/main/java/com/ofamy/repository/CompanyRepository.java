package com.ofamy.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import com.ofamy.model.Company;
import com.ofamy.model.User;

/**
 * Spring Data Neo4j repository for <code> Company </code> domain objects
 *    All method names are compliant with Spring Data naming  conventions
 *    
 * @author Haithem
 * @since 03.07.2014
 *
 */

public interface CompanyRepository extends GraphRepository<Company> {

	public Company findByName(String name);
	
	@Query("start company=node({0}) Match (company)-[:COMPANY_FOLLOW_TREND]->(trend)<-[:FOLLOW_TREND]-(users) return users")
	public List<User> findUsersByCompany(Company company);
	
}
