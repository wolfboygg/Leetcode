package leetcodereview01.jiandan.leetcode17;

public class PrintMaxN {

    // 最简单的方式
    public void print(int n) {
        int value = (int) (Math.pow(10, n) -1);
        for (int i = 0; i < value; i++) {
            System.out.println(i);
        }
    }

    public void print02(int n) {
        int number = (int) (Math.pow(10, n) -1);
        for (int i = 0; i < number; i++) {
            System.out.println(i);
        }
    }

    public void print03(int n) {
        // 打印 0- n最大n位数
        // 求最大n位数的最大值 然后在进行求解
        int maxValue = (int) (Math.pow(10, n) - 1);
        for(int i = 0; i <= maxValue; i++) {
          System.out.println(i);
        }
    }

    public void print04(int target) {
        // 打印到最大
        int value = (int) (Math.pow(10, target) - 1);
        for (int i = 0; i <= value; i++) {
            System.out.println(i);
        }
    }

    public void print05(int target) {
        // 打印最大的1-n
        int maxValue = Math.max(10, target) -1;
        for (int i = 0; i <= maxValue; i++) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        PrintMaxN printMaxN = new PrintMaxN();
        printMaxN.print04(3);
    }

    private void printAllNumber(int n) {
        int maxValue = (int) (Math.pow(10, n) -1);
        for (int i = 0; i < maxValue; i++) {
            System.out.println(i);
        }
    }

}
