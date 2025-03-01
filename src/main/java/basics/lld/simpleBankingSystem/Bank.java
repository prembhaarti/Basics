package basics.lld.simpleBankingSystem;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final Map<String, BankAccount> accounts = new HashMap<>();

    public void addAccount(BankAccount account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public BankAccount getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public boolean transfer(String fromAccount, String toAccount, double amount) {
        BankAccount sender = accounts.get(fromAccount);
        BankAccount receiver = accounts.get(toAccount);

        if (validateSenderAndReceiver(sender, receiver)) return false;

        synchronized (this) { // Lock the transfer operation
            if (sender.withdraw(amount)) {
                receiver.deposit(amount);
                System.out.println("Transferred $" + amount + " from " + fromAccount + " to " + toAccount);
                return true;
            }
        }
        return false;
    }

    private static boolean validateSenderAndReceiver(BankAccount sender, BankAccount receiver) {
        if (sender == null || receiver == null) {
            System.out.println("Transfer failed! Invalid accounts.");
            return true;
        }
        return false;
    }
}