package hyperskill.numbers;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static final String INSTRUCTION = "Supported requests:\n" +
            "- enter a natural number to know its properties;\n" +
            "- enter two natural hyperskill.numbers to obtain the properties of the list:\n" +
            "  * the first parameter represents a starting number;\n" +
            "  * the second parameter shows how many consecutive hyperskill.numbers are to be printed;\n" +
            "- two natural hyperskill.numbers and properties to search for;\n" +
            "- a property preceded by minus must not be present in hyperskill.numbers;\n" +
            "- separate the parameters with one space;\n" +
            "- enter 0 to exit.\n";

    public static void main(String[] args) {
        long firstNumber;
        long secondNumber = 0;
        List<PropertiesOfNumbers> includeProps = new ArrayList<>();
        List<PropertiesOfNumbers> excludeProps = new ArrayList<>();
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

            //initialize parameters and includeProps
            firstNumber = Long.parseLong(bufferInput.get(0));
            if (bufferInput.size() > 1) {
                secondNumber = Long.parseLong(bufferInput.get(1));
            }
            includeProps.clear();
            excludeProps.clear();
            if (bufferInput.size() > 2) {
                for (String str: bufferInput.subList(2, bufferInput.size())) {
                    if (str.charAt(0) == '-') {
                        excludeProps.add(PropertiesOfNumbers.valueOf(str.replaceFirst("-", "")));
                    } else {
                        includeProps.add(PropertiesOfNumbers.valueOf(str));
                    }
                }
            }


            if (bufferInput.size() > 2) { //input two hyperskill.numbers and some includeProps
                int count = 0;
                while (count < secondNumber) {
                    Number num = new Number(firstNumber);
                    if (num.isProperties(includeProps, excludeProps)) {
                        num.printList();
                        count++;
                    }
                    firstNumber++;
                }
                System.out.println();
            } else if (bufferInput.size() == 2) { // input two hyperskill.numbers
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
