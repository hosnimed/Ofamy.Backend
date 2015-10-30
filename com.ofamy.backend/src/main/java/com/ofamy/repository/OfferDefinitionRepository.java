package com.ofamy.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import com.ofamy.model.OfferDefinition;
import com.ofamy.model.Product;
import com.ofamy.model.Reward;

/**
 * Spring Data Neo4j repository for <code> OfferDefinition </code> domain objects
 *    All method names are compliant with Spring Data naming  conventions
 *    
 * @author Haithem
 * @since 03.07.2014
 *
 */

public interface OfferDefinitionRepository extends GraphRepository<OfferDefinition> {

	/**
	 * @author Ferdaws
	 * @param product
	 * @return
	 */
	@Query("start product=node({0}) Match (product)<-[:CONCERNS]-(offerDef) return offerDef")
	public List<OfferDefinition> findAllByProduct(Product product);
	
	@Query("start reward=node({0}) Match (reward)<-[:REWARDED]-(offerDef) return offerDef")
	public List<OfferDefinition> findAllByReward(Reward reward);
}
