package leetcodereview01.top100.top_338;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberBitCount {
    /**
     * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
     * // 10 1010
     * // 9  1001 1000
     */
    public List<Integer> convertBit(int num) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            int count = 0;
            int temp = i;
            while(temp != 0) {
                temp &= temp -1;
                count++;
            }
            list.add(count);
        }
        return list;
    }
    public static void main(String[] args){
        int num = 5; // [0,1,1,2,1,2]
        NumberBitCount numberBitCount = new NumberBitCount();
        List ints = numberBitCount.convertBit(num);
        System.out.println(ints.toString());
    }
}
