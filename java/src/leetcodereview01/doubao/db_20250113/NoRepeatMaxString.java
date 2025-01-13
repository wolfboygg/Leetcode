package leetcodereview01.doubao.db_20250113;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复的最长字串
 */
public class NoRepeatMaxString {

    public int getNoRepeatMaxStr(String str) {
        // 分析一下就是通过存储字符串是否有相同的进行判断
        if (str == null || str.length() == 0) {
            return -1;
        }
        char[] charArray = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int index = -1;
        int max = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (map.containsKey(charArray[i])) {
                index = Math.max(index, map.getOrDefault(charArray[i], -1));
            }
            map.put(charArray[i], i);
            max = Math.max(max, i - index);
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        NoRepeatMaxString noRepeatMaxString = new NoRepeatMaxString();
        int noRepeatMaxStr = noRepeatMaxString.getNoRepeatMaxStr(str);
        System.out.println(noRepeatMaxStr);
    }

}
