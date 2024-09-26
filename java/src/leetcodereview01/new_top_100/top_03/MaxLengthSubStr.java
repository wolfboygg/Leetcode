package leetcodereview01.new_top_100.top_03;

import leetcodereview01.jiandan.leetcode63.MaxGP;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复最长字串
 */
public class MaxLengthSubStr {
    public int maxLengthSubStr(String str) {
        if (str == null || str.isEmpty()) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();
        int minIndex = -1;
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                minIndex = Math.max(minIndex, map.get(str.charAt(i)));
            }
            map.put(str.charAt(i), i);
            res = Math.max(res, i - minIndex);
        }
        return res;
    }


    public static void main(String[] args) {
        String str = "abcabcbb";
        MaxLengthSubStr maxLengthSubStr = new MaxLengthSubStr();
        int result = maxLengthSubStr.maxLengthSubStr(str);
        System.out.println(result);
    }
}
