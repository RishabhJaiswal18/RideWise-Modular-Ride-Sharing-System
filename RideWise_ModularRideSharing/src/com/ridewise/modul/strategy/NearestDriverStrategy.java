package com.ridewise.modul.strategy;

import java.util.List;

import com.ridewise.modul.model.Driver;
import com.ridewise.modul.model.Rider;

public class NearestDriverStrategy implements RideMatchingStrategy {

	@Override
	public Driver findDriver(Rider rider, List<Driver> drivers) {
		for (Driver driver : drivers) {
			if (driver.isAvailable()) {
				return driver;
			}
		}
		return null;
	}

}
