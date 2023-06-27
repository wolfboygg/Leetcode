package leetcodereview01.jiandan.leetcode10_1;

public class Fibonacci {

    public int getFibonacciValue(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return getFibonacciValue(n - 1) + getFibonacciValue(n - 2);
    }

    public int getFibonacciValueByGH(int n) {
        int temp01 = 0;
        int temp02 = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = temp01 + temp02;
            temp01 = temp02;
            temp02 = result;
        }
        return result;
    }


    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int fibonacciValue = fibonacci.getFibonacciValueByGH(6);
        System.out.println(fibonacciValue);
    }
}
