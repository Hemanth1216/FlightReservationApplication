<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Flights</title>
</head>
<body>
	<div>
		<h2>Available Flights are : </h2>
		<table>
			<thead>
				<tr>
					<th>FlightNumber</th>
					<th>Airlines</th>
					<th>DepartureCity</th>
					<th>ArrivalCity</th>
					<th>DepartureTime</th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${flights}" var="flight">
					<tr>
						<td>${flight.flightNumber}</td>
						<td>${flight.operatingAirlines}</td>
						<td>${flight.arrivalCity}</td>
						<td>${flight.departureCity}</td>
						<td>${flight.estimatedDepartureTime}</td>
						<td><a href="showCompletereservation?flightId=${flight.id}">select</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>