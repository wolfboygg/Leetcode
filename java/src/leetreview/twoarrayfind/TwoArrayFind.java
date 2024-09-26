package leetreview.twoarrayfind;

/**
 * 二维数组中查找
 * 从左到右递增 从上到下递增
 */
public class TwoArrayFind {

    public boolean find(int[][] arrays, int destValue) {
        if (arrays == null || arrays.length == 0) {
            return false;
        }
        int rows = arrays.length;
        int colunms = arrays[0].length;
        int r = 0;
        int c = colunms - 1;
        while (r <= rows - 1 && c >= 0) { // 需要使用while(循环) 用来控制位置 不能使用for循环
            if (arrays[r][c] == destValue) {
                return true;
            } else if (arrays[r][c] > destValue) {
                c--;
            } else {
                r++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        TwoArrayFind twoArrayFind = new TwoArrayFind();
        boolean b = twoArrayFind.find(array, 5);
        System.out.println(b);
        boolean b1 = twoArrayFind.find(array, 20);
        System.out.println(b1);
    }
}
