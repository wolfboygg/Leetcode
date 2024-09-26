package leetcodereview01.top100.top_461;

/**
 * 汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意： 0 ≤ x, y < 231.
 *
 */
public class HammingDistance {

    public int getDistance(int x, int y) {
        // 解题思路，先求x y异或之后的值，然后在取1的个数
        int value = x ^ y;
        int count = 0;
        while(value != 0) {
            value &= (value -1);
            count++;
        }
        return count;
    }


    public static void main(String[] args){
        int x = 7;
        int y = 4;
        HammingDistance hammingDistance = new HammingDistance();
        int distance = hammingDistance.getDistance(x, y);
        System.out.println(distance);
    }
}
