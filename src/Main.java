import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int number = 1234;
        ArrayList<Integer> arr = new ArrayList<>();
        long val = number;
        while (val != 0) {
            arr.add((int) val % 10);
            val /= 10;
        }
        int sum = arr.stream().mapToInt(Integer::intValue).sum();
        int multipl = arr.stream().reduce(1, (a, b) -> a * b);
        System.out.println(sum + " " + multipl);
    }

}