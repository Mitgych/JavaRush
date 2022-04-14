package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Welcome to Amazing Numbers!\n\n" + 
                "Supported requests:\n" + 
                "- enter a natural number to know its properties;\n" + 
                "- enter 0 to exit.\n\n");
        long readNumber = -1;
        while (true) {
            System.out.print("\nEnter a request: ");
            readNumber = scanner.nextLong();
            System.out.println("\n");
            if (readNumber == 0) {
                break;
            }
            if (readNumber >= 0) {
                Number number = new Number(readNumber);
                number.print();
            } else {
                System.out.println("The first parameter should be a natural number or zero.");
            }
        }
        scanner.close();
    }


}
