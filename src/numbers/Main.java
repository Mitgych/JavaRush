package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number > 0) {
            if (number % 10 == 7) {
                if (number % 7 == 0) {
                    System.out.println(number + " is divisible by 7 and ends with 7");
                } else {
                    System.out.println(number + " ends with 7");
                }
            } else {
                if (number % 7 == 0) {
                    System.out.println(number + " is divisible by 7");
                } else {
                    System.out.println(number + " is neither divisible by 7 nor does it end with 7");
                }
            }
        } else {
            System.out.println("This number is not natural!");
        }
    }
}
