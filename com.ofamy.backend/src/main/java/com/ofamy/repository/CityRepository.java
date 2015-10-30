package com.ofamy.repository;

import java.util.Set;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import com.ofamy.model.City;
import com.ofamy.model.Company;

public interface CityRepository extends GraphRepository<City> {

public City findByName(String name);
	
	@Query("start company=node({0})"
			+ "Match company-[:PROPOSE]->(offer)-[:IS_IN]->(city) return city")
	public Set<City> findCityByCompanyOffers(Company company);
}
