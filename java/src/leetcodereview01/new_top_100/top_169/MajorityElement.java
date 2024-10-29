package leetcodereview01.new_top_100.top_169;

/**
 * 多数元素
 */
public class MajorityElement {

    public int majorityElement(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        // 通过
        int num = arr[0];
        int count = 0;
        for (int i : arr) {
            if (num == i) {
                count++;
            } else if (--count == 0) {
                num = i;
                count = 1;
            }
        }
        return num;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 1, 1, 1, 2, 2, 1, 1};
        MajorityElement bean = new MajorityElement();
        int i = bean.majorityElement(arr);
        System.out.println(i);
    }

}
