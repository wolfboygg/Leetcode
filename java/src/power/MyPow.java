package power;

public class MyPow {

    boolean isNegative = false;

    public double pow(double base, int exponent) {
        if (base == 0.0 && exponent < 0) {
            return 0;
        }
        if (exponent < 0) {
            exponent = -exponent;
            isNegative = true;
        }
        double result = selfPow(base, exponent);
        return isNegative ? 1.0 / result : result;
    }

    public double selfPow(double base, int exponent) {
        if (exponent == 0) return 1;
        if (exponent == 1) return base;
        double result = selfPow(base, exponent >> 1);
        result *= result;
        if (exponent % 2 != 0) {// 奇数
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MyPow().pow(2, 3));
    }

}
