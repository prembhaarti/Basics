package basics.lld.simpleBankingSystem;

public class ScheduledTransaction {
    private final String fromAccount;
    private final String toAccount;
    private final double amount;

    public ScheduledTransaction(String fromAccount, String toAccount, double amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public double getAmount() {
        return amount;
    }
}
