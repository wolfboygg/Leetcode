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

    public static void main(String[] args) {
        String str = "I am a student.";
        ReverseSentence reverseSentence = new ReverseSentence();
        reverseSentence.reverse(str);
    }
}
