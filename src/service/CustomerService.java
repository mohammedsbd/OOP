package service;

import model.Customer;
import dao.CustomerDAO;
import java.util.List;

public class CustomerService {
    private CustomerDAO customerDAO;
    
    public CustomerService() {
        this.customerDAO = new CustomerDAO();
    }
    
    public boolean updateCustomerProfile(Customer customer) {
        return customerDAO.updateCustomer(customer);
    }
    
    public boolean deleteCustomerAccount(int customerId) {
        return customerDAO.deleteCustomer(customerId);
    }
    
    public Customer getCustomerById(int id) {
        return customerDAO.getCustomerById(id);
    }
    
    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }
}