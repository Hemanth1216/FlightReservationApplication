package com.hemanth.flightreservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hemanth.flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
