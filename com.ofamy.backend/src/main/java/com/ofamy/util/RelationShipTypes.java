package com.ofamy.util;

import com.ofamy.model.OfferDefinition;

/**
 * Simple final class representing All the relationShips
 * 
 * Rich : relationShip with attributes
 * Simple : relationShip without attributes
 * 
 *  @author Haithem
 *
 */
public final class RelationShipTypes {
	
	/**
	 * Rich RelationShip between Two Users
	 */
	public final static String FRIEND="FRIEND";
	
	/**
	 * Rich / simple Following RelationShip between User and Trend :  User -Follow_trend-> Trend
	 */
	public final static String FOLLOW_TREND="FOLLOW_TREND";
	
	
	/**
	 * Rich RelationShip between Offer and User ( Target User ) Offer -> User
	 */
	public final static String OFFER_TO="OFFER_TO";
	
	
	/**
	 * Simple RelationShip between Offer and Trend :  Offer -- related To -->  Trend
	 */
	public final static String RELATED_TO="RELATED_TO";
	
	
	/**
	 * Simple RelationShip between User and Location : User -- IS_FROM --> Location
	 */
	public final static String IS_FROM="IS_FROM";
	
	
	/**
	 * Rich RelationShip between Offer and User : User -- ADHERE_TO --> Offer
	 */
	
	public final static String ADHERE_TO="ADHERE_TO";
	
	
	/**
	 * Simple RelationShip between User and Offer : User - Likes -> offer
	 */
	public final static String LIKES="LIKES";
	
	/**
	 * Rich RelationShip between User and Offer : User - Comments -> offer
	 */
	public final static String COMMENTS="COMMENTS";
	
	/**
	 * Simple RelationShip between Company  and OfferDef : Company - Prepare -> {@link OfferDefinition}
	 */
	public final static String PREPARE="PREPARE";
	
	/**
	 * Simple  RelationShip between Offer and Status : Offer - status -> OfferStatus
	 */
	public final static String OFFER_STATUS="OFFER_STATUS";
	
	/**
	 * Simple  RelationShip between User and Status : User - status -> UserStatus
	 */
	public final static String USER_STATUS="USER_STATUS";
	
	/**
	 * Simple RelationShip between OfferDefinition and Product : offerDefinition -> Product
	 */
	public final static String CONCERNS="CONCERNS";
	
	/**
	 * (simple) Following  RelationShip between Company and Trend : Company - BELONG_TO -> Trend
	 */
	public final static String COMPANY_BELONGTO_TREND="BELONG_TO";
	
	/**
	 * Simple relationShip between Offer and OfferDefinition : Offer -- IS_BASED_ON --> OfferDefnition
	 */
	public final static String IS_BASED_ON="IS_BASED_ON";


	/**
	 * Simple RelationShip between Company and Mensuality : Company -- Pays --> Mensuality 
	 */
	public final static String PAYS="PAYS";
	
	/**
	 * Simple relationShip between User and GiftPoint
	 */
	public final static String SCORE="SCORE";
	
	/**
	 * Rich relationship between Two Users ( when a user report another user ) 
	 */
	public final static String REPORT_USER="REPORT_USER";

	/**
	 * Simple RelationShip between OfferDefinition and Reward OfferDefinition -- REWARDED --> Reward
	 */
	public final static String REWARDED="REWARDED";
	
	/**
	 *  Simple RelationShip between Company and offer : Company -- Propose --> Offer
	 */
	public final static String PROPOSE="PROPOSE";
	

	/**
	 *  Rich RelationShip between User and offer : User -- Rated --> Offer
	 */
	public final static String RATED="RATED";
	
	/**
	 * Simple rlationship between User and Payement : User -- PAYEMENT_METHOD --> Payement
	 * 
	 */
	public final static String PAYEMENT_METHOD="PAYEMENT_METHOD";
	
	/**
	 *  Simple relationship between Offer and City 
	 */
	public final static String IS_LOCATED_IN = "IS_LOCATED_IN";

	/**
	 *  Simple relationship between {@link User} and {@link Hobbies} 
	 */
	public final static String GOT_HOBBIES = "GOT";
	
	/**
	 *  Simple relationship between {@link Product} and {@link Company} 
	 */
	public final static String OWNER = "OWNER";
	
	/**
	 *  Simple relationship between {@link Reward} and {@link Company} 
	 */
	public final static String ADDED_BY = "ADDED_BY";
	
	/**
	 *  Simple relationship between Reward and City 
	 */
	public final static String IS_AVAILABLE_IN = "IS_AVAILABLE_IN";
	
	/**
	 *  Simple relationship between Location and City 
	 */
	public final static String IS_IN = "IS_IN";
	
	/**
	 * Simple RelationShip between Product and Trend
	 */
	
	public final static String IS_UNDER = "IS_UNDER";
	
	
	


}
