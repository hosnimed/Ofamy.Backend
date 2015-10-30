package com.ofamy.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.ofamy.model.Location;

/**
 * Spring Data Neo4j repository for <code> Location </code> domain objects
 *    All method names are compliant with Spring Data naming conventions
 *    
 * @author Haithem
 * @since 03.07.2014
 *
 */

public interface LocationRepository extends GraphRepository<Location> {

}
