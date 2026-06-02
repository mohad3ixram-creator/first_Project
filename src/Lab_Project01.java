import java.util.Scanner;

public class Lab_Project01 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Account[] arr = new CheckBank[2];

        Info(arr);

        for (int x = 0; x < arr.length; x++) {

            System.out.printf("\n=== User %d ===\n", x + 1);

            System.out.print("How much do you want to deposit: ");
            double deposit = input.nextDouble();
            arr[x].deposit(deposit);

            System.out.print("How much do you want to withdraw: ");
            double withdraw = input.nextDouble();
            arr[x].withdraw(withdraw);

            arr[x].print();

            System.out.println("Interest: " + arr[x].calculateInterest());
        }
    }

    public static void Info(Account[] arr) {

        for (int x = 0; x < arr.length; x++) {

            System.out.printf("Enter username for account %d:%n", x + 1);
            String user = input.nextLine();

            System.out.printf("Enter balance for account %d:%n", x + 1);
            double balance = input.nextDouble();
            input.nextLine();

            System.out.printf("Enter name for account %d:%n", x + 1);
            String name = input.nextLine();

            System.out.printf("Enter password for account %d:%n", x + 1);
            String pass = CheckPass();

            arr[x] = new CheckBank(user, name, balance, pass);
        }
    }

    public static String CheckPass() {

        int attempt = 0;

        while (attempt < 3) {

            String pass = input.nextLine();

            if (pass.length() >= 4) {
                System.out.println("Password checked");
                return pass;
            }

            System.out.println("Enter password at least 4 characters");
            attempt++;
        }

        System.out.println("Invalid Password");
        return null;
    }
}




abstract class Account {

    private String accountNumber;
    private String ownerName;
    private double balance;

    public Account(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount");
        } else {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }

    public double getBalance() {
        return balance;
    }

    public void print() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Balance: " + balance);
    }

    abstract double calculateInterest();
}


class CheckBank extends Account {

    private String password;

    public CheckBank(String accountNumber, String ownerName, double balance, String password) {
        super(accountNumber, ownerName, balance);
        this.password = password;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.05;
    }

    public void showPassword() {
        System.out.println("Password: " + password);
    }
}