package findfirstcharinstring;


/**
 * 在一个字符串中找到第一个只出现一次的字符，并返回它的位置。字符串只包含 ASCII 码字符。
 * <p>
 * 这道题最直观的解题思路就是使用HashMap进行存储，char当key，出现的次数加+最后在遍历进行统计查找
 * <p>
 * 但是我们现在知道这个字符串中只包含ASCII 码字符，那么我们可以知道一共有128个字符，所以我们使用数组也可以完成这个操作
 */

public class FindFirstCharInString {

    public static int findFirstCharInString(String str) {
        int length = str.length();
        int[] cnts = new int[128];
        for (int i = 0; i < length; i++) {
            cnts[str.charAt(i)]++;
        }
        for (int i = 0; i < length; i++) {
            if (cnts[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String des = "abbvvacc";
        int index = findFirstCharInString(des);
        if (index == -1) {
            System.out.println("不存在");
        } else {
            System.out.println("位置是:" + index);
        }
    }
}
