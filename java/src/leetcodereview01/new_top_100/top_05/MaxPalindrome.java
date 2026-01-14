package leetcodereview01.new_top_100.top_05;

/**
 * 最长的回文字符串
 * 采用中心扩散方法。注意如果是偶数找不到中心位置，没法扩散，所以要i-1进行扩散
 */
public class  MaxPalindrome {

    private int left = 0;
    private int len = 0;

    public String findMaxHWStr(String str) {
        if (str.length() < 2) {
            return str;
        }
        for (int i = 0; i < str.length(); i++) {
            find(str, i, i);
            find(str, i - 1, i);
        }
        return str.substring(left, left + len);
    }

    public void find(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
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
            left = i - 1;
            right = i + 1;
            // 想左边扩散
            while (left >= 0 && str.charAt(i) == str.charAt(left)) {
                left--;
                len++;
            }
            // 向右边扩散
            while (right < str.length() && str.charAt(i) == str.charAt(right)) {
                right++;
                len++;
            }
            // 中心扩散
            while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
                left--;
                right++;
                len += 2;
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
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            if (right - left + 1 > len) {
                len = right - left + 1;
                this.left = left;
            }
            left--;
            right++;
        }
    }

    public String findMaxHWStr03(String str) {
        // 通过中心扩散找到最left和len
        if (str == null || str.length() == 0) {
            return "";
        }
        for (int i = 0; i < str.length(); i++) {
            find03(str, i, i);
            find03(str, i - 1, i);
        }
        return str.substring(left, len);
    }

    public void find03(String str, int start, int end) {
        // 必须相等之后才能继续循环
        while (start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
            if (end - start + 1 > len) {
                this.left = start;
                this.len = end - start + 1;
            }
            start--;
            end++;
        }
    }

    public String findMaxHWStr04(String str) {
        // 通过遍历的方式找到left和len
        if (str == null || str.length() == 0) {
            return "";
        }
        for (int i = 0; i < str.length(); i++) {
            find04(str, i, i);
            find04(str, i - 1, i);
        }
        return str.substring(left, len);
    }

    public void find04(String str, int start, int end) {
        while(start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
            if (end - start + 1 > len) {
                this.left = start;
                this.len = end - start + 1;
            }
            start--;
            end++;
        }
    }

    public String findMaxHWString05(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        for (int i = 0; i < str.length(); i++) {
            find05(str, i, i);
            find05(str, i-1, i);
        }
        System.out.println(this.len);
        return str.substring(left, len);
    }

    public void find05(String str, int start, int end) {
        while(start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
            if (end - start  + 1 > len) {
                this.left = start;
                this.len = end - start + 1;
            }
            start--;
            end++;
        }
    }

    public String findMaxHWString06(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        for (int i = 0; i < str.length(); i++) {
            find06(str, i, i);
            find06(str, i-1, i);
        }
        return str.substring(left, len);
    }

    public void find06(String str, int left, int right) {
        while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            if (right - left > len) {
                this.left = left;
                len = right - left + 1;
            }
            left--;
            right++;
        }
    }

    public String findMaxHWString07(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            find07(charArray, i, i);
            find07(charArray, i - 1, i);
        }
        return str.substring(left, len);
    }

    public void find07(char[] charArr, int start, int end) {
        while(start >= 0 && end < charArr.length && charArr[start] == charArr[end]) {
            if (end - start + 1 > len) {
                this.len = end - start + 1;
                this.left = start;
            }
            start--;
            end++;
        }
    }

    public String findMaxHWString08(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            find08(charArray, i, i);
            find08(charArray, i - 1, i);
        }
        return str.substring(left, len);
    }

    public void find08(char[] charArr, int left, int right) {
        while(left >= 0 && right < charArr.length && charArr[left] == charArr[right]) {
            if (right - left + 1 > len) {
                len = right - left + 1;
                this.left = left;
            }
            left--;
            right++;
        }
    }

    public String findMaxHWString09(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            find09(charArray, i, i);
            find09(charArray, i-1, i);
        }
        return str.substring(left, len);
    }

    public void find09(char[] charArr, int start, int end) {
        while (start >= 0 && start < charArr.length && end >= 0 && end < charArr.length && charArr[start] == charArr[end]) {
            if (end - start + 1 > len) {
                left = start;
                len = end - start + 1;
            }
            start--;
            end++;
        }
    }


    public static void main(String[] args) {
        String str = "abbac";
        MaxPalindrome maxPalindrome = new MaxPalindrome();
        String temp = maxPalindrome.findMaxHWString09(str);
        System.out.println(temp);
    }
}
