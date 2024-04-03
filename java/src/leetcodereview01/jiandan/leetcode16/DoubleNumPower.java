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
        return isNegative ? 1 / result : result;
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
        if (target % 2 != 0) {
            res = res * base;
        }
        return res;
    }

    public double power02(int base, int target) {
        // 求base的的target次方
        boolean isNegative = target < 0;
        double result = pow02(base, Math.abs(target));
        return isNegative ? 1 / result : result;
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

    public double power03(int base, int target) {
        boolean isNegative = target < 0;
        double value = pow03(base, Math.abs(target));
        return isNegative ? 1 / value : value;
    }

    public double pow03(int base, int target) {
        if (target == 0) {
            return 1;
        }
        if (target == 1) {
            return base;
        }
        double value = pow03(base, target / 2);
        value *= value;
        if (target / 2 != 0) {
            value *= base;
        }
        return value;
    }

    public double power04(int base, int target) {
        boolean isNegative = target < 0;
        double value = realPower04(base, target);
        return isNegative ? 1.0 / value : value;
    }

    public double realPower04(int base, int target) {
        if (target == 0) {
            return 1;
        }
        if (target == 1) {
            return base;
        }
        double value = realPower04(base, target / 2);
        value *= value;
        if (target % 2 != 0) {
            value *= base;
        }
        return value;
    }

    public double power05(double base, int target) {
        boolean isNegative = target < 0;
        double value = realPower05(base, Math.abs(target));
        return isNegative ? 1 / value : value;
    }

    public double realPower05(double base, int target) {
        if (target == 0) {
            return 1;
        }
        if (target == 1) {
            return base;
        }
        double value = realPower05(base, target / 2);
        value *= value;
        if (target % 2 != 0) {// 考虑除不尽的情况补一base
            value *= base;
        }
        return value;
    }

    public double power06(double base, int target) {
        // 看是不是一个负数
        boolean isNegation = target < 0;
        double realValue = realPower06(base, Math.abs(target));
        return isNegation ? 1.0 / realValue : realValue;
    }

    public double realPower06(double base, int target) {
        // 查看是不是 0 / 1
        if (target == 0) {
            return 1.0;
        }
        if (target == 1) {
            return base;
        }
        double realValue = realPower06(base, target / 2);
        realValue *= realValue; // 这里相当于重复一遍
        if (target % 2 != 0) {
            realValue *= base;
        }
        return realValue;
    }

    public double power07(double base, int target) {
        // 求指数问题
        boolean isNegative = target < 0;
        double realValue = realPower07(base, Math.abs(target));
        return isNegative ? 1 / realValue : realValue;
    }

    public double realPower07(double base, int target) {
        if (target == 0) {
            return 1;
        }
        if (target == 1) {
            return base;
        }
        // /2的方式少计算一次
        double value = realPower07(base, target / 2);
        value *= value;
        if (target / 2 != 0) {
            value *= base;
        }
        return value;
    }

    public static void main(String[] args) {
        DoubleNumPower doubleNumPower = new DoubleNumPower();
        System.out.println(doubleNumPower.power07(2, -3));
    }
}
