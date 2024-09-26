package leetcodereview01.top100.top_46;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有的全部排列
 */
public class AllSequence {

    public List<String> findAllSequence(String str) {
        // 找到所有的全部的排列
        char[] charArray = str.toCharArray();
        boolean[] marked = new boolean[charArray.length];
        List<String> ret = new ArrayList<>();
        realFind(charArray, marked, ret, new StringBuilder());
        return ret;
    }

    private void realFind(char[] charArray, boolean[] marked, List<String> ret, StringBuilder sb) {
        if (sb.length() == charArray.length) {
            ret.add(new String(sb.toString()));
        }
        for (int i = 0; i < charArray.length; i++) {
            if (marked[i]) {
                continue;
            }
            marked[i] = true;
            sb.append(charArray[i]);
            realFind(charArray, marked, ret, sb);
            sb.deleteCharAt(sb.length() - 1);
            marked[i] = false;
        }
    }

    public static void main(String[] args){
      String str = "123";
        AllSequence allSequence = new AllSequence();
        List<String> ret = allSequence.findAllSequence(str);
        System.out.println(ret.toString());
    }
}
