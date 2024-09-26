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

    public int cut07(int target) {
        // 凑数
        if (target <= 1) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        // 贪3凑2
        int three = target / 3;
        int tow = 0;
        if (target - three * 3 == 1) {
            three --;
        }
        // 这里要放到判断之后
        tow = (target -  3 * three) / 2;
        System.out.println(tow);
        return (int) (Math.pow(3, three) * Math.pow(2, tow));
    }

    public int cut08(int target) {
        if (target < 2) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        // 取三凑2
        int threeCount = 0;
        int twoCount = 0;
        threeCount = target / 3;
        if (target - threeCount * 3 == 1) {
            threeCount -= 1;
        }
        twoCount = (target - threeCount * 3) / 2;
        return (int) (Math.pow(3, threeCount)  * Math.pow(2, twoCount));
    }

    public int cut09(int target) {
        // 减绳子
        if (target <= 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int three = target / 3;
        int tow = 0;
        if (target - three * 3 == 1) {
            three -= 1;
        }
        tow = (target - three * 3) / 2;
        return (int) (Math.pow(3, three) * Math.pow(2, tow));
    }


    public int cut10(int target) {
        // 贪婪算法
        if (target <= 2) {
            return 1;
        }
        if (target ==3) {
            return 2;
        }
        // 先算3
        int three = target / 3;
        int tow = 0;
        if (target - three * 3 == 1) {
            three -= 1;
        }
        // 这里也需要算一下 不止是== 1的情况 还有正好等于2的情况
        tow = (target - three * 3) / 2;
        return (int) (Math.pow(3, three)  * Math.pow(2, tow));

    }

    public static void main(String[] args) {
        CutShengZi cutShengZi = new CutShengZi();
        System.out.println(cutShengZi.cut10(8));
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
