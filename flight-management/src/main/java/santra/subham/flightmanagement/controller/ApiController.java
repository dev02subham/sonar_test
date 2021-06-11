package santra.subham.flightmanagement.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import santra.subham.flightmanagement.model.Flight;
import santra.subham.flightmanagement.model.Passenger;

/**
 * @author Subham Santra
 *
 */
@RestController
@Log4j2
public class ApiController {

	private final Flight economyFlights = new Flight("FE", "economy", new ArrayList<>());
	private final Flight businessFlights = new Flight("FB", "business", new ArrayList<>());

	@GetMapping("flights/test")
	public String test() {
		log.debug("Test method");
		return "working";
	}

	@PostMapping("flights/{flightType}")
	public String addFlight(@PathVariable String flightType, @RequestBody Passenger passenger) {
		log.debug("adding " + passenger + " to " + flightType);
		if (flightType.equalsIgnoreCase(economyFlights.getFlightType())) {
			boolean addPassenger = economyFlights.addPassenger(passenger);
			if (addPassenger) {
				log.debug("passenger added to economy class");
				return "passenger added to economy class";
			} else {
				log.debug("passenger could not be added to economy class");
				return "passenger could not be added to economy class";
			}
		} else if (flightType.equalsIgnoreCase(businessFlights.getFlightType())) {
			boolean addPassenger = businessFlights.addPassenger(passenger);
			if (addPassenger) {
				log.debug("passenger added to business class");
				return "passenger added to business class";
			} else {
				log.debug("passenger could not be added to business class");
				return "passenger could not be added to business class";
			}
		}
		return "NA";
	}

	@DeleteMapping("flights/{flightType}")
	public String removeFlight(@PathVariable String flightType, @RequestBody Passenger passenger) {
		log.debug("adding " + passenger + " to " + flightType);
		if (flightType.equalsIgnoreCase(economyFlights.getFlightType())) {
			boolean addPassenger = economyFlights.removePassenger(passenger);
			if (addPassenger) {
				log.debug("passenger removed from economy class");
				return "passenger removed from economy class";
			} else {
				log.debug("passenger could not be removed from economy class");
				return "passenger could not be removed from economy class";
			}
		} else if (flightType.equalsIgnoreCase(businessFlights.getFlightType())) {
			boolean removePassenger = businessFlights.removePassenger(passenger);
			if (removePassenger) {
				log.debug("passenger removed from business class");
				return "passenger removed from business class";
			} else {
				log.debug("passenger could not be removed from business class");
				return "passenger could not be removed from business class";
			}
		}
		return "NA";
	}

}
