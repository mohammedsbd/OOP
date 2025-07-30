package model;

import java.time.LocalDateTime;

public class Booking {
    private int bookingId;
    private int customerId;
    private int driverId;
    private String pickupLocation;
    private String dropLocation;
    private LocalDateTime bookingTime;
    private double fare;
    private String status;

    public Booking(int bookingId, int customerId, int driverId, String pickupLocation, 
                  String dropLocation, LocalDateTime bookingTime, double fare, String status) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.driverId = driverId;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.bookingTime = bookingTime;
        this.fare = fare;
        this.status = status;
    }

    // Getters and setters
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displayDetails() {
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Customer ID: " + customerId);
        System.out.println("Driver ID: " + driverId);
        System.out.println("Pickup: " + pickupLocation);
        System.out.println("Drop: " + dropLocation);
        System.out.println("Time: " + bookingTime);
        System.out.println("Fare: $" + fare);
        System.out.println("Status: " + status);
    }
}