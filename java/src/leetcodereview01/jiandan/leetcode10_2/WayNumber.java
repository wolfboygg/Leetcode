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
        if (n <= 0) {
            return -1;
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

    public int getWayNumber03(int n) {
        if (n <= 0) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int value01 = 1;
        int value02 = 2;
        int value = 0;
        for (int i = 3; i <= n; i++) {
            value = value01 + value02;
            value01 = value02;
            value02 = value;
        }
        return value;
    }

    public static void main(String[] args) {
        WayNumber wayNumber = new WayNumber();
        int wayNumber1 = wayNumber.getWayNumber03(7);
        System.out.println(wayNumber1);
    }
}
