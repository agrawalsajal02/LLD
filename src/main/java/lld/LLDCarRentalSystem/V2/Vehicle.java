package lld.LLDCarRentalSystem.V2;

enum VehicleType { CAR, BIKE }

abstract class Vehicle {
    String vehicleId;
    String model;
    String brand;
    VehicleType type;
    double hourlyRate;

    public Vehicle(String id, String model, String brand, VehicleType type, double rate) {
        this.vehicleId = id;
        this.model = model;
        this.brand = brand;
        this.type = type;
        this.hourlyRate = rate;
    }
}

class Car extends Vehicle {
    public Car(String id, String model, String brand, double rate) {
        super(id, model, brand, VehicleType.CAR, rate);
    }
}

class Bike extends Vehicle {
    public Bike(String id, String model, String brand, double rate) {
        super(id, model, brand, VehicleType.BIKE, rate);
    }
}

