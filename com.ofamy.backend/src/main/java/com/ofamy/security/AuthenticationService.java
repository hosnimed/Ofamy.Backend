package com.ofamy.security;

import org.springframework.stereotype.Component;

import com.ofamy.model.User;
import com.ofamy.service.dto.UserCommentDTO;

@Component
public class AuthenticationService {

	public User getCurrentUser() {
		// TODO Auto-generated method stub
		User u = new User();
		u.setUserId(new Long(8));
		return u;

	}
}
