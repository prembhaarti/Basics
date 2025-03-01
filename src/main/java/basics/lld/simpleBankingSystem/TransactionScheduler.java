package basics.lld.simpleBankingSystem;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TransactionScheduler {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final Bank bank;

    public TransactionScheduler(Bank bank) {
        this.bank = bank;
    }

    public void scheduleTransfer(ScheduledTransaction transaction, long delaySeconds) {
        scheduler.schedule(() -> {
            System.out.println("Executing scheduled transfer...");
            bank.transfer(transaction.getFromAccount(), transaction.getToAccount(), transaction.getAmount());
        }, delaySeconds, TimeUnit.SECONDS);
    }

    public void shutdown() {
        scheduler.shutdown();
    }
}