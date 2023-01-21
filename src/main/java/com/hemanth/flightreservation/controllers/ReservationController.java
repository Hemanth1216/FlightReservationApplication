package com.hemanth.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hemanth.flightreservation.dto.ReservationRequest;
import com.hemanth.flightreservation.entities.Flight;
import com.hemanth.flightreservation.entities.Reservation;
import com.hemanth.flightreservation.repositories.FlightRepository;
import com.hemanth.flightreservation.services.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	FlightRepository flightRepo;
	
	@Autowired
	ReservationService service;
	
	@RequestMapping("showCompletereservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId,ModelMap model) {
		Flight flight = flightRepo.findById(flightId).get();
		model.addAttribute("flight", flight);
		return "completeReservation";
	}
	
	@RequestMapping(value="completeReservation", method=RequestMethod.POST)
	public String completeReservation(ReservationRequest request,ModelMap model) {
		Reservation reservation = service.bookFlight(request);
		model.addAttribute("msg","Your Reservation is Successfull and id is :"+reservation.getId());
		return "reservationConfirmation";
	}
}
