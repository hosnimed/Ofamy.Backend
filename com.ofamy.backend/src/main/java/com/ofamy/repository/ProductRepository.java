package com.ofamy.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import com.ofamy.model.Product;
import com.ofamy.model.User;


/**
 * Spring Data Neo4j repository for <code> Product </code> domain objects
 *    All method names are compliant with Spring Data naming conventions
 *    
 * @author Haithem
 * @since 03.07.2014
 *
 */

public interface ProductRepository extends GraphRepository<Product> {

	public Product findByName(String name);

}
