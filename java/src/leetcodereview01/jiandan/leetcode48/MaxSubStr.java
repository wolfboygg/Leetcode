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

    public int findMaxLength01(String str) {
        int temp = 0;
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            int j = map.getOrDefault(str.charAt(i), -1);
            map.put(str.charAt(i), i);
            temp = temp < i - j ? temp + 1 : j - i;
            res = Math.max(res, temp);
        }
        return res;
    }

    public int findMaxLength02(String str) {
        // 使用滑动窗口的方式进行解决
        HashMap<Character, Integer> map = new HashMap<>();
        int index = -1;
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                index = Math.max(index, map.get(str.charAt(i)));
            }
            map.put(str.charAt(i), i);
            // 判断最大的res
            res = Math.max(res, i - index);
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "arabcacfr";
        MaxSubStr maxSubStr = new MaxSubStr();
        System.out.println(maxSubStr.findMaxLength01(str));
    }
}
