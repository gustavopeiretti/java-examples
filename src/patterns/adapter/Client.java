package patterns.adapter;

public class Client {

    public static void main(String[] args) {

        UserAdapterImpl adapter = new UserAdapterImpl();
        adapter.getUser(1);

    }


}
