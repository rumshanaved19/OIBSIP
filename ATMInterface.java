package OASIS_INFOBYTE;
import java.util.*;

public class ATMInterface {
    static Scanner scanner = new Scanner(System.in);
    static double balance = 850000000;
    static String transactionHistory = "";
    static String userId = "user123";
    static String userPin = "1234";

    public static void main(String[] args) {
        System.out.println("Welcome to the ATM Interface");

        // User Authentication
        if (login()) {
            int option;
            do {
                showMenu();
                option = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (option) {
                    case 1:
                        showTransactionHistory();
                        break;
                    case 2:
                        withdraw();
                        break;
                    case 3:
                        deposit();
                        break;
                    case 4:
                        transfer();
                        break;
                    case 5:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid Option. Please try again.");
                }
            } while (option != 5);
        } else {
            System.out.println("Authentication Failed. Exiting...");
        }
    }

    // Login Method
    private static boolean login() {
        System.out.print("Enter User ID: ");
        String inputId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String inputPin = scanner.nextLine();

        return inputId.equals(userId) && inputPin.equals(userPin);
    }

    // Menu Display
    private static void showMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Transaction History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");
        System.out.print("Choose an option: ");
    }

    // Transaction History
    private static void showTransactionHistory() {
        System.out.println("\n--- Transaction History ---");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println(transactionHistory);
        }
    }

    // Withdraw
    private static void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory += "Withdrawn: $" + amount + "\n";
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Deposit
    private static void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            transactionHistory += "Deposited: $" + amount + "\n";
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    // Transfer
    private static void transfer() {
        System.out.print("Enter recipient name: ");
        String recipient = scanner.next();
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory += "Transferred $" + amount + " to " + recipient + "\n";
            System.out.println("Transfer successful to " + recipient);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}

