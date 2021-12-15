package Section14;


import com.google.common.collect.Streams;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;
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


    //@Test
    public void StreamMap() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("April");
        names.add("Donna");
        names.add("Ernie");

        //print names which have last letter as y and print them in uppercase
        Stream.of("Abernathy", "Donny", "Eugenyi", "John", "Anne").filter(s -> s.endsWith("y")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        //print names which have first letter as a with uppercase and sorted
        List<String> names1 = Arrays.asList("Andy", "Dory", "Edward", "Abernathy", "Harry");
        names1.stream().filter(s -> s.startsWith("A", 0)).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        //Merging 2 Lists into a Stream
        Stream<String> concStreams = Streams.concat(names.stream(), names1.stream());
        //concStreams.sorted().forEach(s -> System.out.println(s)); // commented because if stream is modified it closes and cannot be used again

        //Checking if name, element is present in list using stream
        boolean flag = concStreams.anyMatch(s -> s.equalsIgnoreCase("Dory"));
        Assert.assertTrue(flag);

    }

    //@Test
    public void streamCollect() {

        //Collecting data from stream into a list
        List<String> names = Arrays.asList("Andy", "Dory", "Edward", "Abernathy", "Harry");
        List<String> names1 = Arrays.asList("April", "Donna", "Ernie");
        List<String> concList = Streams.concat(names.stream(), names1.stream()).collect(Collectors.toList());
        System.out.println(concList);

        //Collecting data from stream into a set
        Set<String> namesSet = Streams.concat(names.stream(), names1.stream()).collect(Collectors.toSet());
        System.out.println(namesSet);

        //Collecting data from stream into a map
        Map<String, String> nameMap = Streams.concat(names.stream(), names1.stream()).collect(Collectors.toMap(s -> s, s -> s));
        System.out.println(nameMap);

        //Collecting data from stream into a map with key as length of name and value as name
        Map<Integer, String> nameMap1 = Streams.concat(names.stream(), names1.stream()).collect(Collectors.toMap(s -> s.length(), s -> s));
        System.out.println(nameMap1);

        //Collecting data from stream into a map with key as length of name and value as name
        Map<Integer, String> nameMap2 = Streams.concat(names.stream(), names1.stream()).collect(Collectors.toMap(s -> s.length(), s -> s, (s1, s2) -> s1 + " " + s2));
        System.out.println(nameMap2);

        //Collecting data from stream into a map with key as length of name and value as name
        Map<Integer, String> nameMap3 = Streams.concat(names.stream(), names1.stream()).collect(Collectors.toMap(s -> s.length(), s -> s, (s1, s2) -> s1 + " " + s2, TreeMap::new));
        System.out.println(nameMap3);

    }

    @Test
    public void MyStreamCollect() {
        List<String> ls = Stream.of("Abernathy, Adam, Emilia, John, Anna").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(ls.get(0));

        //
        List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
        //print unique members of list
        //sort the array - 3rd index
        //values.stream().distinct().limit(1).forEach(s -> System.out.println(s));
        List<Integer> uniqueValues = values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(uniqueValues.get(2));

    }

}




