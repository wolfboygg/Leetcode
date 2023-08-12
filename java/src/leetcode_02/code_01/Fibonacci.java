package leetcode_02.code_01;

public class Fibonacci {

    public static void main(String[] args) {

        System.out.println(fibonacci(10));
        System.out.println(Fibonacci(10));
    }


    /**
     * 0 1 1 2 3 5
     * 使用动态规划求解 主要位了避免递归的时候重复计算问题，多已经计算的结果进行缓存
     */
    public static int fibonacci(int n) {
        int fibo = 0;
        int pre1 = 0;
        int pre2 = 1;
        for (int i = 2; i <= n; i++) {
            fibo = pre1 + pre2;
            pre1 = pre2;
            pre2 = fibo;
            System.out.println("fibo:" + fibo + "->pre1:" + pre1 + "->pre2:" + pre2);
        }
        return fibo;
    }

    public static int Fibonacci(int n) {
        if (n <= 1)
            return n;
        int[] fib = new int[n + 1];
        fib[1] = 1;
        for (int i = 2; i <= n; i++)
            fib[i] = fib[i - 1] + fib[i - 2];
        return fib[n];
    }
}
