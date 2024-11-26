
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank(5);
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("\nBank CLI Menu:");
            System.out.println("1. Activate Account");
            System.out.println("2. Deactivate Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Display Balances(Only for activated accounts)");
            System.out.println("6. Get Detail of a account");
            System.out.println("7. List Accounts");
            System.out.println("8. Create Account");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            command = scanner.nextLine();

            switch (command) {
                case "1":
                    System.out.print("Enter account number to activate: ");
                    String activateAccount = scanner.nextLine();
                    bank.setActivated(activateAccount, true);
                    System.out.println("Account " + activateAccount + " activated.");
                    break;
                case "2":
                    System.out.print("Enter account number to deactivate: ");
                    String deactivateAccount = scanner.nextLine();
                    bank.setActivated(deactivateAccount, false);
                    System.out.println("Account " + deactivateAccount + " deactivated.");
                    break;
                case "3":
                    System.out.print("Enter account number to deposit into: ");
                    String depositAccount = scanner.nextLine();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = Double.parseDouble(scanner.nextLine());
                    if (bank.deposit(depositAccount, depositAmount)) {
                        System.out.println("Deposited $" + depositAmount + " into account " + depositAccount + ".");
                    }
                    break;
                case "4":
                    System.out.print("Enter account number to withdraw from: ");
                    String withdrawAccount = scanner.nextLine();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = Double.parseDouble(scanner.nextLine());
                    if (bank.withdraw(withdrawAccount, withdrawAmount)) {
                        System.out.println("Withdrew $" + withdrawAmount + " from account " + withdrawAccount + ".");
                    }
                    break;
                case "5":
                    bank.displayBalances();
                    break;
                case "6":
                    System.out.print("Enter account number to get detail: ");
                    String detailAccount = scanner.nextLine();
                    bank.getDetail(detailAccount);
                    break;
                case "7":
                    bank.listAccounts();
                    break;
                case "8":
                    System.out.print("Should the account be activated immediately? (yes/no): ");
                    String isActive = scanner.nextLine();
                    boolean active = isActive.equalsIgnoreCase("yes");
                    String newAccount = bank.createAccount(active);
                    if (newAccount != null) {
                        System.out.println("Account " + newAccount + (active ? " created and activated." : " created."));
                    }
                    break;
                case "9":
                    System.out.println("Exiting the application.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
