package com.hemanth.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hemanth.flightreservation.dto.ReservationUpdateRequest;
import com.hemanth.flightreservation.entities.Reservation;
import com.hemanth.flightreservation.repositories.ReservationRepository;

@RestController
@CrossOrigin // to communicate different services or modules with different port to our REST controller
public class ReservationRestController {
	
	@Autowired
	ReservationRepository reservationRepo;
	
	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		return reservationRepo.findById(id).get();
	}
	
	@RequestMapping("/reservations/")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		
		Reservation reservation = reservationRepo.findById(request.getId()).get();
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		
		return reservationRepo.save(reservation);
	}

}
