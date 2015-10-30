package com.ofamy.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.ofamy.model.UserStatus;

/**
 * Spring Data Neo4j repository for <code> UserStatus </code> domain objects
 *    All method names are compliant with Spring Data naming conventions
 *    
 * @author Haithem
 * @since 03.07.2014
 *
 */

public interface UserStatusRepository extends GraphRepository<UserStatus> {

}
