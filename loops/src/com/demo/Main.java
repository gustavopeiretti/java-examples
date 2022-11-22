package com.demo;

import java.util.*;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        forLoop();
        enhancedLoop();
        whileLoop();
        doWhileLoop();
        forEachFunctionalLoop();
        iteratorLoop();
        listIteratorLoop();
        forEachStream();
    }

    public static void forLoop() {
        System.out.println("forLoop");
        List<Integer> values = Arrays.asList(1,2,3,4,5,6);
        for (int i = 0; i < values.size(); i++) {
            System.out.println(values.get(i));
        }
    }

    public static void enhancedLoop() {
        System.out.println("enhancedLoop");
        List<Integer> values = Arrays.asList(1,2,3,4,5,6);
        for (Integer e : values) {
            System.out.println(e);
        }
    }

    public static void whileLoop() {
        System.out.println("whileLoop");
        List<Integer> values = Arrays.asList(1,2,3,4,5,6);
        int i = 0;
        while (i < values.size()) {
            System.out.println(values.get(i));
            i++;
        }
    }

    public static void doWhileLoop() {
        System.out.println("doWhileLoop");
        List<Integer> values = Arrays.asList(1,2,3,4,5,6);
        int i = 0;
        do {
            System.out.println(values.get(i));
            i++;
        } while (i < values.size());
    }

    public static void forEachFunctionalLoop() {
        System.out.println("forEachFunctionalLoop");
        List<Integer> values = Arrays.asList(1,2,3,4,5,6);

        // using anonymous class
        values.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer x) {
                System.out.println(x);
            }
        });

        // using lambda
        values.forEach(x -> System.out.println(x));

        // using method reference :)
        values.forEach(System.out::println);
    }


    public static void iteratorLoop() {
        System.out.println("iteratorLoop");
        List<Integer> values = Arrays.asList(1,2,3,4,5,6);

        for (Iterator<Integer> iter = values.iterator(); iter.hasNext(); ) {
            Integer element = iter.next();
            System.out.println(element);
        }

        Iterator<Integer> iter = values.iterator();
        while (iter.hasNext()) {
            Integer next = iter.next();
            System.out.println(next);
        }

    }

    public static void listIteratorLoop() {
        System.out.println("listIteratorLoop");
        List<Integer> values = Arrays.asList(1,2,3,4,5,6);
        ListIterator<Integer> valuesListIterator = values.listIterator();

        // forward
        while (valuesListIterator.hasNext()) {
            Integer next = valuesListIterator.next();
            System.out.println(next);
        }

        // backward / reverse
        while (valuesListIterator.hasPrevious()) {
            System.out.println(valuesListIterator.previous());
        }
    }




    public static void forEachStream() {
        System.out.println("forEachStream");
        List<Integer> values = Arrays.asList(1,2,3,4,5,6);

        // the main idea for streams is to apply some function to the data
        // for example 'filter'
        values.stream().filter(e -> e > 0).forEach(System.out::println);
    }

}
