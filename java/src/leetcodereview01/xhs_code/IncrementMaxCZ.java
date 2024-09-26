package leetcodereview01.xhs_code;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class IncrementMaxCZ {

    public static int getMaxCZValue(int[] arr) {
        // 求最大差值
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int minValue = arr[0];
        int maxValue = -1;
        for (int i = 1; i < arr.length; i++) {
            minValue = Math.min(minValue, arr[i]);
            if (arr[i] > minValue) {
                maxValue = Math.max(maxValue, arr[i] - minValue);
            }
        }
        return maxValue;
    }

    private static final char[] HEX_DIGITS = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };

    private static String toHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            sb.append(HEX_DIGITS[(b & 0xf0) >> 4]);
            sb.append(HEX_DIGITS[b & 0x0f]);
        }
        return sb.toString();
    }

    private static String String2MD5(String input) {
        String encdeStr = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] hash = messageDigest.digest(input.getBytes("UTF-8"));
            System.out.println(Arrays.toString(hash));
            encdeStr = toHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encdeStr;
    }


    private static String String2SHA256(String input) {

        String encodeStr = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(input.getBytes("UTF-8"));
            encodeStr = toHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }

    public static void main(String[] args) {
        int[] arr = {9, 4, 3, 2};
        int maxValue = getMaxCZValue(arr);
        System.out.println(maxValue);
        System.out.println(String2MD5("hellworld"));
        System.out.println(String2SHA256("hellworld"));
    }
}
