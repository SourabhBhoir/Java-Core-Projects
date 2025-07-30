// BankManagement.java
import java.util.*;

public class BankManagement {
    private static ArrayList<Account> accounts = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n->||    Welcome to InBank    ||<-");
            System.out.println("1) Create Account");
            System.out.println("2) Login Account");
            System.out.println("3) Exit");
            System.out.print("Enter Input: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    loginAccount();
                    break;
                case 3:
                    System.out.println("Thank you for using InBank. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            }
        }
    }

    // Method to create a new account
    private static void createAccount() {
        System.out.print("Enter Username: ");
        String username = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        // Check if username already exists
        for (Account acc : accounts) {
            if (acc.getUsername().equals(username)) {
                System.out.println("Username already taken. Try again.");
                return;
            }
        }

        // Create and store the new account
        accounts.add(new Account(username, password));
        System.out.println("Account created successfully!");
    }

    // Method to login and access account functionalities
    private static void loginAccount() {
        System.out.print("Enter Username: ");
        String username = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        // Validate user credentials
        for (Account acc : accounts) {
            if (acc.getUsername().equals(username) && acc.validatePassword(password)) {
                System.out.println("Login successful! Welcome, " + username + "!");
                accountMenu(acc);
                return;
            }
        }
        System.out.println("Invalid username or password. Please try again.");
    }

    // Method for logged-in users to perform banking operations
    private static void accountMenu(Account account) {
        while (true) {
            System.out.println("\n->||    Account Menu    ||<-");
            System.out.println("1) Deposit Money");
            System.out.println("2) Withdraw Money");
            System.out.println("3) Check Balance");
            System.out.println("4) Logout");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ₹");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;//to out back
                default:
                    System.out.println("Invalid choice! Please enter 1, 2, 3, or 4.");
            }
        }
    }
}
