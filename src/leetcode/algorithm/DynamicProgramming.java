package leetcode.algorithm;

public class DynamicProgramming {

    public static void main(String[] args) {
        var s1 = "abacaba";
        var s2 = "abcabc";
        System.out.println(lcs(s1, s2));
    }

    private static int lcs(String s1, String s2) {
        var n = s1.length();
        var m = s2.length();
        if (n == 0 || m == 0) return 0;
        var dp = new int[n + 1][m + 1];
        var p = new String[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    p[i][j] = String.valueOf(s1.charAt(i - 1));
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    if (dp[i - 1][j] > dp[i][j - 1]) {
                        dp[i][j] = dp[i - 1][j];
                        p[i][j] = " ";
                    } else {
                        dp[i][j] = dp[i][j - 1];
                        p[i][j] = " ";
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(p[i][j] + " ");
            }
            System.out.println();
        }
        return dp[n][m];
    }
}
