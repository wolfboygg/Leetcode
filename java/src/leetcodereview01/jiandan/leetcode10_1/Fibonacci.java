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


    public int getFibonacciByDG02(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return getFibonacciByDG02(n - 1) + getFibonacciByDG02(n - 2);
    }

    public int getFibonacciByGH02(int n) {
        int temp01 = 0;
        int temp02 = 1;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = temp01 + temp02;
            temp01 = temp02;
            temp02 = result;
        }
        return result;
    }

    public int getFibonacciByGH03(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int temp01 = 0;
        int temp02 = 1;
        for (int i = 2; i <=n ;i++) {
            int result = temp01 + temp02;
            temp01 = temp02;
            temp02 = result;
        }
        return temp02;
    }

    public int getFibonacciByGH04(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int temp01 = 0;
        int temp02 = 1;
        int value = 0;
        for (int i = 2; i <=n; i++) {
            value = temp01 + temp02;
            temp01 = temp02;
            temp02 = value;
        }
        return value;
    }

    public int getFibonacciByGH05(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int temp01 = 0;
        int temp02 = 1;
        int value = 1;
        for (int i = 2; i <= n; i++) {
              value = temp01 + temp02;
              temp01 = temp02;
              temp02 = value;
              System.out.print(value + "  ");
        }
        return value;
    }

    public int getFibonacciByGH06(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int temp1 = 0;
        int temp2 = 1;
        int value = 0;
        for (int i = 2; i <= n; i++) {
            value = temp1 + temp2;
            temp1 = temp2;
            temp2 = value;
        }
        return value;
    }

    public int getFibonacciByGH07(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        int temp01 = 1;
        int temp02 = 1;
        int value = 0;
        for(int i = 3; i <= n; i++) {
          value = temp01 + temp02;
          temp01 = temp02;
          temp02 = value;
        }
        return value;
    }

    public int getFibonacciByGH08(int n) {
        // 1 1 2 3 5
        if (n == 1 || n == 2) {
            return 1;
        }
        int value1 = 1;
        int value2 = 1;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = value1 + value2;
            value1 = value2;
            value2 = res;
        }
        return res;
    }

    public int getFibonacciByGH09(int n) {
        // 通过动态规划的方式进行求解
        if (n == 0) {
            return 0;
        }
        // 1 1 2 3 5
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        int value = 0;
        int pre1 = 1;
        int pre2 = 1;
        for (int i = 3; i <= n; i++) {
            value = pre1 + pre2;
            pre1 = pre2;
            pre2 = value;
        }
        return value;
    }

    public int getFibonacciByGH10(int n) {
        if (n <= 0) {
            return -1;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int pre = 1;
        int post = 1;
        int value = 0;
        for (int i = 3; i <= n; i++) {
            value = pre +  post;
            pre = post;
            post = value;
        }
        return value;
    }

    public int getFibonacciByGH11(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int pre = 1;
        int post = 1;
        int total = 0;
        for (int i = 3; i <= n; i++) {
            total = pre + post;
            pre = post;
            post = total;
        }
        return total;
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int fibonacciValue = fibonacci.getFibonacciByGH11(6);
        System.out.println(fibonacciValue);
    }
}
