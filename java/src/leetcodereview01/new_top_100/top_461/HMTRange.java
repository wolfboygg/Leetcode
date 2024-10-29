package leetcodereview01.new_top_100.top_461;

/**
 * 汉明塔距离
 */
public class HMTRange {

    public int getDistance(int a, int b) {
        // 求距离
        // 0001
        // 0100
        // 0101 // 结果

        int value = a ^ b;
        int count = 0;
        while(value != 0) {
            value &= value - 1; // 这里是与才能拿到正确的结果
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        HMTRange hmtRange = new HMTRange();
        int distance = hmtRange.getDistance(1, 4);
        System.out.println(distance);
    }
}
