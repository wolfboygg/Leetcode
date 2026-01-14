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

    // 只出现一次的数字
    public int onlyOne01(int[] arr) {
        // 使用异或的方式
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int value = 0;
        for (int i = 0; i < arr.length; i++) {
            value ^= arr[i];
        }
        return value;
    }

    public int onlyOne02(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // 只出现一次，那么通过异或就可以将出现两次的重置为0
        int value = 0;
        for (int i = 0; i < arr.length; i++) {
            value ^= arr[i];
        }
        return value;
    }

    public int onlyOne03(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // 使用异或的方式
        int value = 0;
        for (int item : arr) {
            value = value ^ item;
        }
        return value;
    }

    // 只出现一次的数，通过异或的方式
    public int onlyOne04(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int value = 0;
        for (int i = 0; i < arr.length; i++) {
            value ^= arr[i];
        }
        return value;
    }

    public int onlyOne05(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int value = 0;
        for (int i : arr) {
            value ^= i;
        }
        return value;
    }

    public int onlyOne06(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int value = 0;
        for (int i = 0; i < arr.length; i++) {
            value ^= arr[i];
        }
        return value;
    }

    public int onlyOne07(int[] arr) {
        // 使用求解
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int value = 0;
        for (int i = 0; i < arr.length; i++) {
            value ^= arr[i];
        }
        return value;
    }


    public static void main(String[] args) {
       // 任何数和0异或的任何数
        int[] arr = {4,1,2,1,2, 4, 5};
        OnlyOneNumber onlyOneNumber = new OnlyOneNumber();
        int i = onlyOneNumber.onlyOne07(arr);
        System.out.println(i);
    }
}
