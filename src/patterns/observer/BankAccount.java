package patterns.observer;

import java.util.Observable;

public class BankAccount extends Observable {

    private double balance;

    public void addAmount(Double amount) {
        this.balance += amount;
        setChanged();
        notifyObservers(balance);
    }

    public Double getBalance() {
        return balance;
    }
}
