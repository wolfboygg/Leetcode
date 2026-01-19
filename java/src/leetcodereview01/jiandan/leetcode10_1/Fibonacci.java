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

    public int getFibonacciByGH01(int n) {
        if (n <= 0) {
            return -1;
        }
        int temp01 = 1;
        int temp02 = 1;
        int value = 0;
        for (int i = 3; i <= n; i++) {
            value = temp01 + temp02;
            temp01 = temp02;
            temp02 = value;
        }
        return value;
    }


    public int getFibonacciByGH02(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        int value01 = 1;
        int value02 = 1;
        int value = 0;
        for (int i = 3; i <= n; i++) {
            value = value01 + value02;
            value01 = value02;
            value02 = value;
        }
        return value;
    }

    // 1 1 2 3 5 8
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int fibonacciValue = fibonacci.getFibonacciByGH02(6);
        System.out.println(fibonacciValue);
    }
}
