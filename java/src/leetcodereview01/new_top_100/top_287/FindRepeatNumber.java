package leetcodereview01.new_top_100.top_287;


public class FindRepeatNumber {

    public int findRepeatNumber(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            // 需要注意的就是1 - n
            while(arr[i] != i + 1) {
                if (arr[arr[i] - 1] != arr[i]) { // 注意这个判断就行了
                    int temp = arr[i];
                    arr[i] = arr[temp -1];
                    arr[temp -1] = temp;
                } else {
                    return arr[i];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 4, 2};
        FindRepeatNumber findRepeatNumber = new FindRepeatNumber();
        int result = findRepeatNumber.findRepeatNumber(arr);
        System.out.println(result);
    }
}
