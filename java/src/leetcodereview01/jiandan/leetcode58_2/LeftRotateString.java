package leetcodereview01.jiandan.leetcode58_2;


import java.util.Arrays;

public class LeftRotateString {

    public void rotate(String str, int n) {
        char[] array = str.toCharArray();
        reverse(array, 0, n-1);
        reverse(array, n, array.length -1);
        reverse(array, 0, array.length -1);
        System.out.println(new String(array));
    }

    private void reverse(char[] array, int left, int right) {
        while(left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public void rotate02(String str, int n) {
        char[] chars = str.toCharArray();
        reverse(chars, 0, n-1);
        reverse(chars, n, chars.length -1);
        reverse(chars, 0, chars.length -1);
        System.out.println(new String(chars));
    }

    public void rotate03(String str, int n) {
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n , chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        System.out.println(Arrays.toString(chars));
    }

    public void rotate04(String str, int n) {
        if (str == null || str.length() == 0) {
            return;
        }
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        System.out.println(Arrays.toString(chars));
    }

    public void rotate05(String str, int n) {
        // 以n开始旋转
        if (str == null || str.length() == 0) {
            return;
        }
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, str.length() - 1);
        reverse(chars, 0, str.length() -1);
        System.out.println(Arrays.toString(chars));
    }

    public static void main(String[] args) {
        String str = "abcdefg";
        LeftRotateString leftRotateString = new LeftRotateString();
        leftRotateString.rotate05(str, 2);
    }
}
