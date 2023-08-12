package leetcodereview01.jiandan.leetcode58_1;


import java.util.Arrays;

public class ReverseSentence {

    public String reverse(String str) {
        char[] array = str.toCharArray();
        int n = array.length;
        int i = 0;
        int j = 0;
        while (j <= n) {
            if (j == n || array[j] == ' ') {
                // 找到了单词，进行反转
                reverseWork(array, i, j - 1); // 上面为n 就是为了 这里减1
                i = j + 1;
            }
            j++;
        }
        // 在整体反转
        reverseWork(array, 0, array.length-1);
        System.out.println(new String(array));
        return "";
    }

    public void reverseWork(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    // 翻转就是找到空格，单个单词进行翻转，然后在进行整体翻转，注意边加问题
    public void reverse02(String str) {
        // 找到空格之后进行翻转
        char[] chars = str.toCharArray();
        int i = 0;
        int j = 0;
        int n = chars.length;
        while(j <= n) {
            if (j == n || chars[j] == ' ') {
                // 找到了位置进行翻转
                reverseWork02(chars, i, j -1);
                i = j + 1;
            }
            j++;
        }
        // 循环完成之后整体进行翻转
        reverseWork02(chars, 0, chars.length-1);
        System.out.println(new String(chars));
    }

    private void reverseWork02(char[] chars, int i, int j) {
        while(i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        String str = "I am a student.";
        ReverseSentence reverseSentence = new ReverseSentence();
        reverseSentence.reverse(str);
    }
}
