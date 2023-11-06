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

    public int getWayNumber03(int n) {
        if (n == 1) {
            return 1;
        }
        if (n ==2) {
            return 2;
        }
        int temp01 = 1;
        int temp02 = 2;
        for (int i = 3; i <=n; i++) {
            int result = temp01 +temp02;
            temp01 = temp02;
            temp02 = result;
        }
        return temp02;
    }

    public int getWayNumber04(int n) {
        // 上台阶
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int temp01 = 1;
        int temp02 = 2;
        int way = 0;
        for (int i = 3; i <= n; i++) {
            way = temp01 + temp02;
            temp01 = temp02;
            temp02 = way;
        }
        return way;
    }

    public int getWayNumber05(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int temp1 = 1;
        int temp2 = 2;
        int value = 3;
        for (int i = 3; i <= n; i++) {
            value = temp1 + temp2;
            temp1 = temp2;
            temp2 = value;
        }
        return value;
    }

    public int getWayNumber06(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int temp1 = 1;
        int temp2 = 2;
        int value = 0;
        for (int i = 3; i <= n; i++) {
            value = temp1 + temp2;
            temp1 = temp2;
            temp2 = value;
        }
        return value;
    }


    public static void main(String[] args) {
        WayNumber wayNumber = new WayNumber();
        int wayNumber1 = wayNumber.getWayNumber06(7);
        System.out.println(wayNumber1);
    }
}
