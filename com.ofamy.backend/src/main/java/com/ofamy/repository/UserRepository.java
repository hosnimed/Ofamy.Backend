package com.ofamy.repository;


import java.util.List;
import java.util.Set;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;

import com.ofamy.model.Company;
import com.ofamy.model.FollowTrendRelShip;
import com.ofamy.model.FriendRelationShip;
import com.ofamy.model.Trend;
import com.ofamy.model.User;


/**
 * Spring Data Neo4j repository for <code> {@link User} </code> domain objects
 *    All method names are compliant with Spring Data naming  conventions
 *    
 * @author Haithem
 * @since 03.07.2014
 *
 */

public interface UserRepository extends GraphRepository<User>,RelationshipOperationsRepository<User> {
	
		public User findByEmail(String email);
		public List<User> findByFirstName(String firstName);
		public List<User> findByLastName(String lastName); 
		public User findByEmailAndPassword(String email,String password);
		public User findByLogin(String login);
	//	public List<User> findByfirstnameAndlastname(String firstname , String lastname);
		
	@Query("start user=node({0}) Match user<-[:FRIEND]->(friends) return friends")
	public List<User> findFriends(User user);
	
	@Query("start user=node({0}), other=node({1}) Optional Match  user-[f:FRIEND]->(other) return not ( f is null)")
	public boolean isFollowed(User currenUser,User otherUser);
	
	@Query("start user=node({0}) Match user-[:FRIEND]->(friends) return friends")
	public List<User> findFollowings(User user);
	
	@Query("start user=node({0}) Match user<-[:FRIEND]-(friends) return friends")
	public List<User> findFollowers(User u);
	
	@Query("start user=node({0}) Match user<-[:FRIEND]-(friends) return count(friends)")
	public int countFollowers(User u);
	
	@Query("start user=node({0}) Match user-[:FRIEND]->(friends) return count(friends)")
	public int countFollowings(User u);
	
		@Query("start user=node({0}) Match user-[:FOLLOW_TREND]->(trends) return trends")
	public List<Trend> findUserTrends(User user);
	
	

		
	//@Query("START user=node({0}) , trend=node({1}) CREATE (user)-[rel:FOLLOW_TREND]->(trend) ")
//	public void followTrend(User user, Trend trend);

	//@Query("START user=node({0}) , trend=node({1}) Match user-[rel:FOLLOW_TREND]->(trend) Delete rel")
//	public void unfollowTrend(User user, Trend trend);

	
	

//	//todo
//	@Query("")
//	public int countConfirmedOffersByCompany(Company comany,User user);
}