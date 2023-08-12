package leetcodereview01.jiandan.leetcode48;

import java.util.HashMap;

public class MaxSubStr {

    public int findMaxSubStrLength(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int temp = 0;
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            int j = map.getOrDefault(str.charAt(i), -1);
            map.put(str.charAt(i), i);
            temp = temp < i - j ? temp + 1 : j - i;
            res = Math.max(res, temp);
        }
        return res;
    }

    public int findMaxLength(String str) {
        int temp = 0;
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            int j = map.getOrDefault(str.charAt(i), -1);
            map.put(str.charAt(i), i);
            temp = temp < i - j ? temp + 1 : j - i;
            res = Math.max(temp, res);
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "arabcacfr";
        MaxSubStr maxSubStr = new MaxSubStr();
        System.out.println(maxSubStr.findMaxLength(str));
    }
}