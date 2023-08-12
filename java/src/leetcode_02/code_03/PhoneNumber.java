package leetcode_02.code_03;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumber {
    public static void main(String[] args) {
        List<String> strings = new PhoneNumber().letterCombinations("213");
//        System.out.println(strings.toString());
//        System.out.println(~1);
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(binarySearch(arr, arr.length, 9));
    }


    public List<String> letterCombinations(String input) {
        List<String> list = new ArrayList<>();
        if (input == null || input.length() == 0) {
            return list;
        }
        String[] letterStrs = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sb = new StringBuilder();
        backTracking(input, letterStrs, 0, list, sb);
        return list;
    }

    private void backTracking(String input, String[] letterStrs, int num, List<String> list, StringBuilder sb) {
        if (num == input.length()) {
            list.add(sb.toString());
            return;
        }
        String str = letterStrs[input.charAt(num) - '0'];
        if (str.length() == 0) {
            backTracking(input, letterStrs, num + 1, list, sb);
        } else {
            for (int i = 0; i < str.length(); i++) {
                sb.append(str.charAt(i));
                backTracking(input, letterStrs, num + 1, list, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    static int binarySearch(int[] array, int size, int value) {
        int lo = 0;
        int hi = size - 1;

        while (lo <= hi) {
            final int mid = (lo + hi) >>> 1;
            final int midVal = array[mid];

            if (midVal < value) {
                lo = mid + 1;
            } else if (midVal > value) {
                hi = mid - 1;
            } else {
                return mid;  // value found
            }
        }
        // 得到的是最大的位置
        // 0000 0110
        // 1111 1001
        // 1111 1000
        // 1000 0111
        System.out.println(lo);
        System.out.println(~lo);
        return ~lo;  // value not present
    }

}
