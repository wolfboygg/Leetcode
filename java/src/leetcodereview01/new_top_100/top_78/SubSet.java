package leetcodereview01.new_top_100.top_78;

import java.util.ArrayList;
import java.util.List;

/** 子集问题 */
public class SubSet {

    private List<List<Integer>> ret = new ArrayList<>();


    public List<List<Integer>> calculate01(int[] num) {
        if (num == null || num.length == 0) {
            return ret;
        }
        dfs01(0, num, new ArrayList<>());
        return ret;
    }

    public void dfs01(int i, int[] nums, List<Integer> list) {
        if (i == nums.length) {
            ret.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        dfs01(i + 1, nums, list);
        list.remove(list.size() - 1);
        dfs01(i + 1, nums, list);
    }



    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3};
        SubSet subSet = new SubSet();
        List<List<Integer>> list = subSet.calculate01(nums);
        System.out.println(list.toString());
    }


}
