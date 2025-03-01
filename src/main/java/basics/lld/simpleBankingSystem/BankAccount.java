package basics.lld.simpleBankingSystem;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private final String accountNumber;
    private double balance;
    private final Lock lock = new ReentrantLock();

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        lock.lock();
        try {
            if (amount > 0 && balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawn $" + amount + " from " + accountNumber);
                return true;
            } else {
                System.out.println("Withdrawal failed! Insufficient funds.");
                return false;
            }
        } finally {
            lock.unlock();
        }
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited $" + amount + " into " + accountNumber);
            }
        } finally {
            lock.unlock();
        }
    }
}