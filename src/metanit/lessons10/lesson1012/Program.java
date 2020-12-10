package metanit.lessons10.lesson1012;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Program {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        numbers.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        Optional<Integer> min = numbers.stream().min(Integer::compare);
        System.out.println(min);


        numbers.stream().min(Integer::compare);
        min.ifPresent(v -> System.out.println(v)); // 4
    }
}
