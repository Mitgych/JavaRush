package numbers;

public class Number {
    protected long value;
    protected boolean isBuzz;
    protected boolean isOdd;
    protected boolean isEven;
    protected boolean isDuck;
    protected boolean isPalindromic;
    protected boolean isGapful;



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
        var str = new StringBuilder(str1); //TODO: u can use String instead of StringBuilder
        this.isPalindromic = str.reverse().toString().equals(str1);

        //The gapful number are determines here
        if (Math.abs(number) > 99) {
            String firstDigit = Long.toString(number % 10);
            //find last digit
            int degree = (int) Math.log10(number);
            Long lastDigitLong = (number / (long)(Math.pow(10, degree)));
            String lastDigit = Long.toString(lastDigitLong);
            Long number2 = Long.getLong(firstDigit + lastDigit);
            this.isGapful = number % number2 == 0;
        } else this.isGapful = false;

    }


    public void print() {
        System.out.println("Properties of " + this.value +
                "\n       even: " +  this.isEven +
                "\n        odd: " + this.isOdd +
                "\n       buzz: " + this.isBuzz +
                "\n       duck: " + this.isDuck +
                "\npalindromic: " + this.isPalindromic +
                "\n     gapful: " + this.isGapful);
    }
}
