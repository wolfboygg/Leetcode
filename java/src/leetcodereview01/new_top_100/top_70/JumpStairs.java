package leetcodereview01.new_top_100.top_70;

public class JumpStairs {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int value1 = 1;
        int value2 = 2;
        int value = 0;
        for (int i = 3; i <= n; i++) {
            value = value1 + value2;
            value1 = value2;
            value2 = value;
        }
        return value;
    }

    public int climbStairs01(int n) {
        // 跳台阶有几种方式
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int value1 = 1;
        int value2 = 2;
        int value = 0;
        for (int i = 3; i <= n; i++) {
            value = value1 + value2;
            value1 = value2;
            value2 = value;
        }
        return value;
    }


    public int climbStairs02(int n) {
        if (n < 1) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int value1 = 1;
        int value2 = 2;
        int value = 0;
        for (int i = 3; i <= n; i++) {
            value = value1 + value2;
            value1 = value2;
            value2 = value;
        }
        return value;
    }

    public int climbStairs03(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int value = 0;
        int value1 = 1;
        int value2 = 2;
        for (int i = 3; i <= n; i++) {
            value = value1 + value2;
            value1 = value2;
            value2 = value;
        }
        return value;
    }

    public int climStairs04(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int value1 = 1;
        int value2 = 2;
        int value = 0;
        for (int i = 3; i <= n; i++) {
            value = value1 + value2;
            value1 = value2;
            value2 = value;
        }
        return value;
    }

    public int climStairs05(int n) {
        if (n <= 0) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int num1 = 1;
        int num2 = 2;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = num1 + num2;
            num1 = num2;
            num2 = sum;
        }
        return sum;
    }


    public int climStairs06(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int num1 = 1;
        int num2 = 2;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = num1 + num2;
            num1 = num2;
            num2 = sum;
        }
        return sum;
    }

    public int climStairs07(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int num1 = 1;
        int num2 = 2;
        int value = 0;
        for (int i = 3; i <= n; i++) {
            value = num1 + num2;
            num1= num2;
            num2 = value;
        }
        return value;
    }


    public static void main(String[] args) {
        JumpStairs jumpStairs = new JumpStairs();
        int num = jumpStairs.climStairs07(5);
        System.out.println(num);
    }
}
