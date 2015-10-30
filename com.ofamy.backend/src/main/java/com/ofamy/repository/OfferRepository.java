package com.ofamy.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;

import com.ofamy.model.Offer;
import com.ofamy.model.OfferStatus;
import com.ofamy.model.User;

/**
 * Spring Data Neo4j repository for <code> Offer </code> domain objects All
 * method names are compliant with Spring Data naming conventions
 * 
 * @author Haithem
 * @since 03.07.2014
 */

public interface OfferRepository extends GraphRepository<Offer> , RelationshipOperationsRepository<Offer> {

	public Offer findByName(String name);

	@Query("start offer=node({0}) Match offer<-[:COMMENTS]-(users) return count(users)")
	public long countComments(Offer offer);

	@Query("start offer=node({0}) Match offer<-[:ADHERE_TO]-(users) return count(users)")
	public long countFollowers(Offer offer);

	@Query("start offer=node({0}) Match offer<-[:LIKES]-(users) return count(users)")
	public long countLikes(Offer offer);

	@Query("start offer=node({0}) Match offer<-[:RATED]-(users) return count(users)")
	public long countRate(Offer offer);

	@Query("start offer=node({0}) match offer<-[:LIKES]-(users) return users")
	public List<User> getLikes(Offer offer);

	
	@Query("start u=node({0}) match offers<-[:ADHERE_TO]-(u)  return offers")
	public Page<Offer> findOfferByUser(User u, Pageable pageable);

	@Query("start offer=node({0}) match offer<-[:ADHERE_TO]-(users) return users")
	public List<User> getAdheres(Offer offer);
	
	@Query("start offer=node({0}) match offer-[:HAS]->offerstaus")
	public OfferStatus findLastOfferStatus(Offer offer);
	
	/** * Timeline's Offer */ 
	@Query("start user=node({0}) "+
    		" match user-[:FOLLOW_TREND]->(trend)<-[:BELONG_TO]-(o:Offer)-[rel:OFFER_STATUS]->(offerStat:OfferStatus)"+
    		" where offerStat.status = \"PUBLIC\" and toFloat(rel.endDate) > timestamp() return o"+
    		" UNION "+
    		" start user=node({0})"+
    		" match user-[:FRIEND]->(users)-[:ADHERE_TO]->(o:Offer)-[rel:OFFER_STATUS]->(offerStat:OfferStatus)"+
    		" where offerStat.status = \"PUBLIC\" and toFloat(rel.endDate) > timestamp() return o")
	public Page<Offer> findTimelineOffers(User user,Pageable page);
	
	
	// NINJA ________________________NINJA 
	@Query("start offer=node({0}) match  offer-[ofs:OFFER_STATUS]->status" + 
			" where (ofs.endDate is null or toFloat(ofs.endDate) > timestamp()) "+
			"return status.status  ")
	public String getLastStatus(Offer offer);
	//ninja___________________________________________________________/_____________
		@Query("start user=node({0}) match user<-[:OFFER_TO]-(offers)-[rel:OFFER_STATUS]->(s:OfferStatus)" 
				+ " where toFloat(rel.endDate) > timestamp() and s.status = \"PRIVATE\" return offers")
		public Page<Offer> findPrivateOffersForUser(User user ,Pageable pageable);
		// test
		   @Query("start u=node({0}) match offers<-[:ADHERE_TO]-(u)  return offers")
		   public Page<Offer> maliste(User user ,Pageable pageable);
		   
		   
		 
}