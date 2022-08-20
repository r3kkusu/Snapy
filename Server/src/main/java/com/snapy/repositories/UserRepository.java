package com.snapy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

import com.snapy.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "SELECT * FROM user WHERE email = :email AND username = :username", nativeQuery = true)
	public List<User> find(@Param("email") String email, @Param("username") String username);
}
