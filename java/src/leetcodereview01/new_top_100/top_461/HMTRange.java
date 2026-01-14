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

    public int getDistance01(int a, int b) {
        // 求解方案就是先异或，在就1的个数
        int value = a ^ b;
        int count = 0;
        while(value != 0) {
            value &= (value - 1);
            count++;
        }
        return count;
    }

    public int getDistance02(int a, int b) {
        int value = a ^ b;
        int count = 0;
        while(value != 0) {
            value &= (value-1);
            count++;
        }
        return count;
    }

    // 先来一个异或操作，然后在进行判断1的个数
    public int getDistance03(int a, int b) {
        int value = a ^ b;
        int count = 0;
        while(value > 0) {
            count++;
            value &= (value -1);
        }
        return count;
    }

    public int getDistance04(int a, int b) {
        // 测试距离 先通过异或的方式得到value，然后再计算个数
        int value = a ^ b;
        int count = 0;
        while(value > 0) {
            count++;
            value &= (value -1);
        }
        return count;
    }

    // 0001
    // 0100
    public int getDistance05(int a, int b) {
        int value = a ^ b;
        // 然后求1的个数
        int count = 0;
        while(value > 0) {
            count++;
            value &= (value -1);
        }
        return count;
    }

    // 0001
    // 0100
    // 0101
    public int getDistance06(int a, int b) {
        int value = a ^ b;
        int count = 0;
        while(value > 0) {
            value = value & (value -1);
            count++;
        }
        return count;
    }

    // 先异或在求结果
    public int getDistance07(int a, int b) {
        int value = a ^ b;
        int count = 0;
        while(value > 0) {
            value &= (value - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        HMTRange hmtRange = new HMTRange();
        int distance = hmtRange.getDistance07(1, 4);
        System.out.println(distance);
    }
}
