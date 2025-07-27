package leetcode.les22;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static List<String> res = new ArrayList<>();
    public static Stack<String> stack = new Stack<>();


    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));
    }

    public static List<String> generateParenthesis(int n) {
        backtrack(0, 0, n);
        return res;
    }

    public static void backtrack(int open, int close, int n) {
        if (open == close && close == n){
            res.add(String.join("", stack));
        }
        if (open < n){
            stack.add("(");
            backtrack(open + 1, close, n);
            stack.pop();
        }
        if (close < open){
            stack.add(")");
            backtrack(open, close+1, n);
            stack.pop();
        }
    }
}
