package patterns.strategy;

public class Context {

    private CommissionStrategy commissionStrategy;

    public Context(CommissionStrategy commissionStrategy){
        this.commissionStrategy = commissionStrategy;
    }

    public double executeStrategy(double amount){
        return commissionStrategy.applyCommission(amount);
    }
}
