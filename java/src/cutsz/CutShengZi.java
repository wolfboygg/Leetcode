package cutsz;

/**
 * 剪绳子，n长的绳子剪m段乘积最大
 */
public class CutShengZi {

    public int cutMaxValue(int n) {
        // 使用贪婪算法
        // 尽量剪3 剩余1凑成2,2
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int timeOf3 = n / 3;
        if (n - timeOf3 * 3 == 1) {
            timeOf3--;
        }
        int timeOf2 = (n - timeOf3 * 3) / 2;
        System.out.println(timeOf3 + "->" + timeOf2);
        return (int) Math.pow(3, timeOf3) * (int) Math.pow(2, timeOf2);
    }

    public static void main(String[] args) {
        System.out.println(new CutShengZi().cutMaxValue(8));
    }
}
