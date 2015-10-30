package com.ofamy.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ofamy.model.Offer;
import com.ofamy.security.AuthenticationService;
import com.ofamy.service.UserMainService;
import com.ofamy.service.UserOfferService;
import com.ofamy.service.dto.HistoDTO;
import com.ofamy.service.dto.OfferMSDTO;
import com.ofamy.service.dto.OfferMSDetailDTO;
import com.ofamy.service.dto.UserOfferDetailsDTO;

@RestController
@RequestMapping("/MS")
public class MSController {
	@Autowired
	UserMainService userService;
	@Autowired
	UserOfferService offerService;	
	@Autowired
	AuthenticationService authenticationService;
	


			/***les offres privées pour un user donné les offres de mySpace  ***/
	@Value("3") int maxResult ; 
    @RequestMapping(value="/allOffers/", method=RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<OfferMSDTO> getAllMSOffers( @RequestParam int page, @RequestParam(required=false) Integer maxResultByPage)
    		{
    	long currentId = authenticationService.getCurrentUser().getUserId();
        return  offerService.createMSOfferDTOFromOfferList(offerService.findMSOffers(currentId,page,maxResultByPage!=null?maxResultByPage:maxResult));
    
    }
    
    	
	/***l'historique des offres adhérées  d'un user donné  ***/

    @RequestMapping(value="/historique/", method=RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<HistoDTO> hist( @RequestParam int page, @RequestParam(required=false) Integer maxResultByPage)
    		{
    	long currentId = authenticationService.getCurrentUser().getUserId();
        return offerService.createHistoDTOFromOfferList(offerService.maliste(currentId,page,maxResultByPage!=null?maxResultByPage:maxResult))  ;
    
    		}
    
	/***Une  offre détaillée donnée de MS  privées pour un user donné  ***/
	
    @RequestMapping(value="/details/{offerid}", method=RequestMethod.GET,produces="application/json" )
    public @ResponseBody OfferMSDetailDTO msDetails( @PathVariable(value="offerid") long offer_id ){
    	Offer offer = offerService.findOfferById(offer_id);
    	OfferMSDetailDTO dto = offerService.createOfferMSDetailsDTOfromOffer(offer) ;  
     return  dto;           		
   }
  
    
    
	/***Une offres détaillée pour l'historique  ***/   
  
    @RequestMapping(value="/histdetails/{offerid}", method=RequestMethod.GET,produces="application/json" )
    public @ResponseBody UserOfferDetailsDTO histDetails(  @PathVariable(value="offerid") long offer_id ){
     
    	/*** nous avons bien remarqué que l'offerDetailDTO et l'histoDetail sont identiques  ***/
    	Offer offer = offerService.findOfferById(offer_id);
    	UserOfferDetailsDTO dto = offerService.createOfferDetailsDTOfromOfferBeta(offer) ;  
     return  dto;                  		
   }
  
    
    
    //____
}
