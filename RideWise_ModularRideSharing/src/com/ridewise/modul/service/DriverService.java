package com.ridewise.modul.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ridewise.modul.model.Driver;

public class DriverService {

	private final Map<Integer, Driver> drivers = new HashMap<>();

	public void registerDriver(Driver driver) {
		drivers.put(driver.getId(), driver);
	}

	public void updateAvailability(int driverId, boolean available) {
		Driver driver = drivers.get(driverId);
		if (driver != null) {
			driver.setAvailable(available);
		}
	}

	public List<Driver> getAvailableDrivers() {
		List<Driver> availableDrivers = new ArrayList<>();
		for (Driver driver : drivers.values()) {
			if (driver.isAvailable()) {
				availableDrivers.add(driver);
			}
		}
		return availableDrivers;
	}

	public Driver getDriverById(int id) {
		return drivers.get(id);
	}
}
