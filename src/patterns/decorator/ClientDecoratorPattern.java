package patterns.decorator;

public class ClientDecoratorPattern {

    public static void main(String... args) {

        Watch basicWatch = new BasicWatch();
        basicWatch.createFunctionality();
        System.out.println("\n---------");

        Watch sportWatch = new SportWatchDecorator(new BasicWatch());
        sportWatch.createFunctionality();
        System.out.println("\n---------");

        Watch luxuryWatch = new LuxuryWatchDecorator(new SportWatchDecorator(new BasicWatch()));
        luxuryWatch.createFunctionality();
    }
}
