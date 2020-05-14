package com.productcatalog.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productcatalog.model.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {
	Optional<Role> findByRole(Integer roleId);

}
