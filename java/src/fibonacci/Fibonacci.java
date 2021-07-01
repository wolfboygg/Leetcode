package fibonacci;

class Fibonacci {

    /**
     * 递归实现
     */
    public int fibonacciByDG(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }
        int result = fibonacciByDG(n - 1) + fibonacciByDG(n - 2);

        return result;
    }

    /**
     * 动态规划实现
     *
     * @param n
     */
    public int fibonacciByDynamic(int n) {

        if (n <= 0) {
            System.out.println(0);
            return 0;
        }

        if (n == 1) {
            System.out.println(1);
            return 1;
        }

        int num1 = 0;
        int num2 = 1;
        int result = 0;

        for (int i = 2; i <= n; i++) {
            result = num1 + num2;
            num1 = num2;
            num2 = result;
            System.out.println(result);
        }
        return result;
    }

    public int takeTJ(int n) {
        if (n == 0) {
            throw new RuntimeException("input num error");
        }
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int num1 = 1;
        int num2 = 2;
        int result = 0;

        for (int i = 3; i <= n; i++) {
            result = num1 + num2;
            num1 = num2;
            num2 = result;
        }
        return result;
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.fibonacciByDynamic(10);
        System.out.println(fibonacci.fibonacciByDG(10));
        System.out.println(fibonacci.takeTJ(7));
    }
}