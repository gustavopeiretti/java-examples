package patterns.composite;

public class ClientComposite {

    public static void main(String... args) {

        Employee m1 = new Manager("Marc");

        Employee d1 = new Developer("Maria");
        Employee d2 = new Developer("Ema");
        Employee d3 = new Developer("Brian");

        m1.add(d1);
        m1.add(d2);
        m1.add(d3);

        Employee m2 = new Manager("Susan");

        Employee d4 = new Developer("James");
        Employee d5 = new Developer("Michael");

        m2.add(d4);
        m2.add(d5);

        System.out.println(m1.calculatePoints());
        System.out.println(m2.calculatePoints());

    }
}
