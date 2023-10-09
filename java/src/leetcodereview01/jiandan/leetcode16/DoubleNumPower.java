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

    public double power01(double base, int target) {
        boolean isNegative = target < 0;
        double result = pow01(base, Math.abs(target));
        return isNegative ? 1/result: result;
    }
    public double pow01(double base, int target) {
        if (target == 0) {
            return 1;
        }
        if (target == 1) {
            return base;
        }
        double res = pow01(base, target / 2);
        res *= res;
        if (target % 2 !=0) {
            res = res* base;
        }
        return res;
    }

    public double power02(int base, int target) {
        // 求base的的target次方
        boolean isNegative = target < 0;
        double result = pow02(base, Math.abs(target));
        return isNegative ? 1/ result : result;
    }
    public double pow02(int base, int target) {
        if (target == 0) {
            return 1;
        }
        if (target == 1) {
            return base;
        }
        double value = pow02(base, target / 2);
        value *= value;
        if (target / 2 != 0) {
            value = value * base;
        }
        return value;
    }

    public static void main(String[] args) {
        DoubleNumPower doubleNumPower = new DoubleNumPower();
        System.out.println(doubleNumPower.power02(2, 3));
        ;
    }
}
