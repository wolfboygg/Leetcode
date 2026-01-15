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

    public int findMaxCommonStr01(String str1, String str2) {
        // 最大公共字串 内部要连续
        int row = str1.length();
        int column = str1.length();
        char[] firstArr = str1.toCharArray();
        char[] secondArr = str2.toCharArray();
        int[][] matrix = new int[row + 1][column + 1];
        int max = 0;
        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < column + 1; j++) {
                if (firstArr[i - 1] == secondArr[j - 1]) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    max = Math.max(max, matrix[i][j]);
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        return max;
    }

    public int findMaxCommonStr02(String str1, String str2) {
        // 求解最大公共字串，必须连续
        char[] firstArr = str1.toCharArray();
        char[] secondArr = str2.toCharArray();
        int maxValue = 0;
        int[][] matrix = new int[firstArr.length + 1][secondArr.length + 1];
        for (int i = 1; i < firstArr.length + 1; i++) {
            for (int j = 1; j < secondArr.length + 1; j++) {
                if (firstArr[i - 1] == secondArr[j - 1]) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    maxValue = Math.max(maxValue, matrix[i][j]);
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        return maxValue;
    }

    public int findMaxCommonStr03(String str1, String str2) {
        // 最大的公共字串 需要连续
        if (str1 == null || str2 == null) {
            return -1;
        }
        // 这里使用动态规划的方式 需要一个二维数组
        int max = 0;
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }
    // 最大公共子序列，不需要连续
    public int findMaxCommonSequence03(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return -1;
        }
        int max = 0;
        // 多一个是为了好计算
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(dp[i][j], max);
                } else {
                    dp[i][j] = dp[i-1][j-1];
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
        int maxLength = maxCommonStr.findMaxCommonStr03(s1, s2);
        System.out.println(maxLength);
        int maxSequence = maxCommonStr.findMaxCommonSequence03(s1, s2);
        System.out.println(maxSequence);
    }
}
