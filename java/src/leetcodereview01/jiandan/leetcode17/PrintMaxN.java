package leetcodereview01.jiandan.leetcode17;

public class PrintMaxN {

    public static void main(String[] args) {
        PrintMaxN printMaxN = new PrintMaxN();
        printMaxN.printAllNumber(3);
    }

    private void printAllNumber(int n) {
        int maxValue = (int) (Math.pow(10, n) -1);
        for (int i = 0; i < maxValue; i++) {
            System.out.println(i);
        }
    }

}
