package leetcodereview01.doubao.db_20250114;

/**
 * 回文字符串
 */
public class HWString {

    private int left;
    private int len;

    public String hwString(String str) {
        // 解题思路 通过中心扩散的方式实现
        if (str == null || str.length() < 2) {
            return "";
        }
        // 对每一个字符进行回文判断
        for (int i = 0; i < str.length(); i++) {
            find(str, i, i);
            find(str, i, i + 1);
        }
        return str.substring(left, len);
    }

    public void find(String str, int start, int end) {
        while (start >=0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
            if (end - start + 1 > len) {
                left = start;
                len = end - start + 1;
            }
            start--;
            end++;
        }
    }

    // 找到回最大的回文字符串
    public String hwString01(String str) {
        if (str == null || str.length() < 2) {
            return "";
        }
        for (int i = 0; i < str.length(); i++) {
            find01(str, i, i);
            find01(str, i, i + 1);
        }
        return str.substring(left, len);
    }

    public void find01(String str, int start, int end) {
        while(start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
            if (end - start + 1 > len) {
                len = end - start + 1;
                left = start;
            }
            start--;
            end++;
        }
    }

    public boolean isHWString(String str) {
        // 简单的很，找到中心位置向外扩散进行判断
        if (str == null || str.length() == 0) {
            return false;
        }
        int middle = str.length() / 2;
        if (str.length() % 2 == 0) {
            return realHW(str, middle - 1, middle);
        } else {
            return realHW(str, middle - 1, middle + 1);
        }
    }

    public boolean realHW(String str, int start, int end) {
        while(start >= 0 &&  end < str.length() && str.charAt(start) == str.charAt(end)) {
            start--;
            end++;
        }
        return start == -1;
    }

    public static void main(String[] args) {
        String str = "babad";
        String str1 = "baab";
        HWString hwString = new HWString();
        String s = hwString.hwString01(str1);
        System.out.println(s);
        boolean isHW = hwString.isHWString(str);
        System.out.println(isHW);
    }
}
