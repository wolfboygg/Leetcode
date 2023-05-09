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

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        System.out.println(permutation.permutation("abc").toString());
    }
}
