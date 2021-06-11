package santra.subham.flightmanagement.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Flight {
	private String id;
	private String flightType;
	private List<Passenger> passengers;

	public boolean addPassenger(Passenger passenger) {
		if (!flightType.equalsIgnoreCase("economy")) {
			if (passenger.isVip()) {
				return passengers.add(passenger);
			} else {
				return false;
			}
		} else {
			return passengers.add(passenger);
		}
	}

	public boolean removePassenger(Passenger passenger) {
		if (passenger.isVip()) {
			return false;
		}
		return passengers.remove(passenger);
	}
}
