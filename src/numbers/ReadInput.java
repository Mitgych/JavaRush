package numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReadInput {
    static final String ERROR1 = "The first parameter should be a natural number or zero,\n";
    static final String ERROR2 = "The second parameter should be a natural number.\n";
    static final String ERROR3 = "The property [%s] is wrong.\n" +
            "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SUNNY, SQUARE, JUMPING]";
    static final String ERROR4 = "The properties [%s, %s] are wrong.\n" +
            "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SUNNY, SQUARE, JUMPING]";
    static final String ERROR5 = "The request contains mutually exclusive properties: [%s, %s]\n" +
            "There are no numbers with these properties.";


    public static List<String> input() {
        Scanner scanner  = new Scanner(System.in);
        List<String> result = new ArrayList<>(Arrays
                .stream(scanner.nextLine().toUpperCase().split("\\s+"))
                .collect(Collectors.toList()));

        if (result.isEmpty()) { //check empty input
            System.out.println(Main.INSTRUCTION);
            result = input();
        } else if (Long.parseLong(result.get(0)) < 0) { //check first number < 0
            System.out.println(ERROR1);
            System.out.print("\nEnter a request: ");
            result = input();
        } else if (result.size() > 1 && Long.parseLong(result.get(1)) <= 0) { //check second number < 0
            System.out.println(ERROR2);
            System.out.print("\nEnter a request: ");
            result = input();
        } else if (result.size() > 2 ) { //check properties
            List<String> notFoundProp;

            notFoundProp = result.subList(2, result.size()).stream()
                    .filter(e ->
                            Arrays.stream(PropertiesOfNumbers.values())
                            .noneMatch(i -> i.name().equals(e)))
                    .collect(Collectors.toList());

            //print error depending on number of wrong properties in notFoundProp. and check exclusive properties
            if (notFoundProp.size() == 1) {
                System.out.printf(ERROR3, notFoundProp.get(0));
                System.out.print("\nEnter a request: ");
                result = input();
            } else if (notFoundProp.size() == 2){
                System.out.printf(ERROR4, notFoundProp.get(0), notFoundProp.get(1));
                System.out.print("\nEnter a request: ");
                result = input();
            } else if (true) {
                List<PropertiesOfNumbers> properties = new ArrayList<>();

                for (String str: result.subList(2, result.size())) {
                    properties.add(PropertiesOfNumbers.valueOf(str));
                }

                for (PropertiesOfNumbers prop: properties) {
                    PropertiesOfNumbers prop2 = PropertiesOfNumbers.exclusiveProperty(prop);
                    if (prop != prop2 && properties.contains(prop2)) {
                        System.out.printf(ERROR5, prop, PropertiesOfNumbers.exclusiveProperty(prop));
                        System.out.print("\nEnter a request: ");
                        result = input();
                        break;
                    }
                }
            }
        }
        return result;
    }
}
