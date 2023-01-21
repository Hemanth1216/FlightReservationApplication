<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Complete Reservation</title>
</head>
<body>
	<h3>Flight Details : </h3>
	Airline : ${flight.operatingAirlines}<br/>
	Departure City : ${flight.departureCity}<br/>
	Arrival City : ${flight.arrivalCity}<br/>
	
	<form action="completeReservation" method="post">
		<pre>
			<h3>Passenger Details : </h3>
				FirstName : <input type="text" name="passengerFirstName"/>
				LastName : <input type="text" name="passengerLastName"/>
				Email : <input type="text" name="passengerEmail"/>
				PhoneNumber : <input type="text" name="passengerPhoneNumber"/>
				
			<h3>Card Details : </h3>
				Name on the card : <input type="text" name="nameOnTheCard"/>
				Card Number : <input type="text" name="cardNumber"/>
				Expiry Date : <input type="text" name="expirationDate"/>
				Security Code : <input type="text" name="securityCode"/>
				
			<input type="hidden" name="flightId" value="${flight.id}"/>
			<input type="submit" value="confirm"/>
		</pre>
	</form>
</body>
</html>