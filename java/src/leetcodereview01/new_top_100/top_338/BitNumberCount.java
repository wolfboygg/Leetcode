package leetcodereview01.new_top_100.top_338;

import java.util.ArrayList;
import java.util.List;

/**
 * 比特位计数
 */
public class BitNumberCount {

    public List<Integer> getBitNumber(int n) {
        if (n < 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            int temp = i;
            int count = 0;
            while (temp != 0) {
                temp &= temp - 1;
                count++;
            }
            list.add(count);
        }
        return list;
    }

    public List<Integer> getBitNumber01(int n) {
        if (n < 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            int temp = i;
            int count = 0;
            while (temp != 0) {
                count++;
                temp &= (temp - 1);
            }
            list.add(count);
        }
        return list;
    }


    public List<Integer> getBitNumber02(int n) {
        if (n < 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            int temp = i;
            int count = 0;
            while (temp != 0) {
                count++;
                temp &= (temp - 1);
            }
            list.add(count);
        }
        return list;
    }

    public List<Integer> getBitNumber03(int n) {
        if (n < 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            int temp = i;
            int count = 0;
            while(temp > 0) {
                temp &= (temp -1);
                count++;
            }
            list.add(count);
        }
        return list;
    }

    public List<Integer> getBitNumber04(int n) {
        if (n == 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int temp = i;
            int count = 0;
            while(temp > 0) {
                count++;
                temp &= (temp -1);
            }
            list.add(count);
        }
        return list;
    }

    public List<Integer> getBitNumber05(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int temp = i;
            int count = 0;
            while(temp > 0) {
                count++;
                temp = temp &(temp - 1);
            }
            list.add(count);
        }
        return list;
    }

    public List<Integer> getBitNumber06(int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= target; i++) {
            int value = i;
            int count = 0;
            while(value > 0) {
                count++;
                value &= (value - 1);
            }
            list.add(count);
        }
        return list;
    }

    public List<Integer> getBitNumber07(int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= target; i++) {
            int value = i;
            int count = 0;
            while(value!= 0) {
                value &= (value -1);
                count++;
            }
            list.add(count);
        }
        return list;
    }

    public static void main(String[] args) {
        BitNumberCount bitNumberCount = new BitNumberCount();
        List<Integer> bitNumber = bitNumberCount.getBitNumber07(5);
        System.out.println(bitNumber.toString());
    }
}
