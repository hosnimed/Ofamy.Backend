package com.ofamy.config;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.kernel.impl.util.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.core.GraphDatabase;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ofamy.model.City;
import com.ofamy.model.CommentsRelationShip;
import com.ofamy.model.Company;
import com.ofamy.model.Location;
import com.ofamy.model.Offer;
import com.ofamy.model.OfferDefinition;
import com.ofamy.model.OfferStatus;
import com.ofamy.model.OfferStatusRelationShip;
import com.ofamy.model.OfferToRelationShip;
import com.ofamy.model.Product;
import com.ofamy.model.Reward;
import com.ofamy.model.Trend;
import com.ofamy.model.User;
import com.ofamy.repository.CityRepository;
import com.ofamy.repository.CompanyRepository;
import com.ofamy.repository.LocationRepository;
import com.ofamy.repository.OfferDefinitionRepository;
import com.ofamy.repository.OfferRepository;
import com.ofamy.repository.OfferStatusRepository;
import com.ofamy.repository.ProductRepository;
import com.ofamy.repository.RewardRepository;
import com.ofamy.repository.TrendRepository;
import com.ofamy.repository.UserRepository;
import com.ofamy.service.UserOfferService;
import com.ofamy.service.UserMainService;
import com.ofamy.util.OfferStatusEnum;
import com.ofamy.util.RelationShipTypes;


