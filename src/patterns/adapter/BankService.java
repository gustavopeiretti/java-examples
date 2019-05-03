package patterns.adapter;

public class BankService {

    public BankData findByAccountNumber(int accountNumber) {
        if (accountNumber == 1) {
            return new BankData(accountNumber,"Nick", 100d);
        } else if (accountNumber == 3) {
            return new BankData(accountNumber,"Susan", 200d);
        } else {
            return null;
        }
    }
}
