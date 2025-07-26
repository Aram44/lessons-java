package task;

import java.util.Stack;

public class Task2 {
    public static void main(String[] args) {
        System.out.println(isBalanced("((())())"));
        System.out.println(isBalanced(")()("));
    }

    private static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            }else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
