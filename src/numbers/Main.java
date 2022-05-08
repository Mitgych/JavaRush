package numbers;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static final String INSTRUCTION = "Supported requests:\n" +
            "- enter a natural number to know its properties;\n" +
            "- enter two natural numbers to obtain the properties of the list:\n" +
            "  * the first parameter represents a starting number;\n" +
            "  * the second parameters show how many consecutive numbers are to be processed;\n" +
            "- two natural numbers and two properties to search for;\n" +
            "- separate the parameters with one space;\n" +
            "- enter 0 to exit.\n";

    public static void main(String[] args) {
        long firstNumber;
        long secondNumber = 0;
        List<PropertiesOfNumbers> properties = new ArrayList<>();
        List<String> bufferInput;

        System.out.println("Welcome to Amazing Numbers!\n");
        System.out.println(INSTRUCTION);
        while (true) {
            System.out.print("Enter a request: ");
            bufferInput = ReadInput.input();
            System.out.println();

            if (bufferInput.get(0).equals("0")) { //Check exit
                break;
            }

            //initialize parameters and properties
            firstNumber = Long.parseLong(bufferInput.get(0));
            if (bufferInput.size() > 1) {
                secondNumber = Long.parseLong(bufferInput.get(1));
            }
            properties.clear();
            if (bufferInput.size() > 2) {
                for (String str: bufferInput.subList(2, bufferInput.size())) {
                    properties.add(PropertiesOfNumbers.valueOf(str));
                }
            }


            if (bufferInput.size() > 2) { //input two numbers and some properties
                int count = 0;
                while (count < secondNumber) {
                    Number num = new Number(firstNumber);
                    if (num.isProperties(properties)) {
                        num.printList();
                        count++;
                    }
                    firstNumber++;
                }
                System.out.println();
            } else if (bufferInput.size() == 2) { // input two numbers
                firstNumber = Long.parseLong(bufferInput.get(0));
                secondNumber = Long.parseLong(bufferInput.get(1));

                for (int i = 0; i < secondNumber; i++) {
                    Number num = new Number(firstNumber + i);
                    num.printList();
                }
            } else { //input one number
                firstNumber = Long.parseLong(bufferInput.get(0));

                Number numb = new Number(firstNumber);
                numb.print();
                System.out.println();
            }
        }
    }
}
