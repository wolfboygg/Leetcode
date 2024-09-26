package leetcodereview01.top100.top_169;


/**
 * 求众多数 就是求出现次数最多的数
 * 通过遍历的方式进行灵活赋值
 */
public class MajorityElement {

    public int majorNum(int[] arr) {
        int res = arr[0];
        int count = 0;
        for (int num : arr) {
            if (res == num) {
                count++;
            } else if (--count == 0) {
                res = num;
                count = 1;
            }
        }
        return res;
    }
    public static void main(String[] args){
        MajorityElement majorityElement = new MajorityElement();
        int[] num = {1,2, 1};
        System.out.println(majorityElement.majorNum(num));
    }
}
