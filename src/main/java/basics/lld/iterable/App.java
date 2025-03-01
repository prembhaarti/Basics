package basics.lld.iterable;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
            ListIterable<String> listIterable = new ListIterable<>(Arrays.asList("A", "B", "C", "D"));
            for (String item : listIterable) {
                System.out.println(item);
            }

        System.out.println("-------------");

        IntervalIterable interval = new IntervalIterable(5, 10);
        for (int num : interval) {
            System.out.print(num + " ");
        }

        System.out.println("-------------");

        OddNumberIterable oddNumbers = new OddNumberIterable(3, 15);
        for (int num : oddNumbers) {
            System.out.print(num + " ");
        }
    }

}
