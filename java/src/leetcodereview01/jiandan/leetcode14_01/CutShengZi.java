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
        System.out.println("threeTime:" + threeTime +"->towTime:" + towTime);
        return (int) (Math.pow(3, threeTime) * Math.pow(2, towTime));
    }

    // 剪绳子，使用贪心算法进行处理，先凑3，如果剩余1凑1
    // 求的是乘积
    public int cut02(int target) {
        if (target < 2) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        // 开始凑3
        int threeTime = target / 3;
        if (target - threeTime * 3 == 1) {
            // 可以凑个2出来
            threeTime--;
        }
        int towTime = (target - threeTime * 3) / 2;
        System.out.println("threeTime:" + threeTime +"->towTime:" + towTime);
        return (int) (Math.pow(3, threeTime) * Math.pow(2, towTime));
    }

    public int cut03(int target) {
        // 凑三取二法
        if (target < 2) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int threeCut = 0;
        int towCut = 0;
        threeCut = target / 3;
        if (target - threeCut * 3 ==1) {
            threeCut--;
        }
        towCut = (target - threeCut * 3) / 2;
        return (int) (Math.pow(3, threeCut) * Math.pow(2, towCut));
    }

    public int cut04(int target) {
        if (target < 2) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int threeCut = 0;
        int towCut = 0;
        threeCut = target / 3;
        if (target - threeCut * 3 ==1) {
            threeCut--;
        }
        towCut = (target - threeCut * 3) / 2;
        return (int) (Math.pow(3, threeCut) * Math.pow(2, towCut));
    }

    // 凑三取二法
    public int cut05(int target) {
        if (target <= 1) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int threeCut = 0;
        int twoCut = 0;
        threeCut = target / 3;
        if (target - threeCut * 3 == 1) {
            threeCut--;
        }
        twoCut = (target - threeCut * 3) / 2;
        return (int) (Math.pow(3, threeCut) * Math.pow(2, twoCut));
    }

    public int cut06(int target) {
        if (target <= 1) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int threeCount = 0;
        int towCount = 0;
        threeCount = target / 3;
        if (target - threeCount * 3 == 1) {
            threeCount--;
        }
        towCount = (target - threeCount * 3) / 2;
        return (int) (Math.pow(3, threeCount) * Math.pow(2, towCount));
    }

    public static void main(String[] args) {
        CutShengZi cutShengZi = new CutShengZi();
        System.out.println(cutShengZi.cut06(8));
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
