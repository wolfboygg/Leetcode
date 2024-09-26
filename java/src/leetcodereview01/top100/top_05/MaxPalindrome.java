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

    public static void main(String[] args){
        String str = "dababad";
        MaxPalindrome maxPalindrome = new MaxPalindrome();
        String temp = maxPalindrome.findMaxHWStr(str);
        System.out.println(temp);
    }
}
