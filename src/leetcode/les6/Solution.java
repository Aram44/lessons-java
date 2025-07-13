package leetcode.les6;

public class Solution {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        var chars = s.toCharArray();
        int step = numRows - 2;
        int size = numRows + step;
        StringBuilder res = new StringBuilder();
        for (int j = 1; j < (chars.length / size)+1; j++) {
            System.out.println("Start");
            for (int i = 0; i < numRows; i++) {
                if (i == 0) {
                    res.append(chars[j * size - 1]);
                    System.out.println("Res " + chars[j*i] + "i :" + j*i);
                } else {
                    if (i == (size - i)){
                        res.append(chars[j*i]);
                        System.out.println("Res " + chars[j*i] + "i :" + i*j + " same");
                    }else {
                        res.append(chars[j*i]);
                        res.append(chars[j*(size - i)]);
                        System.out.println("Res " + chars[j*i] + " " + chars[j*(size - i)]);
                        System.out.println("i :" + i*j + " last " + j*(size - i));
                    }
                }
            }
        }
        return res.toString();
    }
}
