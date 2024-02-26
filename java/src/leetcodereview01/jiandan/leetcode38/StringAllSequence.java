package leetcodereview01.jiandan.leetcode38;



import java.util.ArrayList;
import java.util.Arrays;
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

    public static void main(String[] args) {
        String str = "abc";
        StringAllSequence stringAllSequence = new StringAllSequence();
        stringAllSequence.getAllSequence06(str);
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
