package replacespace;

/**
 * 替换字符串中的空格
 * 将一个字符串中的空格替换成 "%20"。
 * "A B" -> A%20B
 * 遍历原来的字符串，发现空格添加两个空格
 * 然后使用两个指针 P1 指向原来字符串的末尾 P2指向添加之后的字符串的末尾，然后进行遍历添加
 */


public class ReplaceSpace {

    public static String replaceSpace(StringBuffer str) {
        int P1 = str.length() - 1;
        for (int i = 0; i <= P1; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        int P2 = str.length() - 1;

        while (P1 >= 0 && P2 >= P1) {
            char c = str.charAt(P1--);
            if (c == ' ') {
                str.setCharAt(P2--, '0');
                str.setCharAt(P2--, '2');
                str.setCharAt(P2--, '%');
            } else {
                str.setCharAt(P2--, c);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("A B ");
        System.out.println(replaceSpace(stringBuffer));
    }
}
