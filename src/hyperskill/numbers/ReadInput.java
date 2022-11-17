package hyperskill.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReadInput {
    static final String ERROR1 = "The first parameter should be a natural number or zero,\n";
    static final String ERROR2 = "The second parameter should be a natural number.\n";
    static final String ERROR3 = "The property [%s] is wrong.\n" +
            "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SUNNY, SQUARE, JUMPING, HAPPY, SAD]";
    static final String ERROR4 = "The properties [%s, %s] are wrong.\n" +
            "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SUNNY, SQUARE, JUMPING, HAPPY, SAD]";
    static final String ERROR5 = "The request contains mutually exclusive properties: [%s, %s]\n" +
            "There are no numbers with these properties.";

    /**
     * Returns List with inputs. And checks all possible input errors
     */
    public static List<String> input() {
        Scanner scanner  = new Scanner(System.in);
        List<String> result = Arrays
                .stream(scanner.nextLine().toUpperCase().split("\\s+")).collect(Collectors.toList());

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
        } else if (result.size() > 2 ) { //property validation
            List<String> notFoundProp;

            //add all properties, that not find in PropertiesOfNumbers.values()
            notFoundProp = result.subList(2, result.size()).stream()
                    .filter(e ->
                            Arrays.stream(PropertiesOfNumbers.values())
                            .noneMatch(i -> i.name().equals(e.replaceFirst("-", ""))))
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
            } else { //check exclusive includeProps
                List<PropertiesOfNumbers> includeProps = new ArrayList<>();
                List<PropertiesOfNumbers> excludeProps = new ArrayList<>();

                for (String str: result.subList(2, result.size())) {
                    if (str.charAt(0) == '-') {
                        excludeProps.add(PropertiesOfNumbers.valueOf(str.replaceFirst("-", "")));
                    } else {
                        includeProps.add(PropertiesOfNumbers.valueOf(str));
                    }
                }

                for (PropertiesOfNumbers prop: excludeProps) {
                    PropertiesOfNumbers prop2 = PropertiesOfNumbers.exclusionaryProperty(prop);
                    if (prop != prop2 && excludeProps.contains(prop2)) {
                        System.out.printf(ERROR5, prop, PropertiesOfNumbers.exclusionaryProperty(prop));
                        System.out.print("\nEnter a request: ");
                        result = input();
                        break;
                    }
                }

                for (PropertiesOfNumbers prop: excludeProps) {
                    for (PropertiesOfNumbers prop2: includeProps) {
                        if (prop == prop2) {
                            System.out.printf(ERROR5, "-" + prop, prop2);
                            System.out.print("\nEnter a request: ");
                            result = input();
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
}
