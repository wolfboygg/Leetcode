package leetcodereview01.jiandan.leetcode45;


import java.util.Arrays;
import java.util.Comparator;

public class PrintMinNumber {
    public void printMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int n = arr.length;
        String[] num = new String[n];
        for (int i = 0; i < n; i++) {
            num[i] = arr[i] + "";
        }
        Arrays.sort(num, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        System.out.println(Arrays.toString(num));
        String ret = "";
        for (String s : num) {
            ret += s;
        }
        System.out.println(ret);
    }

    public void printMin01(int[] arr) {
        // 先转换为数组
        if (arr == null || arr.length == 0) {
            return;
        }
        String[] num = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
              num[i] = arr[i] + "";
        }
        Arrays.sort(num, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        String ret = "";
        for (String s : num) {
            ret += s;
        }
        System.out.println(ret);
    }

    // 主要思路就是通过比较进行排序
    public void printMin02(int[] arr) {
        // 转换为String 数组
        String[] num = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            num[i] = arr[i] + "";
        }
        Arrays.sort(num, (o1, o2) -> (o1 + o2).compareTo(o2+ o1));
        StringBuilder sb = new StringBuilder();
        for (String s : num) {
            sb.append(s);
        }
        System.out.println(sb.toString());
    }


    public static void main(String[] args) {
        int[] arr = {3, 32, 321};
        new PrintMinNumber().printMin02(arr);
    }
}
