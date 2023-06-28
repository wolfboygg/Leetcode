package leetcodereview01.jiandan.leetcode10_2;

public class WayNumber {

    public int getWayNumber(int n) {
        int temp1 = 1;
        int temp2 = 2;
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = temp1 + temp2;
            temp1 = temp2;
            temp2 = result;
        }
        return result;
    }

    public int getWayNumber02(int n) {
        int temp01 = 1;
        int temp02 = 2;
        if (n == 1) {
            return temp01;
        }
        if (n == 2) {
            return temp02;
        }
        int result = 0;
        for (int i = 3;i <= n ; i++) {
            result = temp01 + temp02;
            temp01 = temp02;
            temp02 = result;
        }
        return result;

    }

    public static void main(String[] args) {
        WayNumber wayNumber = new WayNumber();
        int wayNumber1 = wayNumber.getWayNumber02(7);
        System.out.println(wayNumber1);
    }
}
