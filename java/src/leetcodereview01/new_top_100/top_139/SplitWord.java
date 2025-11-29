package leetcodereview01.new_top_100.top_139;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/** 单词拆分 */
public class SplitWord {


    public boolean valid01(String str, List<String> list) {
        if (str == null) {
            return false;
        }
        HashSet<String> set = new HashSet<>(list);
        boolean[] dp = new boolean[str.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= str.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(str.substring(j, i))) {// 这里就应该是到i
                    dp[i] = true;
                }
            }
        }
        return dp[str.length()];
    }

    public static void main(String[] args) {
        String str =  "leetcodee";
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        SplitWord splitWord = new SplitWord();
        boolean result = splitWord.valid01(str, list);
        System.out.println(result);
    }
}
