package com.ridewise.modul.strategy;

import com.ridewise.modul.model.Ride;

public interface FareStrategy {

	double calculateFare(Ride ride);
}
