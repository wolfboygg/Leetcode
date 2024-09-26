package leetcodereview01.top100.top_136;
public class OnlyOneNumber {

    public int findOnlyNum(int[] arr) {
        // 找出数组中唯一的单个数字，使用异或的方式
        int res = 0;
        for (int num : arr) {
            res ^= num;
        }
        return res;
    }

    public int findOnlyNum01(int[] num) {
        // 找到只出现一次的
        if (num == null || num.length == 0) {
            return -1;
        }
        int value = 0;
        for (int item : num) {
            value ^= item;
        }
        return value;
    }

    public static void main(String[] args){
      int[] arr = {4,1,2,1,2};
        OnlyOneNumber onlyOneNumber = new OnlyOneNumber();
        System.out.println(onlyOneNumber.findOnlyNum01(arr));
    }
}
