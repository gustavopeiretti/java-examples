package patterns.decorator;

public abstract class WatchDecorator implements Watch {

    private final Watch watch;

    public WatchDecorator(Watch watch) {
        this.watch = watch;
    }
    @Override
    public void createFunctionality() {
        this.watch.createFunctionality();
    }
}
