package leet38;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {
    private ArrayList<String> ret = new ArrayList<>();

    // 通过排列组合方法进行处理
    public ArrayList<String> permutation(String str) {
        if (str == null) {
            return null;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backtracking(chars, new boolean[chars.length], new StringBuilder());
        return ret;
    }

    private void backtracking(char[] chars, boolean[] hasUsed, StringBuilder str) {
        if (str.length() == chars.length) {
            ret.add(str.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (hasUsed[i]) {
                continue;
            }
            // 这个是为了防止出现字符串中相等的字符
            if (i != 0 && !hasUsed[i - 1] && chars[i] == chars[i - 1]) {
                System.out.println(i);
                System.out.println(hasUsed[i - 1]);
                System.out.println(chars[i]);
                System.out.println(chars[i-1]);
                continue;
            }
            hasUsed[i] = true;
            str.append(chars[i]);
            System.out.println(chars[i]);
            backtracking(chars, hasUsed, str);
            System.out.println(str.charAt(str.length() -1));
            str.deleteCharAt(str.length() - 1);
            hasUsed[i] = false;
        }
    }

    public ArrayList<String> permutation01(String str) {
        // 使用回溯法进行处理
        if (str == null || str.length() == 0) {
            return ret;
        }
        char[] arr = str.toCharArray();
        backTracking01(arr, new boolean[arr.length], new StringBuilder());
        return ret;
    }

    public void backTracking01(char[] arr, boolean[] mark, StringBuilder sb) {
        if (sb.length() == arr.length) {
            ret.add(new String(sb.toString()));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (mark[i]) { // 记住这个要跳过，打过标记的就不要再走了
                continue;
            }
            if (i != 0 && !mark[i-1] && arr[i] == arr[i-1]) {
                continue;
            }
            mark[i] = true;
            sb.append(arr[i]);
            backTracking01(arr, mark, sb);
            mark[i] = false;
            sb.deleteCharAt(sb.length() -1);
        }
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        System.out.println(permutation.permutation01("abc").toString());
    }
}
