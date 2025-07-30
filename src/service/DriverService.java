package service;

import model.Customer;
import dao.CustomerDAO;
import util.InputValidator;

public class AuthService {
    private CustomerDAO customerDAO;
    
    public AuthService() {
        this.customerDAO = new CustomerDAO();
    }
    
    public Customer registerCustomer(String name, String email, String phone, String password) {
        if (!InputValidator.isValidEmail(email)) {
            System.out.println("Invalid email format");
            return null;
        }
        
        if (!InputValidator.isValidPhone(phone)) {
            System.out.println("Invalid phone number");
            return null;
        }
        
        if (customerDAO.getCustomerByEmail(email) != null) {
            System.out.println("Email already registered");
            return null;
        }
        
        Customer customer = new Customer(0, name, phone, email, password);
        if (customerDAO.addCustomer(customer)) {
            return customerDAO.getCustomerByEmail(email);
        }
        return null;
    }
    
    public Customer login(String email, String password) {
        Customer customer = customerDAO.getCustomerByEmail(email);
        if (customer != null && customer.getPassword().equals(password)) {
            return customer;
        }
        return null;
    }
}