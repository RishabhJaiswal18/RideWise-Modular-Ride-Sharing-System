package com.ridewise.modul.strategy;

import java.util.List;

import com.ridewise.modul.model.Driver;
import com.ridewise.modul.model.Rider;

public interface RideMatchingStrategy {

	Driver findDriver(Rider rider, List<Driver> drivers);
}
