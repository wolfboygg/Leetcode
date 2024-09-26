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

    public List<String> findAllSequence01(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        boolean[] marked = new boolean[str.length()];
        List<String> ret = new ArrayList<>();
        realFind01(str, marked, ret, new StringBuilder());
        return ret;
    }

    public void realFind01(String str, boolean[] marked, List<String> list, StringBuilder sb) {
        if (sb.length() == str.length()) {
            list.add(new String(sb.toString()));
            return;
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (marked[i]) {
                continue;
            }
            marked[i] = true;
            sb.append(str.charAt(i));
            realFind01(str, marked,  list, sb);
            marked[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    public static void main(String[] args){
      String str = "123";
        AllSequence allSequence = new AllSequence();
        List<String> ret = allSequence.findAllSequence01(str);
        System.out.println(ret.toString());
    }
}
