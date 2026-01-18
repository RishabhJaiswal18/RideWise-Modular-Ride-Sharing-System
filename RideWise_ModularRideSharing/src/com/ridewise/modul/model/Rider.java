package com.ridewise.modul.model;

public class Rider {

	private final int id;
	private final String name;
	private String location;

	public Rider(int id, String name, String location) {
		this.id = id;
		this.name = name;
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
