package leetcodereview01.jiandan.leetcode16;

public class DoubleNumPower {

    public double power(double base, int n) {
        boolean isNegative = n < 0;
        n = -n;
        // 就是求一半的大小
        double result = pow(base, n);
        return isNegative ? 1 / result : result;
    }

    public double pow(double base, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return base;
        }
        double res = pow(base, n / 2);
        res *= res;
        if (n % 2 != 0) {
            res *= base;
        }
        return res;
    }

    public static void main(String[] args) {
        DoubleNumPower doubleNumPower = new DoubleNumPower();
        System.out.println(doubleNumPower.power(2, 3));
        ;
    }
}
