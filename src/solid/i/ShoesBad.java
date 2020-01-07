package solid.i;

class ShoesBad implements IProductBad {

    @Override
    public String getType() {
        return "shoes";
    }

    @Override
    public int getAge() {
        throw new UnsupportedOperationException();
    }

}
