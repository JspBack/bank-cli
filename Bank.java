
import java.util.HashMap;
import java.util.Map;

public class Bank {

    private final Map<String, BankAccount> accounts;

    public Bank(int numAccounts) {
        this.accounts = new HashMap<>();
        for (int i = 0; i < numAccounts; i++) {
            accounts.put("A" + i, new BankAccount("A" + i));
        }
    }

    public void listAccounts() {
        for (BankAccount account : accounts.values()) {
            System.out.println(account);
        }
    }

    public boolean deposit(String accountNumber, double amount) {
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account " + accountNumber + " does not exist.");
            return false;
        }
        return account.deposit(amount);
    }

    public boolean withdraw(String accountNumber, double amount) {
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account " + accountNumber + " does not exist.");
            return false;
        }
        return account.withdraw(amount);
    }

    public void setActivated(String accountNumber, boolean active) {
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account " + accountNumber + " does not exist.");
            return;
        }
        account.setActivated(active);
    }

    public double getBalance(String accountNumber) {
        BankAccount account = accounts.get(accountNumber);
        return account.getBalance();
    }

    public String toString(String accountNumber) {
        BankAccount account = accounts.get(accountNumber);
        return account.toString();
    }

    public void displayBalances() {
        for (BankAccount account : accounts.values()) {
            if (account.isActivated()) {
                System.out.println(account);
            }
        }
    }
}
