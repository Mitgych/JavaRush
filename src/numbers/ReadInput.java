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
    static final String ERROR4 = "The property [%s, %s] are wrong.\n" +
            "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SUNNY, SQUARE]";
    static final String[] properties = {"EVEN", "ODD", "BUZZ", "DUCK", "PALINDROMIC",
            "GAPFUL", "SPY", "SUNNY", "SQUARE"};

    public static List<String> input() {
        Scanner scanner  = new Scanner(System.in);
        List<String> result = new ArrayList<>(Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList()));

        if (result.isEmpty()) { //check empty input
            System.out.println(Main.INSTRUCTION);
            result = input();
        } else if (result.size() > 0 && Long.parseLong(result.get(0)) < 0) { //check first number < 0
            System.out.println(ERROR1);
            System.out.print("\nEnter a request: ");
            result = input();
        } else if (result.size() > 1 && Long.parseLong(result.get(1)) < 0) {
            System.out.println(ERROR2);
            System.out.print("\nEnter a request: ");
            result = input();
        } else if (result.size() > 2 && Arrays.stream(properties).noneMatch(result.get(2).toUpperCase()::equals)) {
            System.out.printf(ERROR3, result.get(2));
            System.out.print("\nEnter a request: ");
            result = input();
        } else if (result.size() > 3 && Arrays.stream(properties).noneMatch(result.get(3).toUpperCase()::equals)) {
            System.out.printf(ERROR4, result.get(2), result.get(3));
            System.out.print("\nEnter a request: ");
            result = input();
        }
        return result;
    }
}
