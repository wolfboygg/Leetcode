package leetcodereview01.jiandan.leetcode14_01;

public class CutShengZi {
    public int cut01(int target) {
        if (target < 2) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int threeTime = 0;
        int towTime = 0;
        threeTime = target / 3;
        if (target - threeTime * 3 ==1) {
            threeTime--;
        }
        towTime = (target - threeTime * 3) / 2;
        return (int) (Math.pow(3, threeTime) * Math.pow(2, towTime));
    }

    public static void main(String[] args) {
        CutShengZi cutShengZi = new CutShengZi();
        System.out.println(cutShengZi.cut01(8));
    }

    private int cut(int target) {
        // 先取3再凑2
        if (target < 2) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int threeTime = 0;
        int towTime = 0;
        threeTime = target / 3;
        // 凑2
        if (target - threeTime * 3 == 1) {
            threeTime--;
        }
        towTime = (target - threeTime * 3) / 2;
        return (int) (Math.pow(3, threeTime) * Math.pow(2, towTime));
    }
}
