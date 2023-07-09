package leetcodereview01.jiandan.leetcode62;

public class CircleLastNumber {
    // 5, 3
    // [0, 1, 2, 3, 4]
    public static void main(String[] args) {
        // 通过递归的方式进行求解
        CircleLastNumber circleLastNumber = new CircleLastNumber();
        System.out.println(circleLastNumber.lastNumberByGH(5, 3));;
    }
    // 5, 3
    private int lastNumber(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = lastNumber(n - 1, m);
        System.out.println(x);
        return (m + x) % n;
    }

    private int lastNumberByGH(int n, int m) {
        int x = 0;
        for (int i = 2; i < n + 1; i++) { // 规律
            x = (x + m) % i;
        }
        return x;
    }
}
