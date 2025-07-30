package service;

import model.Driver;
import dao.DriverDAO;
import java.util.List;

public class DriverService {
    private DriverDAO driverDAO;
    
    public DriverService() {
        this.driverDAO = new DriverDAO();
    }
    
    public boolean addDriver(Driver driver) {
        return driverDAO.addDriver(driver);
    }
    
    public boolean updateDriver(Driver driver) {
        return driverDAO.updateDriver(driver);
    }
    
    public boolean deleteDriver(int driverId) {
        return driverDAO.deleteDriver(driverId);
    }
    
    public Driver getDriverById(int id) {
        return driverDAO.getDriverById(id);
    }
    
    public List<Driver> getAvailableDrivers() {
        return driverDAO.getAvailableDrivers();
    }
    
    public List<Driver> getAllDrivers() {
        return driverDAO.getAllDrivers();
    }
}