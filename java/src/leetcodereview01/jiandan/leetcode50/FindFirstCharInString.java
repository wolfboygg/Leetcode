package leetcodereview01.jiandan.leetcode50;

public class FindFirstCharInString {
    public static void main(String[] args) {
        String str = "abbvvaccd";
        FindFirstCharInString findFirstCharInString = new FindFirstCharInString();
        char c = findFirstCharInString.find(str);
        System.out.println(c);
    }

    private char find(String str) {
        int[] arr = new int[128];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (arr[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }
        return ' ';
    }
}
