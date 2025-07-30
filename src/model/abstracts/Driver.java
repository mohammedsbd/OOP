package model;

import model.abstract.User;

public class Driver extends User {
    private String licenseNumber;
    private String vehicleType;
    private String vehicleNumber;
    private boolean isAvailable;

    public Driver(int id, String name, String phone, String licenseNumber, 
                 String vehicleType, String vehicleNumber, boolean isAvailable) {
        super(id, name, phone);
        this.licenseNumber = licenseNumber;
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.isAvailable = isAvailable;
    }

    // Getters and setters
    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public void displayDetails() {
        System.out.println("Driver ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Phone: " + getPhone());
        System.out.println("License: " + licenseNumber);
        System.out.println("Vehicle: " + vehicleType + " (" + vehicleNumber + ")");
        System.out.println("Status: " + (isAvailable ? "Available" : "Not Available"));
    }
}