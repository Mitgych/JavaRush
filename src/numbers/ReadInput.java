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
            "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SUNNY, SQUARE]";
    static final String ERROR4 = "The properties [%s, %s] are wrong.\n" +
            "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SUNNY, SQUARE]";
    static final String ERROR5 = "The request contains mutually exclusive properties: [%s, %s]\n" +
            "There are no numbers with these properties.";
    static final String[] PROPERTIES = {"EVEN", "ODD", "BUZZ", "DUCK", "PALINDROMIC",
            "GAPFUL", "SPY", "SUNNY", "SQUARE"};
    static final String[][] EXCLUSIVE_PROPERTIES = {
            {"EVEN", "ODD"}, {"ODD", "EVEN"},
            {"DUCK", "SPY"}, {"SPY", "DUCK"},
            {"SUNNY", "SQUARE"}, {"SQUARE", "SUNNY"}
    };

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
            List<String> buff = new ArrayList<>();
            final String[] properties2 = result.subList(2, result.size()).toArray(new String[2]);

            //write in buff wrong properties
            for (String str: result.subList(2, result.size())) {
                if (Arrays.stream(PROPERTIES).noneMatch(str::equals)){
                    buff.add(str);
                }
            }

            //print error depending on number of wrong properties in buff. and check exclusive properties
            if (buff.size() == 1) {
                System.out.printf(ERROR3, buff.get(0));
                System.out.print("\nEnter a request: ");
                result = input();
            } else if (buff.size() == 2){
                System.out.printf(ERROR4, buff.get(0), buff.get(1));
                System.out.print("\nEnter a request: ");
                result = input();
            } else if (Arrays.stream(EXCLUSIVE_PROPERTIES).anyMatch(e -> Arrays.equals(e, properties2))) {
                System.out.printf(ERROR5, result.get(2), result.get(3));
                System.out.print("\nEnter a request: ");
                result = input();
            }
        }
        return result;
    }
}
