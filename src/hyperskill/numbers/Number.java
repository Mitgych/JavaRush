package hyperskill.numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Number {
    private final List<PropertiesOfNumbers> properties = new ArrayList<>();
    private final long value;


    public Number(long number) {
        this.value = number;

        //This determines the parity of the number
        if (number % 2 == 0) {
            properties.add(PropertiesOfNumbers.EVEN);
        } else {
            properties.add(PropertiesOfNumbers.ODD);
        }

        //The buzz number are determines here
        if (number % 7 == 0 || number % 10 == 7) {
            properties.add(PropertiesOfNumbers.BUZZ);
        }

        //The duck number are determines here
        String numberAsString = Long.toString(number);
        if (numberAsString.charAt(0) == '0') {
            numberAsString = numberAsString.substring(1);
        }
        if (numberAsString.contains("0")) {
            properties.add(PropertiesOfNumbers.DUCK);
        }

        //The palindromic number are determines here
        var str1 = Long.toString(number);
        var str = new StringBuilder(str1);
        if (str.reverse().toString().equals(str1)) {
            properties.add(PropertiesOfNumbers.PALINDROMIC);
        }

        //The gapful number are determines here
        if (Math.abs(number) > 99) {
            long lastDigit = number % 10;
            //find last digit
            int degree = (int) Math.log10(number);
            long firstDigit = number / (long) (Math.pow(10, degree));
            long number2 = firstDigit * 10 + lastDigit;
            if (number % number2 == 0) {
                properties.add(PropertiesOfNumbers.GAPFUL);
            }
        }

        //The spy hyperskill.numbers are determines here
        ArrayList<Integer> arr = new ArrayList<>();
        long number1 = number;
        while (number1 != 0) {
             arr.add((int) number1 % 10);
             number1 /= 10;
        }
        int sum = arr.stream().mapToInt(Integer::intValue).sum();
        int multipl = arr.stream().reduce(1, (a, b) -> a * b);
        if (sum == multipl) {
            properties.add(PropertiesOfNumbers.SPY);
        }

        //The square hyperskill.numbers sre determines here
        if (Math.sqrt(number) == (int) Math.sqrt(number)) {
            properties.add(PropertiesOfNumbers.SQUARE);
        }

        //The sunny hyperskill.numbers sre determines here
        if (Math.sqrt(number + 1) == (int) Math.sqrt(number + 1)) {
            properties.add(PropertiesOfNumbers.SUNNY);
        }

        //The jumping hyperskill.numbers are determined here
        char[] chars = Long.toString(number).toCharArray();
        boolean jumping = true;
        for (int i = 1; i < chars.length; i++) {
            if (Math.abs(chars[i] - chars[i - 1]) != 1) {
                jumping = false;
            }
        }
        if (jumping) {
            properties.add(PropertiesOfNumbers.JUMPING);
        }
        
        //The happy number are determined here
        if (isHappy(number)) {
            properties.add(PropertiesOfNumbers.HAPPY);
        } else {
            properties.add(PropertiesOfNumbers.SAD);
        }
    }

    /**
     * Return sum of all digits of number. Perfect digital invariant!
     * Use for initialize HAPPY/UNHAPPY property
     */
    private static int pdiFunction(long number) {
        int result = 0;
        while (number > 0) {
            result += Math.pow(number % 10, 2);
            number /= 10;
        }
        return result;
    }

    /**
     * Determine if the specified number is a happy number
     */
    private static boolean isHappy(long number) {
        List<Long> seenNumbers = new ArrayList<>();
        while (number > 1 && !seenNumbers.contains(number)) {
            seenNumbers.add(number);
            number =pdiFunction(number);
        }
        return number == 1;
    }

    /**
     * print all properties in table format, for example:
     *              buzz: false
     *              duck: true
     *       palindromic: false
     *etc.
     */
    public void print() {
        System.out.printf(Locale.ENGLISH,"Properties of %,d%n", this.value);
        for (PropertiesOfNumbers i: PropertiesOfNumbers.values()) {
            boolean thisPropIs = this.properties.contains(i);
            String nameOfProp = i.name().toLowerCase();
            System.out.printf("%11s: %b%n", nameOfProp, thisPropIs);
        }
    }

    /**
     * print only true properties in the line
     */
    public void printList() {
        StringBuilder result = new StringBuilder();
        result.append(String.format(Locale.ENGLISH,"%,15d is", this.value));
        for (PropertiesOfNumbers i: properties) {
            String nameOfProp = i.name().toLowerCase();
            result.append(String.format(" %s,", nameOfProp));
        }
        result.deleteCharAt(result.length() - 1);
        System.out.println(result);
    }

    /**
     * Return true if list of parameters of curr number contains necessary parameters
     * @param includeParams include necessary parameters
     * @param excludeParams include excluded parameters
     * @return true or false
     */
    public boolean isProperties(List<PropertiesOfNumbers> includeParams, List<PropertiesOfNumbers> excludeParams) {
        boolean result = true;
        for (PropertiesOfNumbers prop: includeParams) {
            if (this.properties.contains(prop)) {
                //all ok
            } else {
                result = false;
                break;
            }
        }
        for (PropertiesOfNumbers prop: excludeParams) {
            if (!this.properties.contains(prop)) {
                //all ok
            } else {
                result = false;
                break;
            }
        }
        return result;
    }
}
