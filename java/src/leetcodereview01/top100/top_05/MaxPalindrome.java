package leetcodereview01.top100.top_05;

/**
 * 最长的回文字符串
 * 采用中心扩散方法。注意如果是偶数找不到中心位置，没法扩散，所以要i-1进行扩散
 */
public class MaxPalindrome {

    private int left = 0;
    private int len = 0;

    public String findMaxHWStr(String str) {
        if (str.length() < 2) {
            return str;
        }
        for (int i = 0; i < str.length(); i++) {
            find(str, i, i);
            find(str,i - 1, i);
        }
        return str.substring(left, left + len);
    }

    public void find(String str, int left, int right) {
        while(left >=0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            if (right - left + 1 > len) {
                this.left = left;
                len = right - left + 1;
            }
            left--;
            right++;
        }
    }

    public String findMaxHWStr01(String str) {
        // 中心扩散法
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int maxLeft = 0;
        int len = 1;
        for (int i = 0; i < str.length(); i++) {
            left = i -1;
            right = i + 1;
            // 想左边扩散
            while(left >=0 && str.charAt(i) == str.charAt(left)) {
                left--;
                len++;
            }
            // 向右边扩散
            while(right < str.length() && str.charAt(i) == str.charAt(right)) {
                right++;
                len++;
            }
            // 中心扩散
            while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
                left--;
                right++;
                len+= 2;
            }
            if (maxLength < len) {
                maxLength = len;
                maxLeft = left;
            }
            len = 1;
        }
        return str.substring(maxLeft + 1, maxLeft + maxLength + 1);
    }

    public String findMaxHWStr02(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        for (int i = 0; i < str.length(); i++) {
            find02(str, i, i);
            find02(str, i, i + 1);
        }
        return str.substring(this.left, this.len);
    }

    public void find02(String str, int left, int right) {
        while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            if (right - left + 1 > len) {
                len = right - left + 1;
                this.left = left;
            }
            left--;
            right++;
        }
    }

    public static void main(String[] args){
        String str = "abba";
        MaxPalindrome maxPalindrome = new MaxPalindrome();
        String temp = maxPalindrome.findMaxHWStr02(str);
        System.out.println(temp);
    }
}
