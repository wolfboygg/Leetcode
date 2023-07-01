package leetcodereview01.jiandan.leetcode39;

import java.util.*;

public class FindCountMoreHalfArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        FindCountMoreHalfArray findCountMoreHalfArray = new FindCountMoreHalfArray();
        findCountMoreHalfArray.findByHashMap(arr);
    }

    private void find(int[] arr) {
        Arrays.sort(arr);
        int number = arr[arr.length / 2];
        System.out.println(number);
    }

    public void findByHashMap(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == null) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
        Map.Entry<Integer, Integer> temp = null;
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            System.out.println(next.getKey() + "-->" + next.getValue());
            if (temp == null) {
                temp = next;
            } else {
                if (temp.getValue() < next.getValue()) {
                    temp = next;
                }
            }
        }
        System.out.println(temp.getKey());
    }
}
