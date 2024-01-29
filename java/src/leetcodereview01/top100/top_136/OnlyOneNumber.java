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

    public static void main(String[] args){
      int[] arr = {4,1,2,1,2};
        OnlyOneNumber onlyOneNumber = new OnlyOneNumber();
        System.out.println(onlyOneNumber.findOnlyNum(arr));
    }
}
