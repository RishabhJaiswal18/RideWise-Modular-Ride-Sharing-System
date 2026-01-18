package com.ridewise.modul.service;

import java.util.HashMap;
import java.util.Map;

import com.ridewise.modul.model.Rider;

public class RiderService {

	private final Map<Integer, Rider> riders = new HashMap<>();

	public void registerRider(Rider rider) {
		riders.put(rider.getId(), rider);
	}

	public Rider getRiderById(int id) {
		return riders.get(id);
	}

	public Map<Integer, Rider> getAllRiders() {
		return riders;
	}
}
