package leetcodereview01.new_top_100.top_647;

public class HWString {

    private int left = 0;
    private int len = 0;

    private String calculateHwCount(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        for (int i = 0; i < str.length(); i++) {
            findHw(str, i, i);
            findHw(str, i - 1, i);
        }
        return str.substring(left, left + len);
    }

    public void findHw(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            if (right - left + 1 > len) {
                this.left = left;
                this.len = right - left + 1;
            }
            left--;
            right++;
        }
    }

    public String calculateHwCount01(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            findHw01(charArray, i, i);
            findHw01(charArray, i - 1, i);
        }
        return str.substring(left, len);
    }

    public void findHw01(char[] charArr, int left, int right) {
        while(left >= 0 && right < charArr.length && charArr[left] == charArr[right]) {
            if (right - left + 1 > len) {
                this.left = left;
                this.len = right - left + 1;
            }
            left--;
            right++;
        }
    }

    public String calculateHwCount02(String str) {
        if (str == null) {
            return "";
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            findHw02(charArray, i, i);
            findHw02(charArray, i - 1, i);
        }
        return str.substring(left, len);
    }


    public void findHw02(char[] charArr, int left, int right) {
        while(left >= 0 && right < charArr.length && charArr[left] == charArr[right]) {
            if (len < right - left + 1) {
                len = right - left + 1;
                this.left = left;
            }
            left--;
            right++;
        }
    }

    public String calculateHwCount03(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            findHw03(charArray, i, i);
            findHw03(charArray, i - 1, i);
        }
        return str.substring(left, len);
    }

    public void findHw03(char[] charArr, int start, int end) {
        while(start >= 0 && end < charArr.length && charArr[start] == charArr[end]) {
            if (end - start + 1 > len) {
                left = start;
                len = end - start + 1; // 取最长的那个
            }
            System.out.println("start:" + left + ",len:" + len);
            start--;
            end++;
        }
    }

    public static void main(String[] args) {
        HWString hw = new HWString();
        String str = "aba";
        System.out.println(hw.calculateHwCount03(str));
    }
}
