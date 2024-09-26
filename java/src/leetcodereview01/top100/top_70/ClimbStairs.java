package leetcodereview01.top100.top_70;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * **注意：**给定 n 是一个正整数
 */
public class ClimbStairs {

    private int climb(int n) {
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

    public int climn01(int n) {
        // 爬楼梯
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int temp01 = 1;
        int temp02 = 2;
        int value = 0;
        for (int i = 3; i <= n; i++) {
            value = temp01 + temp02;
            temp01 = temp02;
            temp02 = value;
        }
        return value;
    }

    public static void main(String[] args){
        // 动态规划的方式进行求解
        ClimbStairs climbStairs = new ClimbStairs();
        int value = climbStairs.climb(7);
        System.out.println(value);
    }
}
