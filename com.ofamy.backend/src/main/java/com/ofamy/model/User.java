package com.ofamy.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.annotation.RelatedToVia;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ofamy.util.Gender;
import com.ofamy.util.JsonDateSerializer;
import com.ofamy.util.RelationShipTypes;
import com.ofamy.util.SocialAccount;
import com.ofamy.util.UserOrigin;
import com.ofamy.util.UserStyle;

/**
 *  Simple JavaBean domain object representing a User 
 *  
 * @author Haithem
 *
 */

@TypeAlias("User")
public class User extends MainUser implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8718399581473567009L;
	
	@Indexed
	private String login;
	private String firstName;
	private String lastName;
	private String profilePicture;
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date birthDate;
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date creationDate;
	private Gender gender;	
	
	@RelatedTo(type=RelationShipTypes.GOT_HOBBIES)
	private Hobbies hobbies;
	
	private String occupation;
	private String education;
	private String presentation;
	private String hairColor;
	
	private double height;
	private double weight;
	
	private String income; // ?!
	
	private UserStyle style;
	private UserOrigin origin;
	
	@RelatedToVia
	@JsonIgnore
	private @Fetch Set<FriendRelationShip> friends;
	
	@RelatedToVia
	@JsonIgnore
	private Set<FollowTrendRelShip> followedTrends;
	
	@RelatedTo(type=RelationShipTypes.SCORE)
	@JsonIgnore
	private @Fetch GiftPoint giftPoint;
	
	@RelatedTo(type=RelationShipTypes.PAYEMENT_METHOD)
	private Payement payement_method;
	
	@RelatedToVia
	@JsonIgnore
	private Set<LikeRelationShip> likedOffers;
	
	@RelatedToVia
	@JsonIgnore
	private Set<ReportRelationShip> reportedUsers;
	
	@RelatedToVia
	@JsonIgnore
	private Set<AdhereToRelationShip> adheredOffers;
	
	@RelatedToVia
	@JsonIgnore
	private @Fetch Set<CommentsRelationShip> myComments;
	
	@RelatedToVia
	@JsonIgnore
	private Set<RatingRelationShip> ratedOffers;
	
	private String activationCode;
	
	/**
	 * if fb, the facebookID will be used to log in
	 * if twitter, the twitterID will be used to log in
	 * otherwise use his F**KING EMAIL -__-
	 */
	private SocialAccount socialAccount; 
	private String facebookID;
	private String twitterID;
	
	private Date lastUpdate;
	

	public User(){
		
	}
	
	public User(String email, String password, String login, String first_name,
			String last_name) {
		super(email, password);
		this.login = login;
		this.firstName = first_name;
		this.lastName = last_name;
		creationDate = new Date();
	}
	
	/*
	 * This method will be called when the current user Follow  another user
	 */	
	
	public void addFriendShip(User user,Date since){
		FriendRelationShip fship=new FriendRelationShip(this, user, since);
		if(friends==null){
			friends=new HashSet<FriendRelationShip>();
		}
		friends.add(fship);
	}
	
	/*
	 * This method will be called when a user Follow  new Trend
	 */
	
	public void followTrend(Trend trend){
		FollowTrendRelShip followTrend=new FollowTrendRelShip(this, trend);
		if(followedTrends==null)
			followedTrends=new HashSet<FollowTrendRelShip>();
		followedTrends.add(followTrend);
	}
	
	/*
	 * This method will be called when a user likes  an Offer
	 */
	
	public void likesOffer(Offer offer){
		LikeRelationShip relation=new LikeRelationShip(this, offer, new Date());
		if(likedOffers==null)
			likedOffers=new HashSet<LikeRelationShip>();
		likedOffers.add(relation);
	}
	
	/*
	 * This method will be called when a user Comments  an Offer
	 */
	public void commentsOffer(String commentaire,Offer offer){
		CommentsRelationShip commentRelShip=new CommentsRelationShip(this, offer, new Date(), commentaire);
		if(myComments==null);
			myComments=new HashSet<CommentsRelationShip>();
		myComments.add(commentRelShip);
	}
	
	/*
	 * This method will be called when a user Adhere To an Offer
	 */
	public void adhereToOffer(Offer offer) {
		AdhereToRelationShip adhereTo = new AdhereToRelationShip(this, offer,
				new Date());
		if (adheredOffers == null)
			adheredOffers = new HashSet<AdhereToRelationShip>();
		adheredOffers.add(adhereTo);
	}
	
	public void addNewStatus(UserStatus us){
		UserStatusRelationShip userStatusRelship=new UserStatusRelationShip(this, us);
		super.getMyStatus().add(userStatusRelship);
	}
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getFirstName() {
		return firstName;
	}
	
	public String getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(String profile_picture) {
		this.profilePicture = profile_picture;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birth_date) {
		this.birthDate = birth_date;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creation_date) {
		this.creationDate = creation_date;
	}

	public Set<FriendRelationShip> getFriends() {
		return friends;
	}

	public void setFriends(Set<FriendRelationShip> friends) {
		this.friends = friends;
	}


	public Hobbies getHobbies() {
		return hobbies;
	}

	public void setHobbies(Hobbies hobbies) {
		this.hobbies = hobbies;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getPresentation() {
		return presentation;
	}

	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	public String getHairColor() {
		return hairColor;
	}

	
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public UserStyle getStyle() {
		return style;
	}

	public void setStyle(UserStyle style) {
		this.style = style;
	}

	public UserOrigin getOrigin() {
		return origin;
	}

	public void setOrigin(UserOrigin origin) {
		this.origin = origin;
	}


	public GiftPoint getGiftPoint() {
		return giftPoint;
	}

	public void setGiftPoint(GiftPoint giftPoint) {
		this.giftPoint = giftPoint;
	}

	public Set<ReportRelationShip> getReportedUsers() {
		return reportedUsers;
	}

	public void setReportedUsers(Set<ReportRelationShip> reportedUsers) {
		this.reportedUsers = reportedUsers;
	}

	

	public Set<AdhereToRelationShip> getAdheredOffers() {
		return adheredOffers;
	}

	public void setAdheredOffers(Set<AdhereToRelationShip> adheredOffers) {
		this.adheredOffers = adheredOffers;
	}

	
	public Set<CommentsRelationShip> getMyComments() {
		return myComments;
	}

	public void setMyComments(Set<CommentsRelationShip> myComments) {
		this.myComments = myComments;
	}

	public Set<RatingRelationShip> getRatedOffers() {
		return ratedOffers;
	}

	public void setRatedOffers(Set<RatingRelationShip> ratedOffers) {
		this.ratedOffers = ratedOffers;
	}


	public Set<LikeRelationShip> getLikedOffers() {
		return likedOffers;
	}

	public void setLikedOffers(Set<LikeRelationShip> likedOffers) {
		this.likedOffers = likedOffers;
	}

	public Set<FollowTrendRelShip> getFollowedTrends() {
		return followedTrends;
	}

	public void setFollowedTrends(Set<FollowTrendRelShip> followedTrends) {
		this.followedTrends = followedTrends;
	}

	public Payement getPayement_method() {
		return payement_method;
	}

	public void setPayement_method(Payement payement_method) {
		this.payement_method = payement_method;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	public SocialAccount getSocialAccount() {
		return socialAccount;
	}

	public void setSocialAccount(SocialAccount socialAccount) {
		this.socialAccount = socialAccount;
	}

	public String getFacebookID() {
		return facebookID;
	}

	public void setFacebookID(String facebookID) {
		this.facebookID = facebookID;
	}

	public String getTwitterID() {
		return twitterID;
	}

	public void setTwitterID(String twitterID) {
		this.twitterID = twitterID;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	@Override
	public String toString() {
		return firstName+" "+lastName;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	
	

	
	

}
