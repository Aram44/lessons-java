package algorithms.leetcode.les150;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public static List actions = List.of("+", "-", "*", "/");

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2","1","+","3","*"}));
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }

    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        var stack = new Stack();
        int i = 1, res = 0;
        stack.push(tokens[0]);
        while (!stack.isEmpty()) {
            var item = tokens[i];
            i = Math.min(tokens.length - 1, i + 1);
            if (actions.contains(item)) {
                var num1 = stack.pop();
                if (item == "+") {
                    if (!stack.isEmpty()) {
                        var num2 = stack.pop();
                        res = Integer.valueOf((String) num2) + Integer.valueOf((String) num1);
                    } else {
                        res += Integer.valueOf((String) num1);
                    }
                } else if (item == "-") {
                    if (!stack.isEmpty()) {
                        var num2 = stack.pop();
                        res = Integer.valueOf((String) num2) - Integer.valueOf((String) num1);
                    } else {
                        res -= Integer.valueOf((String) num1);
                    }
                } else if (item == "*") {
                    if (!stack.isEmpty()) {
                        var num2 = stack.pop();
                        res = Integer.valueOf((String) num2) * Integer.valueOf((String) num1);
                    } else {
                        res *= Integer.valueOf((String) num1);
                    }
                } else {
                    if (!stack.isEmpty()) {
                        var num2 = stack.pop();
                        res = Integer.valueOf((String) num2) / Integer.valueOf((String) num1);
                    } else {
                        res /= Integer.valueOf((String) num1);
                    }
                }
                var addItem = tokens[i];
                if (!actions.contains(addItem)) {
                    stack.push(tokens[i]);
                }
            } else {
                stack.push(item);
            }
        }
        return res;
    }

    public static int evalRPN2(String[] tokens) {
        Stack<Integer> stackOperation = new Stack();
        Set<String> operations = new HashSet<>(){{
            add("+");
            add("-");
            add("/");
            add("*");
        }};
        for(int i = 0; i<tokens.length; i++){
            String token = tokens[i];
            if(operations.contains(token)){
                int second = stackOperation.pop();
                int first = stackOperation.pop();
                int result = switch(token){
                    case "+"-> first + second;
                    case "-"-> first - second;
                    case "/"-> first / second;
                    case "*"-> first * second;
                    default -> throw new IllegalArgumentException("Unknown operator: " + token);
                };
                stackOperation.push(result);
            }else{
                stackOperation.push(Integer.valueOf(token));
            }
        }
        return stackOperation.pop();
    }
}
