package com.ridewise.modul.model;

public class Ride {

	private final int id;
	private final Rider rider;
	private Driver driver;
	private final double distance;
	private RideStatus status;

	public Ride(int id, Rider rider, double distance) {
		this.id = id;
		this.rider = rider;
		this.distance = distance;
		this.status = RideStatus.REQUESTED;
	}

	public int getId() {
		return id;
	}

	public Rider getRider() {
		return rider;
	}

	public double getDistance() {
		return distance;
	}

	public Driver getDriver() {
		return driver;
	}

	public void assignDriver(Driver driver) {
		this.driver = driver;
		this.status = RideStatus.ASSIGNED;
	}

	public RideStatus getStatus() {
		return status;
	}

	public void completeRide() {
		this.status = RideStatus.COMPLETED;
	}
}
