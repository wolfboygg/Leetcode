package leetcodereview01.new_top_100.top_03;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 */
public class MaxLengthStr {

    /**
     * 最长的无重复的字符串，使用动态规划进行求解
     *
     * @param str
     * @return
     */
    private int maxLengthStr(String str) {
        char[] charArr = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int index = 0;
        for (int i = 0; i < charArr.length; i++) {
            if (map.containsKey(charArr[i])) {
                index = Math.max(index, map.getOrDefault(charArr[i], -1));
            }
            map.put(charArr[i], i);
            maxLength = Math.max(maxLength, i - index); // 使用当前值-index即是滑动窗口的大小
        }
        return maxLength;
    }

    public int maxLengthStr01(String str) {
        // 采用滑动窗口的方式 但是要存一下index
        int index = -1;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                index = Math.max(index, map.get(str.charAt(i)));
            }
            map.put(str.charAt(i), i);
            max = Math.max(max, i - index);
        }
        return max;
    }

    public int maxLengthStr02(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();
        int startIndex = -1;
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                startIndex = Math.max(startIndex, map.getOrDefault(c, -1));
            }
            map.put(c, i);
            max = Math.max(max, i - startIndex);
        }
        return max;
    }

    public int maxLengthStr03(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        int index = -1;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                index = Math.max(index, map.getOrDefault(str.charAt(i), -1));
            }
            max = Math.max(max, i - index);
            map.put(str.charAt(i), i);
        }
        return max;
    }

    public int maxLengthStr04(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        int index = -1;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                index = Math.max(index, map.getOrDefault(str.charAt(i), -1));
            }
            max = Math.max(max, i - index);
            map.put(str.charAt(i), i);
        }
        return max;
    }

    public int maxLengthStr05(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int defaultIndex = -1;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                defaultIndex = Math.max(defaultIndex, map.getOrDefault(str.charAt(i), -1));
            }
            map.put(str.charAt(i), i);
            max = Math.max(max, i - defaultIndex);
        }
        return max;
    }

    public int maxLengthStr06(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();
        int defaultIndex = -1;
        int max = 0;
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (map.containsKey(charArray[i])) {
                defaultIndex = Math.max(defaultIndex, map.getOrDefault(charArray[i], -1));
            }
            map.put(charArray[i], i);
            max = Math.max(max, i - defaultIndex);
        }
        return max;
    }


    public int maxLengthStr07(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        int defaultIndex = -1;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                defaultIndex = Math.max(defaultIndex, map.getOrDefault(str.charAt(i), -1));
            }
            map.put(str.charAt(i), i);
            max = Math.max(max, i - defaultIndex);
        }
        return max;
    }


    public static void main(String[] args) {
        String str = "abcabcbb";
        MaxLengthStr maxLengthStr = new MaxLengthStr();
        int value = maxLengthStr.maxLengthStr06(str);
        System.out.println(value);
    }
}
