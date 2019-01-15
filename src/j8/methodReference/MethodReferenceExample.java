package j8.methodReference;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.*;
import java.util.function.Supplier;

/**
 * Created by gustavo.peiretti on 17/4/2017.
 */
public class MethodReferenceExample {

    // The method transferElements copies elements from one collection to
    // another


    public static void main(String... args) {

        List<Person> personList = gerPersonList();

        // Without lambda expression
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person a, Person b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        });

        // With lambda expression
        Collections.sort(personList,
                (Person a, Person b) -> {
                    return a.getBirthday().compareTo(b.getBirthday());
                }
        );

        // 1-With method reference
        Collections.sort(personList, Person::compareByAge);
        // --

        // 2-Reference to a static method
        personList.forEach(System.out::println);
        // --


        // 3-Reference to an instance method of a particular object
        class ComparisonProvider {
            public int compareByName(Person a, Person b) {
                return a.getName().compareTo(b.getName());
            }

            public int compareByAge(Person a, Person b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        }
        ComparisonProvider myComparisonProvider = new ComparisonProvider();

        personList.sort(myComparisonProvider::compareByAge);
        // --


        // 4-Reference to an instance method of an arbitrary object of a particular type
        Collections.sort(personList, Person::compareByAge);
        // --

        // 5-Reference to a constructor

        // Using a lambda expression
        Supplier<Person> personSupplier2 = () -> new Person();
        Person personFromSupplier2 = personSupplier2.get();

        // Using a method reference
        Supplier<Person> p = Person::new;
        Person onePerson = p.get();


    }

    public static List<Person> gerPersonList() {
        List<Person> personList = new ArrayList<>();
        personList.add(
                new Person(
                        "Fred",
                        IsoChronology.INSTANCE.date(1980, 6, 20),
                        Person.Sex.MALE,
                        "fred@example.com"));
        personList.add(
                new Person(
                        "Jane",
                        IsoChronology.INSTANCE.date(1990, 7, 15),
                        Person.Sex.FEMALE, "jane@example.com"));
        personList.add(
                new Person(
                        "George",
                        IsoChronology.INSTANCE.date(1991, 8, 13),
                        Person.Sex.MALE, "george@example.com"));
        personList.add(
                new Person(
                        "Bob",
                        IsoChronology.INSTANCE.date(2000, 9, 12),
                        Person.Sex.MALE, "bob@example.com"));

        return personList;
    }

}
