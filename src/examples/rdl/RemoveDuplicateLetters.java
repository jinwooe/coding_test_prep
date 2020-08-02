package examples.rdl;

import java.util.Stack;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        System.out.println(remove("cbacdcbc"));
    }

    public static String remove(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            Character ch = input.charAt(i);

            if (stack.contains(ch)) { continue; }

            while (!stack.isEmpty() && stack.peek() > ch && input.indexOf(stack.peek(), i) != -1) {
                stack.pop();
            }
            stack.push(ch);
        }
        char[] res = new char[stack.size()];
        int i = 0;
        for (Character ch : stack) {
            res[i++] = ch;
        }

        return new String(res);
    }
}
