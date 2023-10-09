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

    public static void main(String[] args) {
        Number1Count numIn1Count = new Number1Count();
        System.out.println(numIn1Count.getNumberOf1Count04(10));
    }
}
