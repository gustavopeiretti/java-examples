package patterns.adapter;

public class BankData {

    private int account;
    private String name;
    private double balance;

    public BankData(int account, String name, double balance) {
        this.account = account;
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getAccount() {
        return account;
    }

    public double getBalance() {
        return balance;
    }
}
