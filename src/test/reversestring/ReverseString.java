package test.reversestring;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverse("hello"));
    }

    public static String reverse(String input) {
        final char[] chars = input.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while(i < j) {
            char temp;
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;

            i++;
            j--;
        }

        return new String(chars);
    }
}
