package leetreview.replacesapce;

/**
 * %替换空格
 */
public class ReplaceSpace {

    /**
     * 替换空格就是通过转换字符数组进行扩展字符数组然后进行拷贝
     * 选择str就是为了可以进行扩展
     * @param str
     * @return
     */
    public String replace(StringBuilder str) {// 在原来不变的情况下进行处理
        int P1 = str.length() - 1;
        for (int i = 0; i <= P1; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");// 后面拼接两个空格
            }
        }
        int P2 = str.length() - 1;
        while (P2 >= P1 && P1 >= 0) {
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
        StringBuilder str = new StringBuilder("We are happy");
        ReplaceSpace replaceSpace = new ReplaceSpace();
        String replace = replaceSpace.replace(str);
        System.out.println(replace);
    }

}
