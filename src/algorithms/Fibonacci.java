package algorithms;

public class Fibonacci {
    public static void main(String[] args) {
        final int n = 100;
        final long[] mem = new long[n + 1];
        System.out.println("Fibonacci numbers memoization: " + fibonaciiMemoization(n, mem));
    }

    private static long fibonaciiMemoization(int n, long[] mem) {
        if (n <= 1) {
            return n;
        }
        if (mem[n] != 0) {
            return mem[n];
        }
        var res = fibonaciiMemoization(n - 1, mem) + fibonaciiMemoization(n - 2, mem);
        mem[n] = res;
        return res;
    }


}
