import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

//        List <Integer> numbers2 = numbers.stream()
//                                            .filter(n -> n > 2)
//                                             .collect(Collectors.toList());
//
//
//
//        List <Integer> numbers2 = numbers.stream()
//                                            .map(n -> n * 2)
//                                                    .collect(Collectors.toList());
//
//
//        Set<Integer> numbers2 = numbers.stream()
//                                        .collect(Collectors.toSet());
//
//
//        int sum = numbers.stream()
//                          .reduce(0, (a, b) -> a + b);
//
//        int multi = numbers.stream()
//                              .reduce(1, (a, b) -> a * b);
//
//        int minus = numbers.stream()
//                            .reduce(100, (a, b) -> a - b);
//        System.out.println(multi);
//
//
//        List<List<Integer>> nestedLists = Arrays.asList(
//                Arrays.asList(1, 2, 3),
//                Arrays.asList(4, 5, 6),
//                Arrays.asList(7, 8, 9)
//        );
//
//        List<Integer> numbers2 = nestedLists.stream()
//                .flatMap(List :: stream)
//                .collect(Collectors.toList());
//
//        numbers2.forEach(System.out::println);

        List<String> names = new ArrayList<String>();
        names.add("John");
        names.add("Jane");
        names.add("Bob");
        names.add("Mary");
        names.add("Sam");

        int sum = names.stream()
                        .filter(n -> n.length() > 3)
////                       .sorted(Comparator.reverseOrder())
                .map(n -> 1)
                    .reduce(0, (a, b) -> a + b);
////                   .collect(Collectors.toList());


        System.out.println(sum);
//        newList.forEach(System.out::println);


//
//        List<String> list = new ArrayList<String>();
//        list.add("One");
//        list.add("Two");
//        list.add("Three");
//        list.add("Four");
//        list.add("Five");
//        list.add("Six");
//        list.add("Seven");
//        list.add("Eight");
//        list.add("Nine");
//        list.add("Ten");
//
//        Stream stream = list.stream();
//        stream.filter(x-> x.toString().length() == 3).forEach(System.out::println);


//        IntStream.of(50, 60, 70, 80, 90, 100, 110, 120).filter(x -> x < 90).map(x -> x + 10)
//                .limit(3).forEach(System.out::print);

    }
}