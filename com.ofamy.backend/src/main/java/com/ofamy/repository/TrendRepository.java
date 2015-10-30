package com.ofamy.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import com.ofamy.model.Trend;
import com.ofamy.model.User;
import com.ofamy.util.RelationShipTypes;

/**
 * Spring Data Neo4j repository for <code> Trend </code> domain objects
 *    All method names are compliant with Spring Data naming  conventions
 *    
 * @author Haithem
 * @since 03.07.2014
 *
 */

public interface TrendRepository extends GraphRepository<Trend> {
	
	public Trend findByName(String name);

	@Query("start u=node({0}) match trends<-[:"+RelationShipTypes.FOLLOW_TREND+"]-(u)  return trends")
	public List<Trend> findTrendByUserID(User u);

//	@Query("start u=node({0}) match trends<-[f:"+RelationShipTypes.FOLLOW_TREND+"]-(u) where f is null return trends")
	@Query("start u=node({0}) match (t:Trend) where not ( u-[:"+RelationShipTypes.FOLLOW_TREND+"]->(t))return t")
	public List<Trend> findTrendUnfollowedByUserID(User findOne);

}
