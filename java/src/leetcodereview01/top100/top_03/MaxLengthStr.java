package leetcodereview01.top100.top_03;

import java.util.HashMap;

/**
 * 无重复字符的最长子串
 */
public class MaxLengthStr {

    /**
     * 最长的无重复的字符串，使用动态规划进行求解
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
    public static void main(String[] args){
        String str = "abcabcbb";
        MaxLengthStr maxLengthStr = new MaxLengthStr();
        int value = maxLengthStr.maxLengthStr(str);
        System.out.println(value);
    }
}