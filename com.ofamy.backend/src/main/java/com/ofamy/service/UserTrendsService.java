package com.ofamy.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofamy.model.Trend;
import com.ofamy.model.User;
import com.ofamy.repository.TrendRepository;
import com.ofamy.repository.UserRepository;
import com.ofamy.service.dto.TrendsForUserProfile;
import com.ofamy.service.dto.TrendsStatus;

@Service
public class UserTrendsService {

	@Autowired
	private TrendRepository trendRepository;
	@Autowired
	private UserRepository userRepository;
	
	public List<TrendsForUserProfile> findTrendFollowedByUserID(long user_id){
		List<TrendsForUserProfile> trendsfollowedforuserprofile=new ArrayList<TrendsForUserProfile>();
		List<Trend> trendfollowed= trendRepository.findTrendByUserID(userRepository.findOne(user_id));
		System.out.println("TrendFollowedByUserID:"+user_id);
		for (Iterator<Trend> it = trendfollowed.iterator(); it.hasNext();) {
			Trend trend = (Trend) it.next();
			System.out.print("--"+trend.getName()+"--");
			trendsfollowedforuserprofile.add(adaptTrendToTrendForUserProfile(trend,TrendsStatus.FOLLOWED));
				}
		return trendsfollowedforuserprofile;
	}

	private TrendsForUserProfile adaptTrendToTrendForUserProfile(Trend trend,TrendsStatus status) {
		TrendsForUserProfile trendsForUserProfile=new TrendsForUserProfile();
		trendsForUserProfile.setId(trend.getNodeId());
		trendsForUserProfile.setName(trend.getName());
		trendsForUserProfile.setStatus(status.toString());
		
		return trendsForUserProfile;
		
	}

	public List<TrendsForUserProfile> findTrendUnfollowedByUserID(long user_id){
		
		List<TrendsForUserProfile> trendsunfollowedforuserprofile=new ArrayList<TrendsForUserProfile>();
		List<Trend> trendunfollowed= trendRepository.findTrendUnfollowedByUserID(userRepository.findOne(user_id));
		System.out.println("TrendUNFollowedByUserID:"+user_id);
		for (Iterator<Trend> it = trendunfollowed.iterator(); it.hasNext();) {
			Trend trend = (Trend) it.next();
			System.out.print("--"+trend.getName()+"--");
			trendsunfollowedforuserprofile.add(adaptTrendToTrendForUserProfile(trend,TrendsStatus.UNFOLLOWED));
				}
		return trendsunfollowedforuserprofile;
	}
	
	 //hosni
    public List<TrendsForUserProfile> adaptTrendsForUserProfile(long id) {
	
    	List<TrendsForUserProfile> trendsForUserProfiles =new ArrayList<TrendsForUserProfile>();
	     trendsForUserProfiles.addAll(findTrendFollowedByUserID((long) id));
	     trendsForUserProfiles.addAll(findTrendUnfollowedByUserID((long) id));;
	     		return trendsForUserProfiles;
	}
	
	}

