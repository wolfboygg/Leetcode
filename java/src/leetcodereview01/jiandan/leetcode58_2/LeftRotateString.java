package leetcodereview01.jiandan.leetcode58_2;


import java.util.Arrays;

public class LeftRotateString {

    public void rotate(String str, int n) {
        char[] array = str.toCharArray();
        reverse(array, 0, n - 1);
        reverse(array, n, array.length - 1);
        reverse(array, 0, array.length - 1);
        System.out.println(new String(array));
    }

    private void reverse(char[] array, int left, int right) {
        while (left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public void rotate02(String str, int n) {
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        System.out.println(new String(chars));
    }

    public void rotate03(String str, int n) {
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
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
        reverse(chars, 0, str.length() - 1);
        System.out.println(Arrays.toString(chars));
    }

    public void rotate06(String str, int k) {
        // 旋转字符串
        // 前反转 后反转 整体反转
        char[] charArr = str.toCharArray();
        reverse06(charArr, 0, k - 1);
        reverse06(charArr, k, charArr.length - 1);
        reverse06(charArr, 0, charArr.length -1);
        System.out.println(new String(charArr));
    }

    public void reverse06(char[] charArr, int start, int end) {
        while (start <= end) {
            char temp = charArr[start];
            charArr[start] = charArr[end];
            charArr[end] = temp;
            start++;
            end--;
        }
    }

    // 旋转字符串以k为位置进行旋转
    public void rotate07(String str, int k) {
        char[] charArr = str.toCharArray();
        reverse07(charArr, 0, k - 1);
        reverse07(charArr, k, charArr.length - 1);
        reverse07(charArr, 0, charArr.length -1);
        System.out.println(Arrays.toString(charArr));
    }

    public void reverse07(char[] charArr, int start, int end) {
        while(start <= end) {
            char temp = charArr[start];
            charArr[start] = charArr[end];
            charArr[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate08(String str, int k) {
        // 旋转字符串
        if (str == null || str.length() == 0) {
            return;
        }
        char[] charArr = str.toCharArray();
        reverse08(charArr, 0, k - 1);
        reverse08(charArr, k, charArr.length - 1);
        reverse08(charArr, 0 , charArr.length - 1);
        System.out.println(new String(charArr).toString());
    }

    public void reverse08(char[] charArr, int start, int end) {
        while(start <= end) {
            char temp = charArr[start];
            charArr[start] = charArr[end];
            charArr[end] = temp;
            start++;
            end--;
        }
    }



    public static void main(String[] args) {
        String str = "abcdefg";
        LeftRotateString leftRotateString = new LeftRotateString();
        leftRotateString.rotate08(str, 2);
    }
}
