# Java Cab Booking System

## Project Overview

The **Java Cab Booking System** is a console-based application designed to demonstrate core object-oriented programming principles using Java and MySQL. The system allows customers to register, book rides, and view available drivers through a clean Command Line Interface (CLI). Drivers can be managed, and bookings tracked efficiently with persistent storage in a MySQL database.

**Key Features:**

- Customer Registration & Management  
- Driver Registration & Management  
- Booking System with pickup/drop locations  
- Booking Status Tracking (Pending, Confirmed, Cancelled)  
- Driver Availability Management  
- MySQL Database Integration for persistence  
- Robust Exception Handling and validation  
- Object-Oriented Design using Interfaces, Abstract Classes, and Polymorphism  
- File I/O Logging for auditing actions  

---

## Setup and Execution Instructions

### Prerequisites

- Java JDK 11 or higher  
- MySQL server installed and running  
- IDE or text editor (e.g., IntelliJ IDEA, Eclipse, VSCode)  
- Basic knowledge of command line operations  

### Database Setup

1. Install MySQL server if you haven't already.  
2. Create the database and tables by running the following SQL commands:

```sql
CREATE DATABASE cbs2;

USE cbs2;

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
Update the DBConnection class in the util package with your MySQL username and password.

Running the Project
Clone the repository:

bash
Copy
Edit
git clone https://github.com/yourusername/java-cab-booking-system.git
cd java-cab-booking-system
Compile the project:

bash
Copy
Edit
javac -d bin src/**/*.java
Run the application:

bash
Copy
Edit
java -cp bin App
Use the CLI menu to:

Register customers

Add drivers

Book rides

View bookings, customers, and drivers

Team Contributions
This project was collaboratively developed by five team members, each focusing on key components:

Team Member	Contribution Area
Mohammed	Database design, DAO implementations
Segni	Business logic and service layer
Nahom	User Interface (CLI) and menu navigation
Aaron	Exception handling, logging, and utility classes
Daniel	Integration, testing, and overall project setup

License
This project is licensed under the MIT License — see the LICENSE file for details.

Contact
Mohammed Salih
Email: mohammedsbd@example.com
GitHub: github.com/mohammedsbd