@Configuration
@EnableAutoConfiguration
@EnableNeo4jRepositories(basePackages = "com.ofamy.repository")
@EnableTransactionManagement
@ComponentScan(basePackages = "com.ofamy")
public class Application extends Neo4jConfiguration implements
		CommandLineRunner {

	@Autowired
	GraphDatabase graphDatabase;

	@Autowired
	Neo4jTemplate neo4j;

	@Autowired
	UserMainService userMainService;
	@Autowired
	UserOfferService userOfferService;
	@Autowired
	UserRepository userRepo;
	@Autowired
	OfferRepository offerRepo;
	@Autowired
	CompanyRepository companyRepo;
	@Autowired
	TrendRepository trendRepo;
	@Autowired
	OfferDefinitionRepository offerDefRepo;
	@Autowired
	OfferStatusRepository offerStatusRepo;
	@Autowired
	ProductRepository ProductRepo;
	@Autowired
	RewardRepository RewardRepo;
	@Autowired
	LocationRepository locationRepo;
	@Autowired
	CityRepository cityRepo;

	@Bean
	GraphDatabaseService graphDatabaseService() {
		return new GraphDatabaseFactory().newEmbeddedDatabase("target/ofamy");
	}

	private static final Logger logger = LoggerFactory
			.getLogger(Application.class);

	public Application() {
		setBasePackage("com.ofamy");
	}

	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString = "31-08-1982 10:20:56";
		String endDateInString="31-08-2020 10:20:56";
		
		User user;
		Offer offer;
	    OfferStatus offerStatusPRIVATE;
	    OfferStatus offerStatusPUBLIC;
	    City city;
	    Location location;
	    OfferStatusRelationShip offerStatusRelationShip;
	    OfferToRelationShip offerToRelationShip;
	    CommentsRelationShip commentsRelationShip;
	    String comment;
		Transaction tx = graphDatabase.beginTx();
		try {
			location =new Location("20 Location");
			locationRepo.save(location);
			logger.info("location :"+location.getAdress());
			
			city=new City("California", "056821", "USA");
			Set<Location> locations =new HashSet<Location>();
			locations.add(location);
			city.setLocations(locations);
			cityRepo.save(city);
			logger.info("CityLocationsSize :"+city.getLocations().size());
			
			Company company = new Company("apple@company.com", "123","Apple Inc");
			company.setLogo("http://www.directioninformatique.com/wp-content/uploads/2013/04/apple_logo_200_200.jpg");
			company.setLocation(location);
			 companyRepo.save(company);
logger.info("Comapny : "+company);

			Trend trend1 = new Trend("Smartphone");
		    trendRepo.save(trend1);
						
			Product product = new Product("Product P", 499.999,"Product P description");
			product.setTimelinePicture("http://www.prix-ordi.com/ordinateur/apple-macbook-air-11-mc506fa.jpg");
			product.setDetailPicture1("http://www.speckproducts.com/media/catalog/product/cache/1/image/480x/9df78eab33525d08d6e5fb8d27136e95/s/p/spk-a2391_smartshell-for-macbookair11-blacksatin_3qviewingback_1_1.jpg");
			product.setDetailPicture2("http://www.speckproducts.com/media/catalog/product/cache/1/image/480x/9df78eab33525d08d6e5fb8d27136e95/s/p/spk-a2391_smartshell-for-macbookair11-blacksatin_3qviewingback_1_1.jpg");
			product.setDetailPicture3("http://www.speckproducts.com/media/catalog/product/cache/1/image/480x/9df78eab33525d08d6e5fb8d27136e95/s/p/spk-a2391_smartshell-for-macbookair11-blacksatin_3qviewingback_1_1.jpg");
			ProductRepo.save(product);
			
			Reward reward = new Reward("Reward R ", "Reward description here ",	100.00);
			reward.setDetailPicture("http://www.tucano.ru/media/catalog/product/cache/9/small_image/200x200/9df78eab33525d08d6e5fb8d27136e95/B/T/BTEC11-G_a.jpg");
			reward.setTimlinePicture("http://www.enjoymusic.ch/shop/ProdukteBilder/6222_kl.jpg");
			RewardRepo.save(reward);
			
			OfferDefinition offerDef = new OfferDefinition(product, reward);
			offerDef.setOfferDefName("template1");
			offerDef.setShortDescription("shortDescription");
			offerDef.setLongDescription("longDescription");
			offerDef.setOwner (company);
			offerDefRepo.save(offerDef);
logger.info("OfferDefinition : Owner :"+offerDef.getOwner());			
			
			company.addNewOfferTemplate(offerDef);
			 companyRepo.save(company);
			 
			 /******** Creation de l'OffreStatus *****/				
			 offerStatusPRIVATE=new OfferStatus(OfferStatusEnum.PRIVATE) ;
			 offerStatusPRIVATE.setCreationDate(new Date());
			 offerStatusRepo.save(offerStatusPRIVATE );
			 
			 /******** Creation de l'OffreStatus *****/				
			 offerStatusPUBLIC=new OfferStatus(OfferStatusEnum.PUBLIC) ;
			 offerStatusPUBLIC.setCreationDate(new Date());
			 offerStatusRepo.save(offerStatusPUBLIC);
			 
			for (int i = 1; i <= 10; i++) {
				/******** Creation de User *****/
		user = new User("user" + i + "@gmail.com", "1234", "user" + i,	"First" + i, "Last" + i);
		user.setBirthDate(sdf.parse(dateInString));
		user.setProfilePicture("http://www.mwbbc.com/images/blank_profile.jpg");
		user.setPresentation("I am the User number "+i);
					userRepo.save(user);
				
		/******** Creation de l'Offre *****/
		offer = new Offer("Offer Number" + i, "Offer " + i	+ " Description here");
				offer.setCreationDate(new Date());
				offer.setEndDate(sdf.parse(endDateInString));
				offer.setOwner(company);
				offer.setTrend(trend1);
				offer.setCity(city);
				offer.setOfferDefinition(offerDef);
					offerRepo.save(offer);
		/***** User comment Offer*******/
		user.commentsOffer(user.getFirstName()+" "+user.getLastName()+" comment!", offer);			
				
				
/******** Creation de l' OfferToRelationShip  *****/	
 offerToRelationShip =new OfferToRelationShip(offer, user);
 offerToRelationShip=neo4j.createRelationshipBetween(offer, user, offerToRelationShip.getClass(), RelationShipTypes.OFFER_TO, false);
 neo4j.save(offerToRelationShip);


/******** Creation de l' OfferStatusRelationShip *****/				
/*
 offerStatusRelationShip=neo4j.createRelationshipBetween(offer, offerStatusPRIVATE, OfferStatusRelationShip.class, RelationShipTypes.OFFER_STATUS, false);
   offerStatusRelationShip.setStartDate( new Date());
  offerStatusRelationShip.setEndDate(sdf.parse(endDateInString));
  offerStatusRelationShip.setDescription("OfferStatusRelationShip Description");
neo4j.save(offerStatusRelationShip);
*/
/******** Creation de l' OfferStatusRelationShip *****/				
offerStatusRelationShip=neo4j.createRelationshipBetween(offer, offerStatusPUBLIC, OfferStatusRelationShip.class, RelationShipTypes.OFFER_STATUS, false);
 offerStatusRelationShip.setStartDate( new Date());
offerStatusRelationShip.setEndDate(sdf.parse(endDateInString));
offerStatusRelationShip.setDescription("OfferStatusRelationShip Description");
neo4j.save(offerStatusRelationShip);
  
Set<OfferStatusRelationShip> listOfferStatus =new HashSet<OfferStatusRelationShip>();
listOfferStatus.add(offerStatusRelationShip);
				offer.setOfferstatus(listOfferStatus);
				offerRepo.save(offer);
				
				/**** User comment Offer****/
 comment =user.getFirstName()+" comment offer "+offer.getOfferId();
userMainService.commentOffer(user.getUserId(), comment, offer.getOfferId());

			//	logger.info("info :"+offer.getOfferDefinition().getOwner().getName());
				logger.info("User : " + user.getUserId() + " "	+ user.getFirstName() +"----- Offer : "+offer.getOfferId());	
			}
			
						tx.success();
		} finally {
			tx.close();
		}

			}

	public static void main(String[] args) throws Exception {
		FileUtils.deleteRecursively(new File("/target/ofamy"));

		SpringApplication.run(Application.class, args);
	}

}