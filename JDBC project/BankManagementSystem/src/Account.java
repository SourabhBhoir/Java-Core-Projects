// Account.java
public class Account {
    private String username;
    private String password;
    private double balance;

    // Constructor to initialize user details
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.balance = 0.0; // Default balance is 0
    }

    // Getter method for username
    public String getUsername() {
        return username;
    }

    // Method to validate password
    public boolean validatePassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Method to withdraw money
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
            return true;
        } else {
            System.out.println("Insufficient balance or invalid amount!");
            return false;
        }
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }
}
