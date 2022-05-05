package numbers;

import java.util.List;

public class Main {
    static final String INSTRUCTION = "Supported requests:\n" +
            "- enter a natural number to know its properties;\n" +
            "- enter two natural numbers to obtain the properties of the list:\n" +
            "  * the first parameter represents a starting number;\n" +
            "  * the second parameter shows how many consecutive numbers are to be processed;\n" +
            "- two natural numbers and a property to search for;\n" +
            "- separate the parameters with one space;\n" +
            "- enter 0 to exit.\n";

    public static void main(String[] args) {
        long firstNumber;
        long secondNumber;
        String property;
        List<String> buffer;

        System.out.println("Welcome to Amazing Numbers!\n");
        System.out.println(INSTRUCTION);
        while (true) {
            System.out.print("Enter a request: ");
            buffer = ReadInput.input();
            System.out.println();

            if (buffer.get(0).equals("0")) { //Check exit
                break;
            }

            if (buffer.size() == 3) { //input two numbers and property
                firstNumber = Long.parseLong(buffer.get(0));
                secondNumber = Long.parseLong(buffer.get(1));
                property = buffer.get(2).toUpperCase();
                int count = 0;
                while (count < secondNumber) {
                    Number num = new Number(firstNumber);
                    if (num.isProperty(property)) {
                        num.printList();
                        count++;
                    }
                    firstNumber++;
                }
            } else if (buffer.size() == 2) { // input two numbers
                firstNumber = Long.parseLong(buffer.get(0));
                secondNumber = Long.parseLong(buffer.get(1));
                for (int i = 0; i < secondNumber; i++) {
                    Number num = new Number(firstNumber + i);
                    num.printList();
                }
            } else if (buffer.size() == 1) { //input one number
                firstNumber = Long.parseLong(buffer.get(0));
                Number numb = new Number(firstNumber);
                numb.print();
            }
        }
    }
}
