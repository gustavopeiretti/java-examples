package patterns.facade;

public class ClientFacadePatternExample {

    public static void main(String[] args) {

        System.out.println("--------------- ON ---------------");
        MobileFacade facade = new MobileFacade();
        Mobile mobile = facade.on();
        System.out.println();
        System.out.println("--------------- OFF ---------------");
        facade.off(mobile);
    }
}
