# RideWise-Modular-Ride-Sharing-System
📌 Project Overview

RideWise is a console-based modular ride-sharing system designed to demonstrate:

Object-Oriented Programming (OOP)

SOLID principles

Strategy Pattern

Clean Low-Level Design (LLD)

The system allows riders to request rides, drivers to be assigned using configurable strategies, and fares to be calculated using pluggable pricing logic.

This project is built using pure Java (no frameworks) to focus on design clarity and extensibility.

🎯 Learning Objectives Covered
OOP & SOLID

SRP: Each class has a single responsibility

OCP: New pricing or matching strategies can be added without modifying existing code

LSP: All strategy implementations are interchangeable

ISP: Small, focused interfaces (RideMatchingStrategy, FareStrategy)

DIP: Services depend on abstractions, not concrete implementations

Design Principles

DRY: No duplicate ride allocation logic

KISS: Simple entity modeling and workflows

YAGNI: Only MVP features implemented

Law of Demeter: Services interact only with direct collaborators

🧩 System Architecture
model/
 ├── Rider
 ├── Driver
 ├── Ride
 ├── FareReceipt
 ├── RideStatus (enum)
 └── VehicleType (enum)

strategy/
 ├── RideMatchingStrategy
 ├── NearestDriverStrategy
 ├── LeastActiveDriverStrategy
 ├── FareStrategy
 ├── DefaultFareStrategy
 └── PeakHourFareStrategy

service/
 ├── RiderService
 ├── DriverService
 └── RideService

RideWiseModularSystem.java
### Note: You can directly import this Java Project in any of the Java IDE directly and run as JAVA Application

🚖 Application Workflow (High Level)

Riders and drivers are registered.

Drivers are marked available by default.

A rider requests a ride.

RideMatchingStrategy selects a driver.

Ride is assigned and marked ASSIGNED.

Ride is completed.

FareStrategy calculates fare.

Fare receipt is generated.

Driver becomes available again.

🧠 Strategy Pattern Usage
### Ride Matching Strategy
public interface RideMatchingStrategy {
    Driver findDriver(Rider rider, List<Driver> drivers);
}

Implementations:

NearestDriverStrategy

LeastActiveDriverStrategy

### Fare Calculation Strategy

public interface FareStrategy {
    double calculateFare(Ride ride);
}

Implementations:

DefaultFareStrategy

PeakHourFareStrategy

Strategies are injected into RideService using constructor injection, enabling:

Loose coupling

Runtime behavior change

Open/Closed compliance

🏗️ Service Layer Responsibilities
RiderService

Register riders

Fetch riders by ID

DriverService

Register drivers

Update driver availability

List available drivers

RideService

Request ride

Assign driver using RideMatchingStrategy

Complete ride

Calculate fare using FareStrategy

Maintain ride lifecycle

🖥️ Console Menu
1. Add Rider
2. Add Driver
3. View Available Drivers
4. Request Ride
5. Complete Ride
6. View Rides
7. Exit
All menu actions interact only with the service layer.

▶️ How to Run

Clone the repository

Use JAVA IDE import the project run as JAVA Aplication

Use the console menu to interact with the system

🧪 Future Enhancements

Rating-based driver matching

Surge pricing strategy

Database persistence

REST API layer

Web UI integration
