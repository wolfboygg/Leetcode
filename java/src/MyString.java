import javafx.geometry.Pos;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class MyString {

    public static class Validate<T> {
        public T value = null;
        
    }

    public static void main(String[] args) {
//        String s1 = "ABCDEFG";
//        String s2 = "ABADEFKG";
//        System.out.println("最长公共子串长度：" + getLCS(s1, s2));
//        String[] strings = new String[]{"12", "12", "12"};
        ThreadLocal<Integer> threadLocal1 = new ThreadLocal<Integer>() {
            @Override
            protected Integer initialValue() {
                return super.initialValue();
            }
        };
        ThreadLocal<Double> threadLocal2 = new ThreadLocal<Double>() {
            @Override
            protected Double initialValue() {
                return super.initialValue();
            }
        };
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Integer integer = threadLocal1.get();
                threadLocal1.set(5);
                threadLocal2.set(4.5);
            }
        });
//        LinkedHashMap
        Position position1 = new Position(6);
        Position position2 = new Position(38);

        HashMap<Position, String> hash = new HashMap<>(16);
        hash.put(position1, "aaa");
        hash.put(position2, "bbb");

        HashMap<Position, String> hash2 = new HashMap<>(32);
        hash2.put(position1, "aaa");
        hash2.put(position2, "bbb");
        System.out.println(hash2);
    }

    public static class Position  {
        public int value;

        public Position(int value) {
            this.value = value;
        }

        @Override
        public int hashCode() {
            return value;
        }
    }

    public static int getLCS(String s1, String s2) {
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        // a.length行，b.length列
        int[][] result = new int[a.length + 1][b.length + 1];
        int max = 0;
        printRes(result);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    result[i + 1][j + 1] = result[i][j] + 1;
                    max = Math.max(max, result[i + 1][j + 1]);
                }
                printRes(result);
            }
        }
        // ----- print table -----
        System.out.print(" ");
        for (int i = 0; i < b.length; i++) {
            System.out.print(" " + b[i]); // 打印第一行
        }
        System.out.println();
        for (int i = 1; i < result.length; i++) {
            System.out.print(a[i - 1] + " ");
            for (int j = 1; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        // -----------------------
        return max;
    }

    public static void printRes(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

}
