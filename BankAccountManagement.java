
import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {

    private String accountHolder;
    private String accountNumber;
    private double balance;

    private ArrayList<String> transactions = new ArrayList<>();

    // Constructor
    public BankAccount(String accountHolder,
                       String accountNumber,
                       double initialBalance) {

        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;

        transactions.add(
            "Account created with balance: Rs. " + initialBalance
        );
    }

    // Check balance
    public void checkBalance() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.printf("Current Balance: Rs. %.2f%n", balance);
    }

    // Deposit money
    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Please enter a valid amount.");
            return;
        }

        balance += amount;

        transactions.add("Deposited: Rs. " + amount);

        System.out.printf(
            "Rs. %.2f deposited successfully!%n", amount
        );

        System.out.printf("New Balance: Rs. %.2f%n", balance);
    }

    // Withdraw money
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Please enter a valid amount.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance!");
            return;
        }

        balance -= amount;

        transactions.add("Withdrawn: Rs. " + amount);

        System.out.printf(
            "Rs. %.2f withdrawn successfully!%n", amount
        );

        System.out.printf("Remaining Balance: Rs. %.2f%n", balance);
    }

    // View transaction history
    public void showTransactions() {

        System.out.println("\n--- Transaction History ---");

        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }
}

public class BankAccountManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount account = new BankAccount(
            "Priya",
            "1001234567",
            1000.00
        );

        int choice;

        do {
            System.out.println("\n==============================");
            System.out.println(" BANK ACCOUNT MANAGEMENT SYSTEM");
            System.out.println("==============================");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.println("==============================");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    account.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter deposit amount: Rs. ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: Rs. ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 4:
                    account.showTransactions();
                    break;

                case 5:
                    System.out.println("Thank you for using our system!");
                    break;

                default:
                    System.out.println(
                        "Invalid choice! Please select 1 to 5."
                    );
            }

        } while (choice != 5);

        sc.close();
    }
}
