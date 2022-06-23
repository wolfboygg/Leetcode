package leetcode01.replacespace;

/**
 * 替换空格，请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 解题思路通过：使用两个指针进行遍历添加，都在原来字符串的基础上进行处理
 */
public class TestReplaceSpace {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("A B ");
        replaceSpace(stringBuffer);
        System.out.println(stringBuffer.toString());
    }

    public static void replaceSpace(StringBuffer sb) {
        if (sb == null) {
            return;
        }
        // 进行遍历sb。发现有个字符是空格进行添加
        int P1 = sb.length() - 1;
        for (int i = 0; i <= P1; i++) {
            if (sb.charAt(i) == ' ') {
                sb.append("  ");
            }
        }
        int P2 = sb.length() - 1;
        // 然后这个时候进行指针处理
        while (P1 > 0 && P2 >= P1) {
            char c = sb.charAt(P1--);
            if (c == ' ') {
                // 进行拷贝
                sb.setCharAt(P2--, '0');
                sb.setCharAt(P2--, '2');
                sb.setCharAt(P2--, '%');
            } else {
                sb.setCharAt(P2--, c);
            }
        }
    }
}
