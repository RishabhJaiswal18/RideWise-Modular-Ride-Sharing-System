package com.ridewise.modul.model;

import java.time.LocalDateTime;

public class FareReceipt {

	private final int rideId;
	private final double amount;
	private final LocalDateTime generatedAt;

	public FareReceipt(int rideId, double amount) {
		this.rideId = rideId;
		this.amount = amount;
		this.generatedAt = LocalDateTime.now();
	}

	public int getRideId() {
		return rideId;
	}

	public double getAmount() {
		return amount;
	}

	public LocalDateTime getGeneratedAt() {
		return generatedAt;
	}
}
