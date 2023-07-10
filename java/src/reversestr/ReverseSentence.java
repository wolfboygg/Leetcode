package reversestr;

import java.util.HashMap;

/**
 * Input:
 * "I am a student."
 * <p>
 * Output:
 * "student. a am I"
 * <p>
 * 转换为字符数组，并且只能使用该字符数组的空间
 * 先进行单词的反转，然后再进行整体的反转
 */
public class ReverseSentence {
    public static String reverseSentence(String str) {
        int n = str.length();
        char[] chars = str.toCharArray();
        int i = 0;
        int j = 0; // 字符串末尾的index
        while (j <= n) {
            if (j == n || chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        reverse(chars, 0, n - 1);
        return new String(chars);
    }

    public static void reverse(char[] c, int i, int j) {
        while (i < j) {
            swap(c, i++, j--);
        }
    }

    private static void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }


    public static void main(String[] args) {
        String str = "I am a student.";
        System.out.println(reverseSentence(str));
//        HashMap

    }

    public void ad() {
        int i;
    }
}
