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
        int P1 = originLength -1;
        int P2 = newLength -1;
        while(P1 >=0) {
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

    public void replaceSpace05(StringBuilder sb) {
        int oldLength = sb.length() - 1;
        for (int i = 0; i <= oldLength; i++) {
            if (sb.charAt(i) == ' ') {
                sb.append(" ");
                sb.append(" ");
            }
        }
        int newLength = sb.length() - 1;
        while (oldLength >= 0) {
            if (sb.charAt(oldLength) == ' ') {
                sb.setCharAt(newLength--, '0');
                sb.setCharAt(newLength--, '2');
                sb.setCharAt(newLength--, '%');
            } else {
                sb.setCharAt(newLength--, sb.charAt(oldLength));
            }
            // 这里要弄对，最后再减
            oldLength--;
        }
        System.out.println(sb);
    }

    public void replaceSpace06(StringBuilder sb) {
        // 判断增加
        int oldLength = sb.length();
        for (int i = 0; i < oldLength; i++) {
            if (sb.charAt(i) == ' ') {
                sb.append("  ");
            }
        }
        int newLength = sb.length();
        int P1 = oldLength - 1;
        int P2 = newLength - 1;
        while(P1 >=0) {
            if (sb.charAt(P1) == ' ') {
                sb.setCharAt(P2--, '0');
                sb.setCharAt(P2--, '2');
                sb.setCharAt(P2--, '%');
            } else {
                sb.setCharAt(P2--, sb.charAt(P1));
            }
            P1--;
        }
        System.out.println(sb);
    }

    public void replaceSpace07(StringBuilder sb) {
        int oldLength = sb.length();
        for (int i = 0; i < oldLength; i++) {
            if (sb.charAt(i) == ' ') {
                sb.append("  ");
            }
        }
        int newLength = sb.length();
        int P1 = oldLength - 1;
        int P2 = newLength - 1;
        while(P1 >=0) {
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

    public void replaceSpace08(StringBuilder sb) {
        // 两个指针进行处理
        int P1 = sb.length() - 1;
        for (int i = 0; i <= P1; i++) {
            if (sb.charAt(i) == ' ') {
                sb.append("  ");
            }
        }
        int P2 = sb.length() - 1;
        while(P1 < P2) {
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
        replaceSpace.replaceSpace08(sb);
    }
}
