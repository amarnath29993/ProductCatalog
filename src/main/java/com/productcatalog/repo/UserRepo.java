package com.productcatalog.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productcatalog.model.Users;

public interface UserRepo extends JpaRepository<Users, Integer> {
	Optional<Users> findByEmailId(String emailid);

	Optional<Users> findByUserName(String username);

}
