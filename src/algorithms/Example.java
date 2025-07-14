package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Example {

    public static void main(String[] args) {
        System.out.println(checkLinesOfString("Hello World testing the result of the task", 10));
    }

    private static List<String> checkLinesOfString(String input, int lineSize) {
        List<String> result = new ArrayList<>();
        var currentLine = input.split(" ");
        var line = new StringBuilder();
        for (var word : currentLine) {
            if (line.length() > lineSize) {
                result.add(line.toString());
                line = new StringBuilder();

            }
            line.append(word + " ");
        }
        return result;

    }
}
