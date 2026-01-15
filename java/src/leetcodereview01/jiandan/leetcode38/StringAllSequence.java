package leetcodereview01.jiandan.leetcode38;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringAllSequence {

    public void getAllSequence01(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backTracking01(chars, new boolean[chars.length], new StringBuilder());
        System.out.println(ret.toString());
    }

    private void backTracking01(char[] chars, boolean[] marked, StringBuilder stringBuilder) {
        // 就是进行标记
        if (chars.length == stringBuilder.length()) {
            ret.add(stringBuilder.toString());
        }
        for (int i = 0; i < chars.length; i++) {
            if (marked[i]) {
                continue;
            }
            // 预防前一个相等
            if (i != 0 && !marked[i-1] && chars[i] == chars[i-1]) {
                continue;
            }
            marked[i] = true;
            stringBuilder.append(chars[i]);
            backTracking(chars, marked, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() -1);
            marked[i] = false;
        }
    }

    // 字符串的全排列
    public void getAllSequence02(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        char[] arr = str.toCharArray();
        boolean[] marked = new boolean[arr.length];
        backTracking02(arr, marked,  new StringBuilder());
        System.out.println(ret.toString());
    }

    private void backTracking02(char[] arr, boolean[] marked, StringBuilder sb) {
        if (sb.length() == arr.length) {
            ret.add(new String(sb.toString()));
        }
        // 不需要index,直接干就行了。使用循环
        for (int i = 0; i < arr.length; i++) {
            if (marked[i]) {
                continue;
            }
            marked[i] = true;
            sb.append(arr[i]);
            backTracking(arr, marked, sb);
            marked[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public void getAllSequence03(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        char[] arr = str.toCharArray();
        boolean[] mark = new boolean[arr.length];
        backTracking03(arr, mark, new StringBuilder());
        System.out.println(ret.toString());
    }

    private void backTracking03(char[] arr, boolean[] marked, StringBuilder sb) {
        if (arr.length == sb.length()) {
            ret.add(new String(sb.toString()));
        }
        for(int i = 0; i < arr.length; i++) {
            if (marked[i]) {
                continue;
            }
            marked[i] = true;
            sb.append(arr[i]);
            backTracking03(arr, marked, sb);
            marked[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public void getAllSequence04(String str) {
        char[] arr = str.toCharArray();
        boolean[] marked = new boolean[arr.length];
        backTracking04(arr, marked, new StringBuilder());
        System.out.println(ret.toString());
    }

    public void backTracking04(char[] arr, boolean[] marked, StringBuilder sb) {
        if (sb.length() == arr.length) {
            ret.add(new String(sb.toString()));
        }
        for (int i = 0; i < arr.length; i++) {
            if (marked[i]) {
                continue; // 这里不能return只能是continue
            }
            marked[i] = true;
            sb.append(arr[i]);
            backTracking04(arr, marked, sb);
            sb.deleteCharAt(sb.length() -1);
            marked[i] = false;
        }
    }

    public void getAllSequence05(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        char[] arr = str.toCharArray();
        boolean[] marked = new boolean[arr.length];
        backTracking05(arr, marked, new StringBuilder());
        System.out.println(ret.toString());
    }

    private void backTracking05(char[] arr, boolean[] marked, StringBuilder sb) {
        if (sb.length() == arr.length) {
            ret.add(new String(sb.toString()));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (marked[i]) {
                continue;
            }
            marked[i] = true;
            sb.append(arr[i]);
            backTracking05(arr, marked, sb);
            sb.deleteCharAt(sb.length() - 1);
            marked[i] = false;
        }
    }

    public void getAllSequence06(String str) {
        // 字符串的全排列 通过回溯的方式进行处理
        if (str == null || str.length() == 0) {
            return;
        }
        char[] chars = str.toCharArray();
        boolean[] mark = new boolean[chars.length];
        backTracking06(chars, mark, new StringBuilder());
        System.out.println(ret.toString());
    }

    public void backTracking06(char[] chars, boolean[] mark, StringBuilder sb) {
        // 本质还是对所有字符进行标记，然后在判断是否可以进行添加。直到和字符串的长度相等。
        if (sb.length() == chars.length) {
            ret.add(new String(sb.toString()));
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (mark[i]) {
                continue;
            }
            mark[i] = true; // 这个就控制了index
            sb.append(chars[i]);
            backTracking06(chars, mark, sb);
            sb.deleteCharAt(sb.length() - 1);
            mark[i] = false;
        }
    }

    public void getAllSequence07(String str) {
        // 获取字符串所有的序列的重新排序就是通过回溯的方式进行处理
        char[] chars = str.toCharArray();
        boolean[] mark = new boolean[chars.length];
        backTracking07(chars, mark, new StringBuilder());
        System.out.println(ret.toString());
    }

    public void backTracking07(char[] chars, boolean[] mark, StringBuilder sb) {
        if(sb.length() == chars.length) {
            ret.add(new String(sb));
        }
        for (int i = 0; i < chars.length; i++) {
            if (mark[i]) {
                continue;
            }
            sb.append(chars[i]);
            mark[i] = true;
            backTracking07(chars, mark, sb);
            mark[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public void getAllSequence08(String str) {
        // 字符串的全排列
        char[] charArr = str.toCharArray();
        boolean[] mark = new boolean[charArr.length];
        realAllSequence08(charArr, mark, new StringBuilder());
        System.out.println(ret.toString());
    }

    public void realAllSequence08(char[] arr, boolean[] mark, StringBuilder sb) {
        if (sb.length() == arr.length) {
            ret.add(new String(sb));
        }
        for (int i = 0; i < arr.length; i++) {
            if (mark[i]) {
                continue;
            }
            sb.append(arr[i]);
            mark[i] = true;
            realAllSequence08(arr, mark, sb);
            sb.deleteCharAt(sb.length() - 1);
            mark[i] = false;
        }
    }


    // 字符串的全排列
    public List<String> getAllSequence09(String str) {
        // 需要回溯
        if (str == null || str.length() == 0) {
            return new ArrayList<>();
        }
        char[] charArr = str.toCharArray();
        boolean[] mark = new boolean[charArr.length];
        backTracking09(charArr, mark, new StringBuilder());
        System.out.println(ret.toString());
        return ret;
    }

    public void backTracking09(char[] charArr, boolean[] mark, StringBuilder sb) {
        if (sb.length() == charArr.length) {
            ret.add(sb.toString());
            return;
        }

        for (int i = 0; i < charArr.length; i++) {
            if (mark[i]) {
                continue;
            }
            sb.append(charArr[i]);
            mark[i] = true;
            backTracking09(charArr, mark, sb);
            mark[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    // 字符串的全 排列
    public void getAllSequence10(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        // 使用回溯的方式进行遍历
        char[] charArr = str.toCharArray();
        boolean[] mark = new boolean[charArr.length];
        backTracking10(charArr, mark, new StringBuilder());
        System.out.println(ret.toString());
    }

    public void backTracking10(char[] charArr, boolean[] mark, StringBuilder sb) {
        if (charArr.length == sb.length()) {
            ret.add(sb.toString());
            return;
        }
        for (int i = 0; i < charArr.length; i++) {
            if (mark[i]) {
                continue;
            }
            mark[i] = true;
            sb.append(charArr[i]);
            backTracking10(charArr, mark, sb);
            sb.deleteCharAt(sb.length() - 1);
            mark[i] = false;
        }
    }


    public void getAllSequence11(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        boolean[] mark = new boolean[str.length()];
        backTracking11(str, mark, new StringBuilder());
        System.out.println(ret.toString());
    }

    public void backTracking11(String str, boolean[] mark, StringBuilder sb) {
        if (sb.length() == str.length()) {
            ret.add(new String(sb));
        }
        for (int i = 0; i < str.length(); i++) {
            if (mark[i]) {
                continue;
            }
            mark[i] = true;
            sb.append(str.charAt(i));
            backTracking11(str, mark, sb);
            sb.deleteCharAt(sb.length() - 1);
            mark[i] = false;
        }

    }

    public static void main(String[] args) {
        String str = "abc";
        StringAllSequence stringAllSequence = new StringAllSequence();
        stringAllSequence.getAllSequence11(str);
    }

    ArrayList<String> ret = new ArrayList<String>();

    private void getAllSequence(String str) {
        char[] array = str.toCharArray();
        Arrays.sort(array);
        backTracking(array, new boolean[array.length], new StringBuilder());
        System.out.println(ret.toString());
    }

    private void backTracking(char[] array, boolean[] marked, StringBuilder str) {
        if (array.length == str.length()) {
            ret.add(str.toString());
        }
        for (int i = 0; i < array.length; i++) {
            if (marked[i]) {
                continue;
            }
            if (i != 0 && !marked[i - 1] && array[i] == array[i - 1]) {
                continue;
            }
            marked[i] = true;
            str.append(array[i]);
            backTracking(array, marked, str);
            str.deleteCharAt(str.length() - 1);
            marked[i] = false;
        }
    }
}
