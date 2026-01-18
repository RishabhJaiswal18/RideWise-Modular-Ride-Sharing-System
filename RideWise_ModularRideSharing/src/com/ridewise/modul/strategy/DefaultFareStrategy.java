package com.ridewise.modul.strategy;

import com.ridewise.modul.model.Ride;

public class DefaultFareStrategy implements FareStrategy {

	private static final double RATE_PER_KM = 10.0;

	@Override
	public double calculateFare(Ride ride) {
		return ride.getDistance() * RATE_PER_KM;
	}

}
