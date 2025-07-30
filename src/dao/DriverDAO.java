package dao;

import model.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriverDAO {
    public boolean addDriver(Driver driver) {
        String sql = "INSERT INTO Drivers(name, license_number, phone, vehicle_type, vehicle_number, is_available) " +
                     "VALUES(?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, driver.getName());
            pstmt.setString(2, driver.getLicenseNumber());
            pstmt.setString(3, driver.getPhone());
            pstmt.setString(4, driver.getVehicleType());
            pstmt.setString(5, driver.getVehicleNumber());
            pstmt.setBoolean(6, driver.isAvailable());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            Logger.log("Error adding driver: " + e.getMessage());
            return false;
        }
    }

    public Driver getDriverById(int id) {
        String sql = "SELECT * FROM Drivers WHERE driver_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return new Driver(
                    rs.getInt("driver_id"),
                    rs.getString("name"),
                    rs.getString("phone"),
                    rs.getString("license_number"),
                    rs.getString("vehicle_type"),
                    rs.getString("vehicle_number"),
                    rs.getBoolean("is_available")
                );
            }
        } catch (SQLException e) {
            Logger.log("Error getting driver by ID: " + e.getMessage());
        }
        return null;
    }

    public List<Driver> getAvailableDrivers() {
        List<Driver> drivers = new ArrayList<>();
        String sql = "SELECT * FROM Drivers WHERE is_available = true";
        
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                drivers.add(new Driver(
                    rs.getInt("driver_id"),
                    rs.getString("name"),
                    rs.getString("phone"),
                    rs.getString("license_number"),
                    rs.getString("vehicle_type"),
                    rs.getString("vehicle_number"),
                    rs.getBoolean("is_available")
                ));
            }
        } catch (SQLException e) {
            Logger.log("Error getting available drivers: " + e.getMessage());
        }
        return drivers;
    }

    public List<Driver> getAllDrivers() {
        List<Driver> drivers = new ArrayList<>();
        String sql = "SELECT * FROM Drivers";
        
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                drivers.add(new Driver(
                    rs.getInt("driver_id"),
                    rs.getString("name"),
                    rs.getString("phone"),
                    rs.getString("license_number"),
                    rs.getString("vehicle_type"),
                    rs.getString("vehicle_number"),
                    rs.getBoolean("is_available")
                ));
            }
        } catch (SQLException e) {
            Logger.log("Error getting all drivers: " + e.getMessage());
        }
        return drivers;
    }

    public boolean updateDriver(Driver driver) {
        String sql = "UPDATE Drivers SET name = ?, phone = ?, license_number = ?, " +
                     "vehicle_type = ?, vehicle_number = ?, is_available = ? WHERE driver_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, driver.getName());
            pstmt.setString(2, driver.getPhone());
            pstmt.setString(3, driver.getLicenseNumber());
            pstmt.setString(4, driver.getVehicleType());
            pstmt.setString(5, driver.getVehicleNumber());
            pstmt.setBoolean(6, driver.isAvailable());
            pstmt.setInt(7, driver.getId());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            Logger.log("Error updating driver: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteDriver(int id) {
        String sql = "DELETE FROM Drivers WHERE driver_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            Logger.log("Error deleting driver: " + e.getMessage());
            return false;
        }
    }
}