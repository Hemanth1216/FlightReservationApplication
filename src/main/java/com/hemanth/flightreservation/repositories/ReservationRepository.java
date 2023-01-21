package com.hemanth.flightreservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hemanth.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
