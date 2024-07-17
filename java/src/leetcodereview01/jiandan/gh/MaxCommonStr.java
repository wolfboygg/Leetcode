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
                    matrix[i][j] = matrix[i-1][j-1] + 1;
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
                    matrix[i][j] = matrix[i-1][j-1] +1;
                    maxValue = Math.max(maxValue, matrix[i][j]);
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        return maxValue;
    }

    public int findMaxCommonSequence02(String str1, String str2) {
        // 求解最大公共字串，必须连续
        char[] firstArr = str1.toCharArray();
        char[] secondArr = str2.toCharArray();
        int maxValue = 0;
        int[][] matrix = new int[firstArr.length + 1][secondArr.length + 1];
        for (int i = 1; i < firstArr.length + 1; i++) {
            for (int j = 1; j < secondArr.length + 1; j++) {
                if (firstArr[i - 1] == secondArr[j - 1]) {
                    matrix[i][j] = matrix[i-1][j-1] +1;
                    maxValue = Math.max(maxValue, matrix[i][j]);
                } else {
                    matrix[i][j] = matrix[i-1][j-1];
                }
            }
        }
        return maxValue;
    }

    public int findMaxCommonStr03(String str1, String str2) {
        char[] firstArr = str1.toCharArray();
        char[] secondArr = str2.toCharArray();
        int maxValue = 0;
        int[][] matrix = new int[firstArr.length+ 1][secondArr.length+ 1];
        for (int i = 1; i < firstArr.length + 1; i++) {
            for (int j = 1; j < secondArr.length + 1; j++) {
                if (firstArr[i-1] == secondArr[j-1]) {
                    matrix[i][j] = matrix[i-1][j-1] + 1;
                    maxValue = Math.max(maxValue, matrix[i][j]);
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        return maxValue;
    }

    public int findMaxCommonStr04(String str1, String str2) {
        char[] firstArr = str1.toCharArray();
        char[] secondArr = str2.toCharArray();
        int[][] matrix = new int[firstArr.length + 1][secondArr.length + 1];
        int maxValue = 0;
        for (int i = 1; i < firstArr.length + 1; i++) {
            for (int j = 1; j < secondArr.length + 1; j++) {
                  if (firstArr[i-1] == secondArr[j-1]) {
                      matrix[i][j] = matrix[i-1][j-1] + 1;
                      maxValue = Math.max(matrix[i][j], maxValue);
                  } else {
                      matrix[i][j] = 0;
                  }
            }
        }
        return maxValue;
    }

    public int findMaxCommonSequence04(String str1, String str2) {
        char[] firstArr = str1.toCharArray();
        char[] secondArr = str2.toCharArray();
        int maxValue = 0;
        int[][] matrix = new int[firstArr.length + 1][secondArr.length + 1];
        for (int i = 1; i < firstArr.length + 1; i++) {
            for(int j = 1; j < secondArr.length + 1; j++) {
                if (firstArr[i - 1] == secondArr[j - 1]) {
                    matrix[i][j] = matrix[i-1][j-1] + 1;
                    maxValue = Math.max(maxValue, matrix[i][j]);
                } else {
                    matrix[i][j] = matrix[i-1][j-1];
                }
            }
        }
        return maxValue;
    }

    // 最大公共字符串需要连续
    public int findMaxCommonStr05(String str1, String str2) {
        int[][] matrix = new int[str1.length() + 1][str2.length() + 1];
        char[] rowChars = str1.toCharArray();
        char[] columnChars = str2.toCharArray();
        int maxValue = 0;
        for (int i = 1; i < rowChars.length + 1; i++) {
            for (int j = 1; j < columnChars.length+ 1; j++) {
                if (rowChars[i-1] == columnChars[j-1]) {
                    matrix[i][j] = matrix[i-1][j-1] + 1;
                    maxValue = Math.max(maxValue, matrix[i][j]);
                }
            }
        }
        return maxValue;
    }

    // 最大的公共子序列就是不要求联系
    public int findMaxCommonSequence05(String str1, String str2) {
        char[] firstArr = str1.toCharArray();
        char[] secondArr = str2.toCharArray();
        int[][] matrix = new int[firstArr.length + 1][secondArr.length + 1];
        int maxValue = 0;
        // 进行遍历处理
        for (int i = 1; i < firstArr.length + 1; i++) {
            for (int j = 1; j < secondArr.length + 1; j++) {
                if (firstArr[i-1] == secondArr[j-1]) {
                    matrix[i][j] = matrix[i-1][j-1] + 1;
                    maxValue = Math.max(maxValue, matrix[i][j]);
                } else {
                    matrix[i][j] = matrix[i-1][j-1];
                }
            }
        }
        return maxValue;
    }

    // 最大的公共字串需要连续，最大的公共子序列不需要连续
    public int findMaxCommonStr06(String str1, String str2) {
        // 最大公共子串
        int[][] matrix = new int[str1.length() + 1][str2.length() + 1];
        char[] firstArr = str1.toCharArray();
        char[] secondArr = str2.toCharArray();
        int maxValue = 0;
        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                if (firstArr[i-1] == secondArr[j-1]) {
                    matrix[i][j] = matrix[i-1][j-1] + 1;
                    maxValue = Math.max(matrix[i][j], maxValue);
                }
            }
        }
        return maxValue;
    }

    public int findMaxCommonSequence06(String str1, String str2) {
        // 找公共子序列，不需要连续
        char[] firstArr = str1.toCharArray();
        char[] secondArr = str2.toCharArray();
        int[][] matrix = new int[firstArr.length + 1][secondArr.length +1];
        int maxValue = 0;
        for (int i = 1; i < firstArr.length + 1; i++) {
            for (int j = 1; j < secondArr.length + 1; j++) {
                if (firstArr[i-1] == secondArr[j-1]) {
                    matrix[i][j]= matrix[i-1][j-1] + 1;
                    maxValue = Math.max(matrix[i][j], maxValue);
                } else {
                    matrix[i][j] = matrix[i-1][j-1];
                }
            }
        }
        return maxValue;
    }

    // 求最大公共字串
    public int findMaxCommonStr07(String str1, String str2) {
        // 使用一个公共数组进行辅助实现
        char[] strArr01 = str1.toCharArray();
        char[] strArr02 = str2.toCharArray();
        int max = 0;
        int[][] matrix = new int[strArr01.length +1][strArr02.length+1];
        for (int i = 1; i < strArr01.length +1; i++) {
            for (int j = 1; j < strArr02.length +1; j++) {
                if (strArr01[i-1] == strArr02[j-1]) {
                    matrix[i][j] = matrix[i-1][j-1] + 1;
                    max = Math.max(matrix[i][j], max);
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        return max;
    }
    // 最大公共子序列 (要求不连续)
    public int findMaxCommonSequence07(String str1, String str2) {
        char[] strArr01 = str1.toCharArray();
        char[] strArr02 = str2.toCharArray();
        int max = 0;
        int[][] matrix = new int[strArr01.length + 1][strArr02.length + 1];
        for (int i = 1; i < strArr01.length + 1; i++) {
            for (int j = 1; j < strArr02.length + 1; j++) {
                  if (strArr01[i-1] == strArr02[j-1]) {
                      matrix[i][j] = matrix[i-1][j-1] + 1;
                      max = Math.max(max, matrix[i][j]);
                  } else {
                      matrix[i][j] = matrix[i-1][j-1];
                  }
            }
        }
        return max;
    }


    public int findMaxCommonStr08(String s1, String s2) {
        // 最大公共字串 需要连续
        int s1Length = s1.length();
        int s2Length = s2.length();
        char[] arrS1 = s1.toCharArray();
        char[] arrS2 = s2.toCharArray();
        int[][] matrix = new int[s1Length + 1][s2Length + 1];
        int maxLength = 0;
        for (int i = 1; i <= s1Length; i++) {
            for (int j = 1; j <= s2Length; j++) {
                if (arrS1[i-1] == arrS2[j-1]) {
                    matrix[i][j] = matrix[i-1][j-1] + 1;
                    maxLength = Math.max(maxLength, matrix[i][j]);
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        return maxLength;
    }

    public int findMaxCommonSequence08(String s1, String s2) {
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        int max = 0;
        int[][] matrix = new int[s1Arr.length +1][s2Arr.length + 1];
        for (int i = 1; i < s1Arr.length + 1; i++) {
            for (int j = 1; j < s2Arr.length + 1; j++) {
                if (s1Arr[i-1]== s2Arr[j-1]) {
                    matrix[i][j] = matrix[i-1][j-1] + 1;
                } else {
                    matrix[i][j] = matrix[i-1][j-1];
                }
                max = Math.max(max, matrix[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s1 = "ABCDEFG";
        String s2 = "ABADEFKG";
        // 最大公共字串
        MaxCommonStr maxCommonStr = new MaxCommonStr();
        int maxLength = maxCommonStr.findMaxCommonStr08(s1, s2);
        System.out.println(maxLength);
        int maxSequence = maxCommonStr.findMaxCommonSequence08(s1, s2);
        System.out.println(maxSequence);
    }
}
