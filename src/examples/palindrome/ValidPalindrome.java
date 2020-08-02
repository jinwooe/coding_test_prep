package examples.palindrome;

import java.util.ArrayList;
import java.util.List;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isValidPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isValidPalindrome("race a car"));
        System.out.println(isValidPalindrome("abba"));
    }

    public static boolean isValidPalindrome(String input) {
        final char[] chars = input.toLowerCase().toCharArray();
        List<Character> alphaNumeric = new ArrayList<>();
        for(Character ch : chars) {
            if(Character.isDigit(ch) || Character.isLetter(ch)) {
                alphaNumeric.add(ch);
            }
        }

        final Character[] targetChars = alphaNumeric.toArray(new Character[alphaNumeric.size()]);

        int i = 0;
        int j = targetChars.length - 1;
        while(i < j) {
            if(targetChars[i] != targetChars[j]) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
