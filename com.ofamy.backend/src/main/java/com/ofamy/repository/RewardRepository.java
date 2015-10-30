package com.ofamy.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.ofamy.model.Product;
import com.ofamy.model.Reward;

/**
 * Spring Data Neo4j repository for <code> Reward </code> domain objects
 *    All method names are compliant with Spring Data naming  conventions
 *    
 * @author Haithem
 * @since 03.07.2014
 *
 */

public interface RewardRepository extends GraphRepository<Reward> {
	public Reward findByName(String name);
}
