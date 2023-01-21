package com.hemanth.flightreservation.services;

import com.hemanth.flightreservation.dto.ReservationRequest;
import com.hemanth.flightreservation.entities.Reservation;

public interface ReservationService {

	public Reservation bookFlight(ReservationRequest request);
}
