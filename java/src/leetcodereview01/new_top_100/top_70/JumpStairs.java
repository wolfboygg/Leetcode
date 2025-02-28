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

    public static void main(String[] args) {
        JumpStairs jumpStairs = new JumpStairs();
        int num = jumpStairs.climbStairs03(5);
        System.out.println(num);
    }
}
