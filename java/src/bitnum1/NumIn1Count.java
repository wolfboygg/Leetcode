package bitnum1;

public class NumIn1Count {

    public int getNumIn1Count(int n) {
        // 采用与运算的方式进行操作，主要将n&(n-1) 有多少为1就可以进行多少次这样的操作
        int count = 0;
        while (n > 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NumIn1Count().getNumIn1Count(3));
    }
}
