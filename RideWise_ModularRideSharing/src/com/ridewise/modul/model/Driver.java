package com.ridewise.modul.model;

public class Driver {

	private final int id;
	private final String name;
	private String currentLocation;
	private boolean available;

	public Driver(int id, String name, String currentLocation) {
		this.id = id;
		this.name = name;
		this.currentLocation = currentLocation;
		this.available = true;
	}

	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
