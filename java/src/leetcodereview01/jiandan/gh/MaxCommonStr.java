package leetcodereview01.jiandan.gh;

/**
 * 最大公共字串 要求内部连续
 * 最大公共子序列不要连续
 */
public class MaxCommonStr {

    public int findMaxCommonStr(String str1, String str2) {
        int max = 0;
        char[] firstArray = str1.toCharArray();
        char[] secondArray = str2.toCharArray();
        int[][] matrix = new int[firstArray.length + 1][secondArray.length + 1];
        for (int i = 1; i < firstArray.length + 1; i++) {
            for (int j = 1; j < secondArray.length + 1; j++) {
                if (firstArray[i - 1] == secondArray[j - 1]) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    max = Math.max(max, matrix[i][j]);
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        return max;
    }

    public int findMaxCommonSequence(String str1, String str2) {
        int max = 0;
        char[] firstArray = str1.toCharArray();
        char[] secondArray = str2.toCharArray();
        int[][] matrix = new int[firstArray.length + 1][secondArray.length + 1];
        for (int i = 1; i < firstArray.length + 1; i++) {
            for (int j = 1; j < secondArray.length + 1; j++) {
                if (firstArray[i - 1] == secondArray[j - 1]) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    max = Math.max(max, matrix[i][j]);
                } else {
                    matrix[i][j] = matrix[i - 1][j - 1];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s1 = "ABCDEFG";
        String s2 = "ABADEFKG";
        // 最大公共字串
        MaxCommonStr maxCommonStr = new MaxCommonStr();
        int maxLength = maxCommonStr.findMaxCommonStr(s1, s2);
        System.out.println(maxLength);
        int maxSequence = maxCommonStr.findMaxCommonSequence(s1, s2);
        System.out.println(maxSequence);
    }
}
