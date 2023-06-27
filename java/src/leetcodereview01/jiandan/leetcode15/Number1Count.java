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


    public static void main(String[] args) {
        NumIn1Count numIn1Count = new NumIn1Count();
        System.out.println(numIn1Count.getNumIn1Count(15));
    }
}
