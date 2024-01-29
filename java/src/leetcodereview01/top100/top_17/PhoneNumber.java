package leetcodereview01.top100.top_17;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的组合，就是通过回溯的方法列出所有符合的字母组合
 */
public class PhoneNumber {

    public static List<String> ret = new ArrayList<>();
    public String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public void letterCombinations(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        dfs(str, 0, new StringBuilder());
    }

    public void dfs(String str, int index, StringBuilder sb) {
        if (sb.length() == str.length()) {
            ret.add(new String(sb.toString()));
            return;
        }
        // 这里开始获取对应的charArr
        char[] arr = map[str.charAt(index) -'0'].toCharArray();
        for (char c : arr) {
            sb.append(c);
            dfs(str, index + 1, sb);
            sb.deleteCharAt(sb.length() -1);
        }
    }

    public static void main(String[] args){
        PhoneNumber phoneNumber = new PhoneNumber();
         phoneNumber.letterCombinations("234");
        System.out.println(ret.toString());
    }
}
