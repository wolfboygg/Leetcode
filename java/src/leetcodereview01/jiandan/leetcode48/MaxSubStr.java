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

    public int findMaxLength03(String str) {
        // 最长的子串 使用动态规划实现
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int index = -1;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                index = Math.max(index, map.getOrDefault(ch, -1)); // 拿到最新的index
            }
            map.put(ch, i);
            max = Math.max(max, i - index);
        }
        return max;
    }

    public int findMaxLength04(String str) {
        // 使用滑动窗口的算法进行处理 找到最大的位置进行处理
        int max = 0;
        int index = -1; // 从-1开始正好走一个为1
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                // 找到最大的index  0和index  所以还是找到最大的哪个index 这样就构成了窗口
                index = Math.max(map.getOrDefault(c, -1), index);
            }
            System.out.println("index:" + index);
            map.put(c, i);
            max = Math.max(max, i - index);
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "arabcacfr";
        MaxSubStr maxSubStr = new MaxSubStr();
        System.out.println(maxSubStr.findMaxLength04(str));


        String str2 = "https://mdp-credit-api-overseas.immomo.com";
        System.out.println(str2.contains("api.meowapp.world/v1/session"));

    }
}
