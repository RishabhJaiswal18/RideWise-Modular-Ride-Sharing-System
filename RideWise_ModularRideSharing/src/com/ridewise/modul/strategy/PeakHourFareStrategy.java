package com.ridewise.modul.strategy;

import com.ridewise.modul.model.Ride;

public class PeakHourFareStrategy implements FareStrategy {

	private static final double RATE_PER_KM = 10.0;
	private static final double PEAK_MULTIPLIER = 1.5;

	@Override
	public double calculateFare(Ride ride) {
		return ride.getDistance() * RATE_PER_KM * PEAK_MULTIPLIER;
	}

}
