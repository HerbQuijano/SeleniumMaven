package Section14;


import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamsExample {
    // @Test
    public void Regular() {
        //  count number of names starting with alphabet A in list

        ArrayList<String> names = new ArrayList<String>();
        names.add("Andrew");
        names.add("Dorian");
        names.add("Edward");
        names.add("Abernathy");
        names.add("Harry");
        int count = 0;

        for (int i = 0; i < names.size(); i++) {
            String actual = names.get(i);
            if (actual.startsWith("A")) {
                count++;
            }
        }

        System.out.println(count);

    }

    //@Test
    public void StreamFilter() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Andy");
        names.add("Dory");
        names.add("Edward");
        names.add("Abernathy");
        names.add("Harry");

        //1 Create Stream stream() - 2 Perform intermediate operation (filter) - 3 Perform terminal operation on the final stream to get result count()
        //s is stream, left side of lambda is variable and right side is the operation

        //No life for intermediate operation if there is no terminal operation
        //terminal operation will execute only if intermediate operation (filter) returns true
        //We can create Stream
        Long c = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(c);

        System.out.println("print all names of ArrayList of more than 4 letters in size");
        names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));

        System.out.println("print all names of ArrayList, limited to show only 2");
        names.stream().filter(s -> s.length() > 4).limit(2).forEach(s -> System.out.println(s));

        System.out.println("print all names of ArrayList that ends with 'y'");
        names.stream().filter(s -> s.endsWith("y")).forEach(s -> System.out.println(s));


        //Example of why if terminal operation is false, the result is 0
        //        Long d = Stream.of("Abernathy", "Donny", "Eugenyi", "John", "Anne").filter(s ->
        //                {
        //                    s.startsWith("A");
        //                    return false;
        //                }
        //        ).count();
        //System.out.println(d);
        //    }

    }


@Test
public void StreamMap()
{
    //print names which have last letter as y and print them in uppercase
    Stream.of("Abernathy", "Donny", "Eugenyi", "John", "Anne").filter(s -> s.endsWith("y")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

    //print names which have first letter as a with uppercase and sorted
    Stream.of("Abernathy", "Donny", "Eugenyi", "John", "Anne", "Aaron", "Anabelle").filter(s -> s.startsWith("A", 0)).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

}

}




