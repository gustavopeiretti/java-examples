package solid.d;

class MySqlDatabaseBad {

    void save(Product product, PaymentType paymentType) {
        System.out.println("Save product " + product + " paymentType " + paymentType);
        // save into MySqlDatabase...
    }

}
