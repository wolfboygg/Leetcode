package leetcodereview01.new_top_100.top_49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/** 字母异或分组 */
public class GroupLetter {

    public void groupLetter01(String[] str) {
        if (str == null || str.length == 0) {
            return;
        }
        // 使用排序的方式进行处理的
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            char[] charArray = str[i].toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            ArrayList<String> list = map.getOrDefault(key, new ArrayList<>());;
            list.add(str[i]);
            map.put(key, list);
        }
        System.out.println(map.values().toString());
    }

    public static void main(String[] args) {
        String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupLetter groupLetter = new GroupLetter();
        groupLetter.groupLetter01(strs);
    }
}
