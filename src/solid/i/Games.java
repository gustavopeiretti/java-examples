package solid.i;

class Games implements IProduct, IRestrictedProduct {

    private int age;

    @Override
    public String getType() {
        return "game";
    }

    @Override
    public int getAge() {
        return age;
    }

    // get and set..

}
