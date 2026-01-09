import java.util.Scanner;

class BankAccount {
    private String accountHolder;
    private int accountNumber;
    private double balance;

    
    BankAccount(String name, int accNo) {
        accountHolder = name;
        accountNumber = accNo;
        balance = 0;
    }

    
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount Deposited Successfully!");
        } else {
            System.out.println("Invalid Deposit Amount");
        }
    }

    
    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount Withdrawn Successfully!");
        } else {
            System.out.println("Insufficient Balance or Invalid Amount");
        }
    }

    
    void display() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }
}

public class BankApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        BankAccount account = new BankAccount(name, accNo);

        int choice;
        do {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    account.display();
                    break;

                case 4:
                    System.out.println("Thank you for using Bank Application!");
                    break;

                default:
                    System.out.println("Invalid Choice! Try Again.");
            }
        } while (choice != 4);

        sc.close();
    }
}
