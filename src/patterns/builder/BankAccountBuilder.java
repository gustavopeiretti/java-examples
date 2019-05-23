package patterns.builder;

public class BankAccountBuilder implements IBuilder {

    private long accountNumber; //This is important, so we'll pass it to the constructor.
    private String owner;
    private BankAccountType type;
    private double balance;
    private double interestRate;

    public BankAccountBuilder(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BankAccountBuilder withOwner(String owner){
        this.owner = owner;
        return this;  //By returning the builder each time, we can create a fluent interface.
    }

    public BankAccountBuilder withType(BankAccountType type){
        this.type = type;
        return this;
    }

    public BankAccountBuilder withBalance(double balance){
        this.balance = balance;
        return this;
    }

    public BankAccountBuilder withRate(double interestRate){
        this.interestRate = interestRate;
        return this;
    }

    @Override
    public BankAccount build(){
        BankAccount account = new BankAccount();
        account.setAccountNumber(this.accountNumber);
        account.setOwner(this.owner);
        account.setType(this.type);
        account.setBalance(this.balance);
        account.setInterestRate(this.interestRate);
        return account;
    }
}
