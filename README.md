# Java Cab Booking System

A **Java-based Cab Booking System** implementing core object-oriented programming principles with a MySQL backend. The system allows customers to register, book rides, view drivers, and make payments. Drivers can be managed, and bookings tracked — all via a clean Command Line Interface (CLI).

---

## Features

- Customer Registration & Management  
- Driver Registration & Management  
- Booking System with pickup/drop locations  
- Payment Simulation with random fare generation  
- Booking Status Tracking (Pending, Confirmed, Cancelled)  
- Driver Availability Management  
- MySQL Database Integration for persistent storage  
- Robust Exception Handling and validation  
- Object-Oriented Design using Interfaces, Abstract Classes, and Polymorphism  
- File I/O Logging for auditing actions  

---

## Technologies Used

- Java  
- MySQL  
- JDBC for database connectivity  
- Command Line Interface (CLI)  

---

## System Architecture

The project follows a modular architecture with packages such as:

- `model` — Entity classes like Customer, Driver, Booking  
- `dao` — Data Access Objects for database operations  
- `service` — Business logic, including payment simulation  
- `util` — Database connection utilities  
- `ui` — User interface (CLI menu system)  

---

## Database Setup

1. Install MySQL server if not installed.  
2. Create a database named `cbs2`:
   ```sql
   CREATE DATABASE cbs2;
Create required tables (customers, drivers, bookings) with appropriate columns and types. Example:

sql
Copy
Edit
CREATE TABLE customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    phone VARCHAR(20)
);

CREATE TABLE drivers (
    driver_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    phone VARCHAR(20),
    vehicle_no VARCHAR(20),
    status VARCHAR(20)
);

CREATE TABLE bookings (
    booking_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    driver_id INT NULL,
    pickup_location VARCHAR(100),
    drop_location VARCHAR(100),
    status VARCHAR(20),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    FOREIGN KEY (driver_id) REFERENCES drivers(driver_id)
);
Update your DBConnection class with your MySQL credentials.

Getting Started
Prerequisites
Java JDK 11 or higher installed

MySQL server running with your database setup

IDE or text editor (IntelliJ IDEA, Eclipse, VSCode, etc.)

Running the Project
Clone the repository:

bash
Copy
Edit
git clone https://github.com/yourusername/java-cab-booking-system.git
cd java-cab-booking-system
Compile the project (if using command line):

bash
Copy
Edit
javac -d bin src/**/*.java
Or open the project in your IDE and run App.java directly.

Run the main application:

bash
Copy
Edit
java -cp bin App
Use the CLI menu to navigate through options:

Register as customer

Add drivers

Book a cab

Make payment

View all bookings, drivers, customers

How the System Works (Step-by-step)
Customer Registration:
Customers enter their name and phone number to register.

Driver Management:
Admins add drivers with vehicle info and set their availability status.

Booking:
Customers create bookings by specifying pickup and drop locations. Available drivers are assigned.

Payment:
A random payment amount is generated and customers confirm or cancel the payment.

Booking Confirmation:
Upon payment success, booking status updates to "Confirmed". If payment is cancelled, the booking is cancelled.

Tracking & Viewing:
Users can view lists of customers, drivers, and bookings with their statuses.

Code Structure
model/ — Entity classes (Customer, Driver, Booking)

dao/ — Database interaction classes (CustomerDAO, DriverDAO, BookingDAO)

service/ — Business logic (PaymentService)

util/ — Database connection (DBConnection)

ui/ — CLI menus and user interaction handlers

App.java — Main class launching the application

Future Enhancements
GUI interface for better user experience

Real payment gateway integration

Driver rating system

SMS/email notifications

Cab type and fare calculation

Admin panel with advanced reporting

Contributing
Contributions are welcome! Feel free to:

Report bugs

Suggest features

Submit pull requests

Please ensure your code follows existing style and includes proper documentation.

License
This project is licensed under the MIT License — see the LICENSE file for details.

Contact
Mohammed Salih
Email: mohammedsbd@example.com
GitHub: github.com/mohammedsbd
