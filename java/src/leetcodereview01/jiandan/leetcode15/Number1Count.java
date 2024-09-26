package leetcodereview01.jiandan.leetcode15;

import bitnum1.NumIn1Count;

public class Number1Count {

    public int number1Count(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }

    public int getNumberOf1Count(int n) {
        int count = 0;
        while(n > 0) {
            count++;
            n &= (n-1);
        }
        return count;
    }

    public int getNumberOf1Count02(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n = n &(n-1);
        }
        return count;
    }

    public int getNumberOf1Count03(int n) {
        int count = 0;
        while(n > 0) {
            count++;
            n &= n-1;
        }
        return count;
    }

    public int getNumberOf1Count04(int n) {
        int count = 0;
        while(n > 0) {
            count++;
            n = n & (n -1);
        }
        return count;
    }

    public int getNumberOf1Count05(int n) {
        int count = 0;
        while(n > 0) {
            count++;
            n &= (n-1);
        }
        return count;
    }

    public int getNumberOf1Count06(int n) {
        // 1010
        // 1001
        int count = 0;
        while(n > 0) {
            n &= n-1;
            count ++;
        }
        return count;
    }


    public int getNumberOf1Count07(int target) {
        // 求一个整数转换为二进制时候的1的个数
        int count = 0;
        while (target > 0) {
            count++;
            target = target & (target - 1);
        }
        return count;
    }

    public int getNumberOf1Count08(int target) {
        // & n-1
        int n = 0;
        while(target > 0) {
            n += 1;
            target &= (target -1);
        }
        return n;
    }

    public static void main(String[] args) {
        Number1Count numIn1Count = new Number1Count();
        System.out.println(numIn1Count.getNumberOf1Count08(10));
    }
}
