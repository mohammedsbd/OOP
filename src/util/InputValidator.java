package util;

public class InputValidator {
    public static boolean isValidEmail(String email) {
        // Simple email validation
        return email != null && email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }
    
    public static boolean isValidPhone(String phone) {
        // Simple phone validation (10 digits)
        return phone != null && phone.matches("\\d{10}");
    }
    
    public static boolean isValidPassword(String password) {
        // At least 6 characters
        return password != null && password.length() >= 6;
    }
}