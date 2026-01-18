package com.ridewise.modul.service;

import java.util.ArrayList;
import java.util.List;

import com.ridewise.modul.model.Driver;
import com.ridewise.modul.model.FareReceipt;
import com.ridewise.modul.model.Ride;
import com.ridewise.modul.model.RideStatus;
import com.ridewise.modul.model.Rider;
import com.ridewise.modul.strategy.FareStrategy;
import com.ridewise.modul.strategy.RideMatchingStrategy;

public class RideService {

	private final RideMatchingStrategy rideMatchingStrategy;
	private final FareStrategy fareStrategy;
	private final List<Ride> rides = new ArrayList<>();
	private int rideCounter = 1;

	public RideService(RideMatchingStrategy rideMatchingStrategy, FareStrategy fareStrategy) {
		this.rideMatchingStrategy = rideMatchingStrategy;
		this.fareStrategy = fareStrategy;
	}

	public Ride requestRide(Rider rider, double distance, List<Driver> availableDrivers) {

		Ride ride = new Ride(rideCounter++, rider, distance);

		Driver assignedDriver = rideMatchingStrategy.findDriver(rider, availableDrivers);
		if (assignedDriver == null) {
			System.out.println("No drivers available!");
			return null;
		}

		assignedDriver.setAvailable(false);
		ride.assignDriver(assignedDriver);

		rides.add(ride);
		return ride;
	}

	public FareReceipt completeRide(int rideId) {

		for (Ride ride : rides) {
			if (ride.getId() == rideId && ride.getStatus() == RideStatus.ASSIGNED) {

				ride.completeRide();
				ride.getDriver().setAvailable(true);

				double fare = fareStrategy.calculateFare(ride);
				return new FareReceipt(ride.getId(), fare);
			}
		}
		return null;
	}

	public List<Ride> getAllRides() {
		return rides;
	}
}
