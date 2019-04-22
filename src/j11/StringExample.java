package j11;

import java.util.stream.Collectors;

public class StringExample {

    public static void main(String[] args) {

        //isBlank() example
        System.out.println(" ".isBlank());
        String s = "Hi Word!";
        System.out.println(s.isBlank());
        String s1 = "";
        System.out.println(s1.isBlank());
        System.out.println();

        // lines() example
        String str = "Hi\nWord\nHi\nUniverse";
        System.out.println(str);
        System.out.println(str.lines().collect(Collectors.toList()));
        System.out.println();

        // strip() example
        String hello = " HELLO ";
        System.out.println("SAY" + hello.strip() + "PLEASE");
        System.out.println("SAY" + hello.stripLeading() + "PLEASE");
        System.out.println("SAY" + hello.stripTrailing() + "PLEASE");
        System.out.println();

        Character c = '\u2000';
        String stringWithUnicode = c + "abc" + c;
        System.out.println("Contain unicode " + Character.isWhitespace(c));
        System.out.println("Trim test " + (stringWithUnicode == stringWithUnicode.trim()) );
        System.out.println("Strip test " + ("abc"== stringWithUnicode.strip()));
        System.out.println();

        // repeat() example
        String rep = "HI".repeat(2);
        System.out.println(rep);
        System.out.println();
    }
}
