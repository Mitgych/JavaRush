package codeWars.createPhoneNumber;

public class createPhoneNumber {
    public static String createPhoneNumber(int[] numbers) {
        StringBuilder result = new StringBuilder("() -");
        String onePart = Integer.toString(numbers[0]) +
                Integer.toString(numbers[1]) +
                Integer.toString(numbers[2]);
        String twoPart = Integer.toString(numbers[3]) +
                Integer.toString(numbers[4]) +
                Integer.toString(numbers[5]);
        String threePart = Integer.toString(numbers[6]) +
                Integer.toString(numbers[7]) +
                Integer.toString(numbers[8]) +
                Integer.toString(numbers[9]);
        result.insert(1, onePart).insert(6, twoPart).insert(10, threePart);

        return result.toString();
    }
}
