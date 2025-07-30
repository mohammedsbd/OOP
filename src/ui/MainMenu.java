package ui;

import model.Booking;
import model.Customer;
import service.AuthService;
import service.BookingService;
import service.CustomerService;
import service.DriverService;
import util.InputValidator;

import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private Scanner scanner;
    private AuthService authService;
    private CustomerService customerService;
    private DriverService driverService;
    private BookingService bookingService;
    private Customer currentCustomer;
    
    public MainMenu() {
        this.scanner = new Scanner(System.in);
        this.authService = new AuthService();
        this.customerService = new CustomerService();
        this.driverService = new DriverService();
        this.bookingService = new BookingService();
    }
    
    public void start() {
        while (true) {
            if (currentCustomer == null) {
                showWelcomeMenu();
            } else {
                showMainMenu();
            }
        }
    }
    
    private void showWelcomeMenu() {
        System.out.println("\n=== Cab Booking System ===");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        switch (choice) {
            case 1:
                registerCustomer();
                break;
            case 2:
                loginCustomer();
                break;
            case 3:
                System.out.println("Thank you for using our service. Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    
    private void registerCustomer() {
        System.out.println("\n=== Customer Registration ===");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter your phone number: ");
        String phone = scanner.nextLine();
        
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        
        Customer customer = authService.registerCustomer(name, email, phone, password);
        if (customer != null) {
            System.out.println("Registration successful! You can now login.");
        } else {
            System.out.println("Registration failed. Please try again.");
        }
    }
    
    private void loginCustomer() {
        System.out.println("\n=== Customer Login ===");
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        
        Customer customer = authService.login(email, password);
        if (customer != null) {
            currentCustomer = customer;
            System.out.println("Login successful! Welcome, " + customer.getName() + "!");
        } else {
            System.out.println("Invalid email or password. Please try again.");
        }
    }
    
    private void showMainMenu() {
        System.out.println("\n=== Main Menu ===");
        System.out.println("1. Book a Cab");
        System.out.println("2. View My Bookings");
        System.out.println("3. Cancel a Booking");
        System.out.println("4. View Profile");
        System.out.println("5. Update Profile");
        System.out.println("6. Logout");
        System.out.print("Choose an option: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        switch (choice) {
            case 1:
                bookCab();
                break;
            case 2:
                viewBookings();
                break;
            case 3:
                cancelBooking();
                break;
            case 4:
                viewProfile();
                break;
            case 5:
                updateProfile();
                break;
            case 6:
                logout();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    
    private void bookCab() {
        System.out.println("\n=== Book a Cab ===");
        System.out.print("Enter pickup location: ");
        String pickup = scanner.nextLine();
        
        System.out.print("Enter drop location: ");
        String drop = scanner.nextLine();
        
        // In a real system, we would calculate fare based on distance
        System.out.print("Enter estimated fare: ");
        double fare = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        
        Booking booking = bookingService.createBooking(
            currentCustomer.getId(), pickup, drop, fare);
        
        if (booking != null) {
            System.out.println("\nBooking successful!");
            System.out.println("Booking ID: " + booking.getBookingId());
            System.out.println("Driver assigned: " + 
                driverService.getDriverById(booking.getDriverId()).getName());
            System.out.println("Status: " + booking.getStatus());
        } else {
            System.out.println("Booking failed. Please try again later.");
        }
    }
    
    private void viewBookings() {
        System.out.println("\n=== Your Bookings ===");
        List<Booking> bookings = bookingService.getCustomerBookings(currentCustomer.getId());
        
        if (bookings.isEmpty()) {
            System.out.println("You have no bookings yet.");
            return;
        }
        
        for (Booking booking : bookings) {
            System.out.println("\nBooking ID: " + booking.getBookingId());
            System.out.println("Pickup: " + booking.getPickupLocation());
            System.out.println("Drop: " + booking.getDropLocation());
            System.out.println("Fare: $" + booking.getFare());
            System.out.println("Status: " + booking.getStatus());
            System.out.println("Time: " + booking.getBookingTime());
            System.out.println("Driver: " + 
                driverService.getDriverById(booking.getDriverId()).getName());
            System.out.println("---------------------");
        }
    }
    
    private void cancelBooking() {
        System.out.println("\n=== Cancel a Booking ===");
        viewBookings();
        
        System.out.print("\nEnter booking ID to cancel (or 0 to go back): ");
        int bookingId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        if (bookingId == 0) {
            return;
        }
        
        Booking booking = bookingService.getBookingById(bookingId);
        if (booking == null || booking.getCustomerId() != currentCustomer.getId()) {
            System.out.println("Invalid booking ID.");
            return;
        }
        
        if (!booking.getStatus().equals("Pending")) {
            System.out.println("Only pending bookings can be cancelled.");
            return;
        }
        
        if (bookingService.cancelBooking(bookingId)) {
            System.out.println("Booking cancelled successfully.");
        } else {
            System.out.println("Failed to cancel booking. Please try again.");
        }
    }
    
    private void viewProfile() {
        System.out.println("\n=== Your Profile ===");
        currentCustomer.displayDetails();
    }
    
    private void updateProfile() {
        System.out.println("\n=== Update Profile ===");
        viewProfile();
        
        System.out.print("\nEnter new name (leave blank to keep current): ");
        String name = scanner.nextLine();
        
        System.out.print("Enter new phone (leave blank to keep current): ");
        String phone = scanner.nextLine();
        
        System.out.print("Enter new password (leave blank to keep current): ");
        String password = scanner.nextLine();
        
        // Update only fields that were provided
        if (!name.isEmpty()) {
            currentCustomer.setName(name);
        }
        
        if (!phone.isEmpty()) {
            if (InputValidator.isValidPhone(phone)) {
                currentCustomer.setPhone(phone);
            } else {
                System.out.println("Invalid phone number. Phone not updated.");
            }
        }
        
        if (!password.isEmpty()) {
            if (InputValidator.isValidPassword(password)) {
                currentCustomer.setPassword(password);
            } else {
                System.out.println("Password must be at least 6 characters. Password not updated.");
            }
        }
        
        if (customerService.updateCustomerProfile(currentCustomer)) {
            System.out.println("Profile updated successfully.");
        } else {
            System.out.println("Failed to update profile. Please try again.");
        }
    }
    
    private void logout() {
        currentCustomer = null;
        System.out.println("You have been logged out.");
    }
}