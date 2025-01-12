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

    public void findFirstChar04(String str) {
        char[] chars = str.toCharArray();
        int[] valueArr = new int[128];
        for (int i = 0; i < chars.length; i++) {
            valueArr[chars[i]]++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (valueArr[chars[i]] == 1) {
                System.out.println(chars[i]);
                break;
            }
        }
    }

    public void findFirstChar05(String str) {
        // 使用128数组进行存储
        int[] count = new int[128];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] == 1) {
                System.out.println(str.charAt(i));
                break;
            }
        }
    }

    // 只出现1次的字符
    public void findFirstChar06(String str) {
        // 所有的字符一个128个 搞一个数字进行统计即可
        int[] count = new int[128];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] == 1) {
                System.out.println(str.charAt(i));
                break;
            }
        }
    }

    public void findFirstChar07(String str) {
        // 找到只出现一次的字符串
        char[] charArr = str.toCharArray();
        int[] countCharArr = new int[128];
        for (int i = 0; i < charArr.length; i++) {
            int index = charArr[i];
            countCharArr[index]++;
        }
        // 遍历
        for (int i = 0; i < charArr.length; i++) {
            if (countCharArr[charArr[i]] == 1) {
                System.out.println("first char is:" + charArr[i]);
                break;
            }
        }
    }

    // 找到只出现一次的字符
    public void findFirstChar08(String str) {
        int[] arr = new int[128];
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            arr[chars[i]] += 1;
        }
        for (int i = 0; i < chars.length; i++) {
            if (arr[chars[i]] == 1) {
                System.out.println(chars[i]);
                break;
            }
        }
    }

    // 找只出现一次的字符
    public void findFirstChar09(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        // 直接用int存储吧
        int[] value = new int[128];
        for (int i = 0; i < str.length(); i++) {
            value[str.charAt(i)] += 1;
        }
        // 还需要遍历一遍
        for (int i = 0; i < str.length(); i++) {
            if (value[str.charAt(i)] == 1) {
                System.out.println(str.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        String str = "abbvvaccd";
        FindFirstCharInString findFirstCharInString = new FindFirstCharInString();
//        char c = findFirstCharInString.find(str);
//        System.out.println(c);
        findFirstCharInString.findFirstChar09(str);
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
