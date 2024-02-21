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

    public void reverse03(String str) {
        // 先找到空格，然后进行翻转
        char[] arr = str.toCharArray();
        int n = str.length();
        int i = 0;
        int j = 0;
        while(j <= n) { // 这里为了-1
            if (j == n || arr[j] == ' ') {
                // 这里就要去翻转
                reverseWork03(arr, i, j-1);
                i = j+1;
            }
            j++;
        }
        // 然后再整体翻转
        reverseWork03(arr, 0, n-1);
        System.out.println(new String(arr));
    }

    public void reverseWork03(char[] arr, int start, int end) {
        while(start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public void reverse04(String str) {
        // 这种操作就是通过找到每个单词进行翻转，最后再整体翻转
        char[] chars = str.toCharArray();
        int n = chars.length;
        int i = 0;
        int j = 0;
        while(j <= n) {
            if (j == n || chars[j] == ' ') {
                // 翻转单词
                reversework04(chars, i , j - 1);
                i = j+1;
            }
            j++;
        }
        reversework04(chars, 0, chars.length -1);
        System.out.println(Arrays.toString(chars));
    }

    private void reversework04(char[] chars, int start, int end) {
        while(start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    // 翻转字符串
    public void reverse05(String str) {
        // 按空格翻转，最后再整体翻转
        char[] chars = str.toCharArray();
        System.out.println(chars.length);
        System.out.println(Arrays.toString(chars));
        int P1 = 0;
        int P2 = 0;
        for (int i = 0; i <= chars.length; i++) {
            if (P2 == chars.length || chars[P2] == ' ' ) {
               // 这个时候需要翻转
                reverseWork05(chars, P1, P2-1);
                P1 = P2;
            }
            P2++;
        }
        // 整体进行翻转
        reverseWork05(chars, 0, chars.length - 1);
        System.out.println(chars.length);
        System.out.println(Arrays.toString(chars));
    }

    public void reverseWork05(char[] arr, int start, int end) {
        while(start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // 旋转字符串 先单个单词进行旋转，最后再整体旋转
    public void reverse06(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        int P1 = 0;
        int P2 = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i <= chars.length; i++) {// 让指针指向最后一个字符
            if (P2 == chars.length || chars[i] == ' ') {
                reverseWord06(chars, P1, P2 - 1);
                P1 = P2;
            }
            P2++;
        }
        // 整体进行翻转
        reverseWord06(chars, 0, chars.length - 1);
        System.out.println(Arrays.toString(chars));
    }

    public void reverseWord06(char[] chars, int start, int end) {
        System.out.println("start:" + start + "->end:" + end);
        while(start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String str = "I am a student.";
        ReverseSentence reverseSentence = new ReverseSentence();
        reverseSentence.reverse06(str);
    }
}
