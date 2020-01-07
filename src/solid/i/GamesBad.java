package solid.i;

class GamesBad implements IProductBad {

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
