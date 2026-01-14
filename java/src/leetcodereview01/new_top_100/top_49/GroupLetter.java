package leetcodereview01.new_top_100.top_49;

import java.util.*;

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

    public void groupLetter02(String[] strs) {
        if (strs == null) {
            return;
        }
        Map<String, List<String>> result = new HashMap<>();
        // 首先排序找到key，然后在进行处理
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            List<String> list = result.getOrDefault(key, new ArrayList<>());
            list.add(str);
            result.put(key, list);
        }
        System.out.println(result.values());
    }


    public static void main(String[] args) {
        String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupLetter groupLetter = new GroupLetter();
        groupLetter.groupLetter02(strs);
    }
}
