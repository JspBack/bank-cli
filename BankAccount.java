
public class BankAccount {

    private final String accountNumber;
    private double balance;
    private boolean isActivated;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.isActivated = false;
    }

    public boolean deposit(double amount) {
        if (isActivated) {
            balance += amount;
            return true;
        } else {
            System.out.println("This account is currently inactive.");
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (isActivated) {
            if (balance >= amount) {
                balance -= amount;
                return true;
            } else {
                System.out.println("Insufficient funds in this account.");
                return false;
            }
        } else {
            System.out.println("This account is currently inactive.");
            return false;
        }
    }

    public void setActivated(boolean active) {
        isActivated = active;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isActivated() {
        return isActivated;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber
                + "\nBalance: $" + String.format("%.2f", balance)
                + "\nActivated: " + (isActivated ? "Yes" : "No");
    }
}
