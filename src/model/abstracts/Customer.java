package model.abstracts;

// import model.abstract.User;

public class Customer extends User {
    private String email;
    private String password;

    public Customer(int id, String name, String phone, String email, String password) {
        super(id, name, phone);
        this.email = email;
        this.password = password;
    }

    // Getters and setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void displayDetails() {
        System.out.println("Customer ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Email: " + email);
        System.out.println("Phone: " + getPhone());
    }
}