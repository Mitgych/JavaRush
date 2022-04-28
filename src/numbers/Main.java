package numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static final String ERROR1 = "The first parameter should be a natural number or zero,\n";
    static final String ERROR2 = "The second parameter should be a natural number.\n";

    static final String INSTRUCTION = """
            Supported requests:
            - enter a natural number to know its properties;
            - enter two natural numbers to obtain the properties of the list:
              * the first parameter represents a starting number;
              * the second parameter shows how many consecutive numbers are to be processed;
            - separate the parameters with one space;
            - enter 0 to exit.
            """;

    public static void main(String[] args) {
        long readNumber;
        int count = 0;
        long[] buffer;

        System.out.println("Welcome to Amazing Numbers!\n");
        System.out.println(INSTRUCTION);
        while (true) {
            System.out.print("Enter a request: ");
            buffer = ReadInput.inputNumb();
            System.out.println();
            if (buffer[0] == 0) { //Check exit
                break;
            }
            if (buffer[0] > 0 && buffer[1] > 0) { // input two numbers
                for (int i = 0; i < buffer[1]; i++) {
                    Number number = new Number(buffer[0] + i);
                    number.printList();
                }
            } else if (buffer[0] > 0 && buffer[1] == -1) { //input one number
                Number number = new Number(buffer[0]);
                number.print();
            }
        }
    }
}
