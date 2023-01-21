package com.hemanth.flightreservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hemanth.flightreservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
