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

    public static void main(String[] args) {
        HWString hw = new HWString();
        String str = "aba";
        System.out.println(hw.calculateHwCount(str));
    }
}
