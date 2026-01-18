package com.ridewise.modul.controller;

import java.util.List;
import java.util.Scanner;

import com.ridewise.modul.model.Driver;
import com.ridewise.modul.model.FareReceipt;
import com.ridewise.modul.model.Ride;
import com.ridewise.modul.model.Rider;
import com.ridewise.modul.service.DriverService;
import com.ridewise.modul.service.RideService;
import com.ridewise.modul.service.RiderService;
import com.ridewise.modul.strategy.DefaultFareStrategy;
import com.ridewise.modul.strategy.NearestDriverStrategy;

public class RideWiseModularSystem {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		RiderService riderService = new RiderService();
		DriverService driverService = new DriverService();

		RideService rideService = new RideService(new NearestDriverStrategy(), new DefaultFareStrategy());

		boolean running = true;

		while (running) {
			printMenu();
			int choice = readInt(scanner);

			switch (choice) {

			case 1:
				System.out.print("Enter Rider ID: ");
				int riderId = readInt(scanner);

				System.out.print("Enter Rider Name: ");
				String riderName = scanner.next();

				System.out.print("Enter Rider Location: ");
				String riderLocation = scanner.next();

				riderService.registerRider(new Rider(riderId, riderName, riderLocation));
				System.out.println("Rider added successfully!");
				break;

			case 2:
				System.out.print("Enter Driver ID: ");
				int driverId = readInt(scanner);

				System.out.print("Enter Driver Name: ");
				String driverName = scanner.next();

				System.out.print("Enter Driver Location: ");
				String driverLocation = scanner.next();

				driverService.registerDriver(new Driver(driverId, driverName, driverLocation));
				System.out.println("Driver added successfully!");
				break;

			case 3:
				List<Driver> drivers = driverService.getAvailableDrivers();
				if (drivers.isEmpty()) {
					System.out.println("No drivers available.");
				} else {
					for (Driver d : drivers) {
						System.out.println(d.getId() + " - " + d.getName());
					}
				}
				break;

			case 4:
				System.out.print("Enter Rider ID: ");
				int rId = readInt(scanner);
				Rider rider = riderService.getRiderById(rId);

				if (rider == null) {
					System.out.println("Invalid Rider ID.");
					break;
				}

				System.out.print("Enter Distance (km): ");
				double distance = scanner.nextDouble();

				Ride ride = rideService.requestRide(rider, distance, driverService.getAvailableDrivers());

				if (ride != null) {
					System.out.println("Ride requested successfully!");
					System.out.println("Ride ID: " + ride.getId());
					System.out.println("Driver Assigned: " + ride.getDriver().getName());
				}
				break;

			case 5:
				System.out.print("Enter Ride ID to complete: ");
				int rideIdToComplete = readInt(scanner);

				FareReceipt receipt = rideService.completeRide(rideIdToComplete);
				if (receipt != null) {
					System.out.println("Ride completed!");
					System.out.println("Fare: ₹" + receipt.getAmount());
				} else {
					System.out.println("Invalid Ride ID or Ride not active.");
				}
				break;

			case 6:
				List<Ride> rides = rideService.getAllRides();
				if (rides.isEmpty()) {
					System.out.println("No rides found.");
				} else {
					for (Ride r : rides) {
						System.out.println("Ride ID: " + r.getId() + ", Rider: " + r.getRider().getName() + ", Status: "
								+ r.getStatus());
					}
				}
				break;

			case 7:
				running = false;
				System.out.println("Exiting application...");
				break;

			default:
				System.out.println("Invalid choice. Try again.");
			}
		}
		scanner.close();
	}

	private static void printMenu() {
		System.out.println("\n==== RideWise Menu ====");
		System.out.println("1. Add Rider");
		System.out.println("2. Add Driver");
		System.out.println("3. View Available Drivers");
		System.out.println("4. Request Ride");
		System.out.println("5. Complete Ride");
		System.out.println("6. View Rides");
		System.out.println("7. Exit");
		System.out.print("Choose option: ");
	}

	private static int readInt(Scanner scanner) {
		while (!scanner.hasNextInt()) {
			scanner.next();
			System.out.print("Enter a valid number: ");
		}
		return scanner.nextInt();
	}

}
