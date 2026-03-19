import java.util.*;

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+'; // previous operator

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // build number
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            // if operator OR last character
            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {

                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }

                sign = ch;
                num = 0;
            }
        }

        // sum all values
        int result = 0;
        for (int val : stack) {
            result += val;
        }

        return result;
    }
}