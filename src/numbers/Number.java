package numbers;

import java.util.ArrayList;

public class Number {
    private final long value;
    private final boolean isBuzz;
    private final boolean isOdd;
    private final boolean isEven;
    private final boolean isDuck;
    private final boolean isPalindromic;
    private final boolean isGapful;
    private final boolean isSpy;



    public Number(long number) {
        this.value = number;

        //This determines the parity of the number
        if (number % 2 == 0) {
            this.isOdd = false;
            this.isEven = true;
        } else {
            this.isOdd = true;
            this.isEven = false;
        }

        //The buzz number are determines here
        this.isBuzz = number % 7 == 0 || number % 10 == 7;

        //The duck number are determines here
        String numberAsString = Long.toString(number);
        if (numberAsString.charAt(0) == '0') {
            numberAsString = numberAsString.substring(1);
        }
        this.isDuck = numberAsString.contains("0");

        //The palindromic number are determines here
        var str1 = Long.toString(number);
        var str = new StringBuilder(str1);
        this.isPalindromic = str.reverse().toString().equals(str1);

        //The gapful number are determines here
        if (Math.abs(number) > 99) {
            long lastDigit = number % 10;
            //find last digit
            int degree = (int) Math.log10(number);
            long firstDigit = number / (long) (Math.pow(10, degree));
            long number2 = firstDigit * 10 + lastDigit;
            this.isGapful = number % number2 == 0;
        } else this.isGapful = false;

        //The spy numbers are determines here
        ArrayList<Integer> arr = new ArrayList<>();
        long val = number;
        while (val != 0) {
            arr.add((int) val % 10);
            val /= 10;
        }
        int sum = arr.stream().mapToInt(Integer::intValue).sum();
        int multipl = arr.stream().reduce(1, (a, b) -> a * b);
        isSpy = sum == multipl;
    }


    public void print() {
        System.out.println("Properties of " + this.value +
                "\n       even: " +  this.isEven +
                "\n        odd: " + this.isOdd +
                "\n       buzz: " + this.isBuzz +
                "\n       duck: " + this.isDuck +
                "\npalindromic: " + this.isPalindromic +
                "\n     gapful: " + this.isGapful +
                "\n        spy: " + this.isSpy +
                "\n");
    }

    public void printList() {
        StringBuilder result = new StringBuilder();
        result.append(this.value).append(" is");
        if (this.isEven) {
            result.append(" even,");
        }
        if (this.isOdd) {
            result.append(" odd,");
        }
        if (this.isBuzz) {
            result.append(" buzz,");
        }
        if (this.isDuck) {
            result.append(" duck,");
        }
        if (this.isPalindromic) {
            result.append(" palindromic,");
        }
        if (this.isGapful) {
            result.append(" gapful,");
        }
        if (this.isSpy) {
            result.append(" spy,");
        }
        result.deleteCharAt(result.length() - 1);
        System.out.println(result);
    }

    public boolean isProperty(String prop) {
        boolean result = false;
        switch (prop) {
            case "EVEN":
                result = this.isEven;
                break;
            case "ODD":
                result = this.isOdd;
                break;
            case "BUZZ":
                result = this.isBuzz;
                break;
            case "DUCK": result = this.isDuck;
                break;
            case "PALINDROMIC":
                result = this.isPalindromic;
                break;
            case "GAPFUL":
                result = this.isGapful;
                break;
            case "SPY":
                result = this.isSpy;
                break;
        }
        return result;
    }
}
