package StreamsAndLambdas;

import java.net.Inet4Address;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Client {
    public static void main(String[] args) {
        MathematicalOperation x = new Addition();
        System.out.println(x.operate(2 , 5));

        MathematicalOperation multiply = (x1 , y1) -> {return x1 * y1;};
        System.out.println( multiply.operate(4 , 5));

        // Comparator has only one abstract method compare

        List<Student> students = new ArrayList<>();
        students.add(new Student("Mohit", 90.0));
        students.add(new Student("karthik", 85.0));
        students.add(new Student("Abhisehk" , 45.0));

        Collections.sort(students, new StudentPSPcomparator());

        Collections.sort(students, (obj1 , obj2) -> {
            if(obj1.psp < obj2.psp) return -1;
            else if (obj1.psp > obj2.psp) return 1;
            return 0;
        });

        List<Integer> a1 = new ArrayList<>();
        a1.add(1);
        a1.add(2);
        a1.add(4);
        a1.add(3);
        a1.add(6);
        a1.add(5);

        Stream s1 = a1.stream();

        // limit(x) : first x elements

        s1 = s1.limit(4);
        // terminal op count closes the stream
        System.out.println(s1.count());

        Long temp = a1.stream()
                .sorted()
                .limit(4)
                .count();

        List<Integer> y =
                a1.stream()
                .sorted((q ,r ) -> {
                    return r - q;
                })
                .limit(4)
                .collect(Collectors.toList());

        // FILTER : FILTER OUT ODD ELEMENTS AND JUST KEEP EVEN
        List<Integer>  l1 = a1.stream()
                .filter((elem) -> { return elem % 2 == 0;})
                . collect(Collectors.toList());

        // map : Intermedaite method

        List<Integer> l2 = a1.stream()
                .filter((elem) -> { return elem % 2 == 0;})
                .map((elem) -> { return elem * elem;})
                .collect(Collectors.toList());

        a1.stream()
                .filter((elem) -> {
                    System.out.println("Filter is working : " + elem);
                    return elem % 2 == 0;})
                .map((elem) -> {
                    System.out.println("Map is working " + elem);
                    return elem * elem;})
                        .collect(Collectors.toList());
        // one for loop for the filter
        // one for loop for the map

        // map takes every element of the data source
        // and it transforms it into another elem according to the function you have given
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(y);


        // Intermediate operations : return you the same stream
            // limit
            // filter

        // Terminal operations
        // As soon as you apply a terminal operation, stream closes
            // count
            // collect is a terminal method

            // Intermediate : Lazy
           // Terminal : Eager

        Optional<Integer> abc =  a1.stream()
                .filter((elem) -> {
                    System.out.println("Filter is working : " + elem);
                    return elem % 2 == 0;})
                .map((elem) -> {
                    System.out.println("Map is working " + elem);
                    return elem * elem;})
                .findFirst();

        if(abc.isPresent()){
            System.out.println(abc.get());
        }
        // find sum of the list

        int sum = 0;
        for(Integer t : a1){
            sum = sum + t;
        }

        Integer temp2 = a1.stream()
                .filter((elem) -> {
                    System.out.println("Filter is working : " + elem);
                    return elem % 2 == 0;})
                .map((elem) -> {
                    System.out.println("Map is working " + elem);
                    return elem * elem;})
                .reduce(0,(elem, sum1) -> {
                    return elem + sum1;
                });

        // find max elem of the list
//        .reduce(Int_min , (elem , max1) -> {
//            return max(elem, max1);
//        })
        System.out.println(temp2);



    }
}

// Functinal Interfaces
// Lambda expressions
// Streams  API
// Intermediate . terminal

//