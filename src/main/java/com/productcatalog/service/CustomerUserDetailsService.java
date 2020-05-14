package com.productcatalog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.productcatalog.model.CustomUserDetails;
import com.productcatalog.model.Users;
import com.productcatalog.repo.UserRepo;
@Service
public class CustomerUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepo userRepo;
	
	static {
		System.out.println("CustomerUserDetailsService.enclosing_method()");
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		 Optional<Users> optionalUsers = userRepo.findByEmailId(username);
		 System.out.println("value of user "+optionalUsers.get());
	        System.out.println("after getting data");
	        System.err.println(optionalUsers.get().getEmailId()+" "+optionalUsers.get().getPassword());
	        	System.out.println("CustomerUserDetailsService.loadUserByUsername() se");
	        optionalUsers
	                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
	        return optionalUsers
	                .map(CustomUserDetails::new).get();
	}

}
