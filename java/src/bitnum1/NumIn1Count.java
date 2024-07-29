package bitnum1;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class NumIn1Count {

    public int getNumIn1Count(int n) {
        // 采用与运算的方式进行操作，主要将n&(n-1) 有多少为1就可以进行多少次这样的操作
        int count = 0;
        while (n > 0) {
            count++;
            n &= (n - 1);
        }
        return count;
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

    private static String String2MD5(String input) {
        String encdeStr = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] hash = messageDigest.digest(input.getBytes("UTF-8"));
            encdeStr = toHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encdeStr;
    }

    public static void main(String[] args) {
        System.out.println(new NumIn1Count().getNumIn1Count(3));
        StringBuilder sb = new StringBuilder();
        String value = String2SHA256(
                sb.append("tantan")
                        .append("a8e784946e045e1331075cb4f6eea231")
                        .append("1715742731336")
                        .append("a5eeb540b0a76dc94c3a06b3266ab1b3")
                        .append("")
                        .toString())
                .toLowerCase();
        System.out.println(value);
    }
}
