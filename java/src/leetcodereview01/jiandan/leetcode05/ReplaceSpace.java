package leetcodereview01.jiandan.leetcode05;


public class ReplaceSpace {

    public void replaceSpace04(StringBuilder sb) {
        int originLength = sb.length();
        for (int i = 0; i < originLength; i++) {
            if (sb.charAt(i) == ' ') {
                sb.append("  ");
            }
        }
        int newLength = sb.length();
        int P1 = originLength - 1;
        int P2 = newLength - 1;
        while (P1 >= 0) {
            if (sb.charAt(P1) == ' ') {
                sb.setCharAt(P2--, '0');
                sb.setCharAt(P2--, '2');
                sb.setCharAt(P2--, '%');
            } else {
                sb.setCharAt(P2--, sb.charAt(P1));
            }
            P1--;
        }
        System.out.println(sb.toString());
    }

    public void replaceSpace01(StringBuilder sb) {
        if (sb == null || sb.length() == 0) {
            return;
        }
        int oldLength = sb.length();
        for (int i = 0; i < oldLength; i++) {
            if (sb.charAt(i) == ' ') {
                sb.append("  ");
            }
        }
        int newLength = sb.length();
        int P1 = oldLength - 1;
        int P2 = newLength - 1;
        while(P1 >= 0) {
            if (sb.charAt(P1) == ' ') {
                sb.setCharAt(P2--, '0');
                sb.setCharAt(P2--, '2');
                sb.setCharAt(P2--, '%');
            } else {
                sb.setCharAt(P2--, sb.charAt(P1));
            }
            P1--;
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("We are happy.");
        ReplaceSpace replaceSpace = new ReplaceSpace();
        replaceSpace.replaceSpace01(sb);
    }
}
