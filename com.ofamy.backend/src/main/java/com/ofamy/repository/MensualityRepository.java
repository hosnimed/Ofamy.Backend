package com.ofamy.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.ofamy.model.Mensuality;

/**
 * Spring Data Neo4j repository for <code> Mensuality </code> domain objects
 *    All method names are compliant with Spring Data naming  conventions
 *    
 * @author Haithem
 * @since 03.07.2014
 *
 */

public interface MensualityRepository extends GraphRepository<Mensuality> {

}
