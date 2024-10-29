package leetcodereview01.new_top_100.top_136;

/**
 * 只出现一次的数字，通过异或的方式
 */
public class OnlyOneNumber {

    /**
     * @param arr
     * @return
     */
    public int onlyOne(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int res = 0;
        for (int num : arr) {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
       // 任何数和0异或的任何数
        int[] arr = {4,1,2,1,2};
        OnlyOneNumber onlyOneNumber = new OnlyOneNumber();
        int i = onlyOneNumber.onlyOne(arr);
        System.out.println(i);
    }
}
