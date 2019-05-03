package patterns.adapter;

public class UserAdapterImpl implements UserAdapter {

    private BankService service = new BankService();

    @Override
    public User getUser(int accountNumber) {
        BankData bankData = service.findByAccountNumber(accountNumber);
        User user = new User(bankData.getAccount(), bankData.getName(), bankData.getBalance());
        return user;
    }
}
