import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4);


        // want to reduce by adding all elements
        // reduce(binaryOperator)
        Optional<Integer> reduce1 = list.stream().reduce((a, b) -> a + b);
        System.out.println(reduce1);
        System.out.println("----------------------------------------------");


        // want to have a default value to be applied on the result
        // reduce(identity, binaryOperator)
        Integer reduce2 = list.stream().reduce(10,(a, b) -> a + b);
        System.out.println(reduce2);
        System.out.println("----------------------------------------------");


        // reduce(identity, function, binaryOperator)
        // this works only on the parallel stream
        Integer reduce3 = list.parallelStream().reduce(10, (a, b) -> a + b, (a, b) -> {
            System.out.println("hello");
            return a+b;
        });
        System.out.println(reduce3);

    }
}