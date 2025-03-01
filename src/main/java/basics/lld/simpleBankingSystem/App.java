package basics.lld.simpleBankingSystem;

public class App {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Creating accounts
        BankAccount acc1 = new BankAccount("123", 500);
        BankAccount acc2 = new BankAccount("456", 300);

        bank.addAccount(acc1);
        bank.addAccount(acc2);

        // Performing a withdrawal
        acc1.withdraw(100);

        // Performing a transfer
        bank.transfer("123", "456", 200);

        // Scheduling a future transaction
        TransactionScheduler scheduler = new TransactionScheduler(bank);
        ScheduledTransaction scheduledTransaction = new ScheduledTransaction("456", "123", 150);
        scheduler.scheduleTransfer(scheduledTransaction, 5);

        // Waiting to allow scheduled transaction execution
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Printing final balances
        System.out.println("Final Balance of 123: $" + acc1.getBalance());
        System.out.println("Final Balance of 456: $" + acc2.getBalance());

        scheduler.shutdown();
    }
}
