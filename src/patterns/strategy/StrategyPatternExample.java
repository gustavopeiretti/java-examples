package patterns.strategy;

public class StrategyPatternExample {

    public static void main(String[] args) {

        CommissionStrategy commissionStrategy = getStrategy(1000d);
        Context context = new Context(commissionStrategy);
        System.out.println("Commission for 1000d = " + context.executeStrategy(1000d));

        commissionStrategy = getStrategy(500d);
        context = new Context(commissionStrategy);
        System.out.println("Commission for 500d = " + context.executeStrategy(500d));

        commissionStrategy = getStrategy(100d);
        context = new Context(commissionStrategy);
        System.out.println("Commission for 100d = " + context.executeStrategy(100d));
    }


    private static CommissionStrategy getStrategy(double amount) {
        CommissionStrategy strategy;
        if (amount >= 1000d) {
            strategy = new FullCommission();
        } else if (amount >= 500d && amount <= 999d) {
            strategy = new NormalCommission();
        } else {
            strategy = new RegularCommision();
        }
        return strategy;
    }
}
