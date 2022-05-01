package codeWars.reverseWords;

public class Kata
{
    public static String reverseWords(final String original) {
        String[] orig = original.split("\s");
        StringBuilder result = new StringBuilder(original);
        for (String i: orig) {
            StringBuilder j = new StringBuilder(i).reverse();
            int index = result.indexOf(i);
            result.replace(index, i.length() + index, j.toString());
        }
        return result.toString();
    }
}
