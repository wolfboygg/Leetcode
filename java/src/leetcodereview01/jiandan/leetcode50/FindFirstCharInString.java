package leetcodereview01.jiandan.leetcode50;

public class FindFirstCharInString {

    public void findFirstChar(String str) {
        int[] arr = new int[128];
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            arr[array[i]]++;
        }
        for (int i = 0; i < array.length; i++) {
            if (arr[array[i]] == 1) {
                System.out.println(array[i]);
                break;
            }
        }
    }

    public static void main(String[] args) {
        String str = "abbvvaccd";
        FindFirstCharInString findFirstCharInString = new FindFirstCharInString();
        char c = findFirstCharInString.find(str);
        System.out.println(c);
        findFirstCharInString.findFirstChar(str);
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
