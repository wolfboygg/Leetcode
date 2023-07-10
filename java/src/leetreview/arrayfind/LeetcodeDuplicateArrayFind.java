package leetreview.arrayfind;

/**
 * 出数组中任意一个重复的数字。
 */
public class LeetcodeDuplicateArrayFind {

    /**
     * 主要思路就是把数值放到对应的position位置如果发现相同了就说明当前数组重复了
     *
     * @param num
     * @return
     */
    public int duplicate(int[] num) {
        if (num.length == 0) {
            return -1;
        }
        // 进行数组循环然后进行交换
        for (int i = 0; i < num.length; i++) {
            while (num[i] != i) {
                // 交换直到对应
                if (num[i] == num[num[i]]) {
                    return num[i];
                }
                swap(num, num[i], i);
            }
        }
        return -1;
    }

    public void swap(int[] num, int currentValue, int currentPosition) {
        int temp = num[currentValue];
        num[currentValue] = num[currentPosition];
        num[currentPosition] = temp;
    }

    public static void main(String[] args) {
        LeetcodeDuplicateArrayFind leetcodeDuplicateArrayFind = new LeetcodeDuplicateArrayFind();
        int[] array = {2, 3, 1, 0, 2, 5, 3};
        int value = leetcodeDuplicateArrayFind.duplicate(array);
        System.out.println(value);
    }
}
