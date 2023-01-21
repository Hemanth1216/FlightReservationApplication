package com.hemanth.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hemanth.flightreservation.dto.ReservationRequest;
import com.hemanth.flightreservation.entities.Flight;
import com.hemanth.flightreservation.entities.Passenger;
import com.hemanth.flightreservation.entities.Reservation;
import com.hemanth.flightreservation.repositories.FlightRepository;
import com.hemanth.flightreservation.repositories.PassengerRepository;
import com.hemanth.flightreservation.repositories.ReservationRepository;
import com.hemanth.flightreservation.util.EmailUtil;
import com.hemanth.flightreservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Value("${com.hemanth.flightreservation.itinerary.dirpath}")
	private String ITINERARY_DIR;

	@Autowired
	PassengerRepository passengerRepo;
	
	@Autowired
	FlightRepository flightRepo;
	
	@Autowired
	ReservationRepository reservationRepo;
	
	@Autowired
	PDFGenerator pdfGenerator;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Override
	@Transactional
	public Reservation bookFlight(ReservationRequest request) {
		
		//----------Make Payment-----------
		
		Long flightId = request.getFlightId();
		Flight flight = flightRepo.findById(flightId).get();
		
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhoneNumber());
		
		Passenger savedPassenger = passengerRepo.save(passenger);
		
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		
		Reservation savedReservation = reservationRepo.save(reservation);
		
		String filePath = ITINERARY_DIR+savedReservation.getId()+".pdf";
		pdfGenerator.generateItinerary(savedReservation, filePath );
		
		emailUtil.sendItinerary(savedPassenger.getEmail(), filePath);
		return savedReservation;
	}

}
