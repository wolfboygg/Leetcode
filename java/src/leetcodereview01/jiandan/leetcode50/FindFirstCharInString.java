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

    public void findFirstChar02(String str) {
        int[] arr = new int[128];
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            arr[chars[i]]++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (arr[chars[i]] == 1) {
                System.out.println(chars[i]);
                break;
            }
        }
    }

    public void findFirstChar03(String str) {
        // 使用int数组存储个数
        char[] arr = str.toCharArray();
        int[] valueArr = new int[128];
        for (int i = 0; i < arr.length; i++) {
            valueArr[str.charAt(i)]++;
        }
        // 遍历得出
        for (int i = 0; i < arr.length; i++) {
              if (valueArr[str.charAt(i)] == 1) {
                  System.out.println(str.charAt(i));
                  break;
              }
        }
    }

    public static void main(String[] args) {
        String str = "abbvvaccd";
        FindFirstCharInString findFirstCharInString = new FindFirstCharInString();
        char c = findFirstCharInString.find(str);
        System.out.println(c);
        findFirstCharInString.findFirstChar03(str);
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
