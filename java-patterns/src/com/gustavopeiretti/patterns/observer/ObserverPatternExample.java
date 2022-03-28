package patterns.observer;

public class ObserverPatternExample {
    public static void main(String[] args) {

        // Observable class
        BankAccount bankAccount = new BankAccount();

        // Observer class
        BankExpense bankExpense1 = new BankExpense("commission", 0.11d);
        BankExpense bankExpense2 = new BankExpense("expense", 0.22d);
        BankExpense bankExpense3 = new BankExpense("compensation", 0.33d);

        // Add Observer into Observable
        bankAccount.addObserver(bankExpense1);
        bankAccount.addObserver(bankExpense2);
        bankAccount.addObserver(bankExpense3);

        // Change Observable state
        bankAccount.addAmount(1000d);

        // Observer was notified
        System.out.println(bankExpense1.toString());
        System.out.println(bankExpense2.toString());
        System.out.println(bankExpense3.toString());
    }
}
