class BankAccount {
    private String accountNumber;
    private double balance;
    private String accountHolderName;

    public BankAccount(String accountNumber, double initialBalance, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.accountHolderName = accountHolderName;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + " to account: " + accountNumber);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + " from account: " + accountNumber);
        } else {
            System.out.println("Invalid withdraw amount or insufficient funds");
        }
    }

    public double checkBalance() {
        return balance;
    }

    public void displayAccountDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

public class SimpleBankAccount {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("123456789", 1000.0, "Musaib");
        BankAccount account2 = new BankAccount("987654321", 500.0, "Zahoor");

        account1.deposit(200.0);
        account1.withdraw(150.0);
        account1.displayAccountDetails();
        System.out.println("Current Balance: " + account1.checkBalance());
        System.out.println();

        account2.deposit(300.0);
        account2.withdraw(100.0);
        account2.displayAccountDetails();
        System.out.println("Current Balance: " + account2.checkBalance());
    }
}