package leetcodereview01.jiandan.leetcode05;


public class ReplaceSpace {

    public void replaceSpace(StringBuilder sb) {
        int length = sb.length();
        for (int i = 0; i < length; i++) {
            if (sb.charAt(i) == ' ') {
                sb.append(" ");
                sb.append(" ");
            }
        }
        int newLength = sb.length() - 1;

        while (--length >= 0) {
            if (sb.charAt(length) == ' ') {
                sb.setCharAt(newLength--, '0');
                sb.setCharAt(newLength--, '2');
                sb.setCharAt(newLength--, '%');
            } else {
                sb.setCharAt(newLength--, sb.charAt(length));
            }
        }

        System.out.println(sb);
    }


    public void replaceSpace02(StringBuilder sb) {
        int P1 = sb.length();
        for (int i = 0; i < P1; i++) {
            if (sb.charAt(i) == ' ') {
                sb.append(" ");
                sb.append(" ");
            }
        }
        int P2 = sb.length() - 1;
        while (--P1 >= 0) {
            if (sb.charAt(P1) == ' ') {
                sb.setCharAt(P2--, '0');
                sb.setCharAt(P2--, '2');
                sb.setCharAt(P2--, '%');
            } else {
                sb.setCharAt(P2--, sb.charAt(P1));
            }
        }
        System.out.println(sb.toString());
    }

    public void replaceSpace03(StringBuilder sb) {
        int P1 = sb.length();
        for (int i = 0; i < P1; i++) {
            if (sb.charAt(i) == ' ') {
                sb.append(" ");
                sb.append(" ");
            }
        }
        int P2 = sb.length()-1;
        while (--P1 >= 0) {
            if (sb.charAt(P1) == ' ') {
                sb.setCharAt(P2--, '0');
                sb.setCharAt(P2--, '2');
                sb.setCharAt(P2--, '%');
            } else {
                sb.setCharAt(P2--, sb.charAt(P1));
            }
        }
        System.out.println(sb.toString());
    }


    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("We are happy.");
        ReplaceSpace replaceSpace = new ReplaceSpace();
        replaceSpace.replaceSpace03(sb);
    }
}
