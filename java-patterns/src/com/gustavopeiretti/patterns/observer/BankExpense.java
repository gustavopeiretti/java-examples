package patterns.observer;

import java.util.Observable;
import java.util.Observer;

public class BankExpense implements Observer {

    private String type;
    private Double totalCalculated = new Double(0D);
    private final Double rateCoefficient;

    public BankExpense(String type, Double rateCoefficient) {
        this.type = type;
        this.rateCoefficient = rateCoefficient;
    }

    @Override
    public void update(Observable o, Object value) {
        this.totalCalculated = ((Double) value) * rateCoefficient;
    }

    public Double getTotalCalculated() {
        return totalCalculated;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "BankExpense{" +
                "type='" + type + '\'' +
                ", rateCoefficient=" + rateCoefficient +
                ", totalCalculated=" + totalCalculated +
                '}';
    }
}
