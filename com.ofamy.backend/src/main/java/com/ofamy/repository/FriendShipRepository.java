package com.ofamy.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.ofamy.model.FriendRelationShip;

/**
 * Spring Data Neo4j repository for <code> Friend </code> RelationShip objects
 *    All method names are compliant with Spring Data naming  conventions
 *    
 * @author Haithem
 * @since 03.07.2014
 *
 */

public interface FriendShipRepository extends GraphRepository<FriendRelationShip> {

}
