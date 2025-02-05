package leetcodereview01.new_top_100.top_17;

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
        char[] arr = map[str.charAt(index) - '0'].toCharArray();
        for (char c : arr) {
            sb.append(c);
            dfs(str, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // 打印电话号码 通过回溯的方式进行处理
    public void letterCombinations01(String str) {
        // 主要就是通过一个字符串数组查找对应的String ，然后进行添加删除操作
        if (str == null || str.length() == 0) {
            return;
        }
        dfs01(str, 0, new StringBuilder());
    }

    public void dfs01(String str, int index, StringBuilder sb) {
        if (sb.length() == str.length()) {
            ret.add(new String(sb.toString()));
        }
        // 先找到 在进行遍历
        char[] chars = map[str.charAt(index) - '0'].toCharArray();
        for (char c : chars) {
            sb.append(c);
            dfs(str, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // 打印电话号码
    public void letterCombinations02(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        char[] charArr = str.toCharArray();
        traversal(charArr, 0, new StringBuilder());
    }

    public void traversal(char[] charArr, int index, StringBuilder sb) {
        if (sb.length() == charArr.length) {
            ret.add(new String(sb.toString()));
            return;
        }
        char[] letterStr = map[charArr[index] - '0'].toCharArray();
        for (char c : letterStr) {
            sb.append(c);
            traversal(charArr, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public List<String> letterCombinations03(String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList<>();
        }
        traversal03(str, 0, new StringBuilder());
        return ret;
    }

    public void traversal03(String str, int index, StringBuilder sb) {
        if (sb.length() == str.length()) {
            ret.add(new String(sb.toString()));
            return;
        }
        String letters = map[str.charAt(index) - '0'];
        char[] charArray = letters.toCharArray();
        for (char c : charArray) {
            sb.append(c);
            traversal03(str, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> letterCombinations04(String str) {
        // 字符组合
        if (str == null) {
            return null;
        }
        traversal04(str, 0, new StringBuilder());
        return ret;
    }

    public void traversal04(String str, int index, StringBuilder sb) {
        if (sb.length() == str.length()) {
            ret.add(new String(sb.toString()));
            return;
        }
        char[] charArr = map[str.charAt(index) - '0'].toCharArray();
        for (char c : charArr) {
            sb.append(c);
            traversal04(str, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);// 遍历完成之后要删除
        }
    }


    public static void main(String[] args) {
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.letterCombinations04("234");
        System.out.println(ret.toString());
    }
}
