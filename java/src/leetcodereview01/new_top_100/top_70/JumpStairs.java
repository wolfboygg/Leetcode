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
    public static void main(String[] args) {
        JumpStairs jumpStairs = new JumpStairs();
        int num = jumpStairs.climbStairs(5);
        System.out.println(num);
    }
}
