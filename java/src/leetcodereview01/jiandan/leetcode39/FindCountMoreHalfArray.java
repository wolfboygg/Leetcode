package leetcodereview01.jiandan.leetcode39;

import java.util.*;

public class FindCountMoreHalfArray {

    public void findByHashMap04(int[] arr) {
        // 通过HashMap进行处理
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (countMap.containsKey(arr[i])) {
                countMap.put(arr[i], countMap.get(arr[i]) + 1);
            } else {
                countMap.put(arr[i], 1);
            }
        }
        // 然后遍历找到最大的即可
        Set<Map.Entry<Integer, Integer>> entries = countMap.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
        Map.Entry<Integer, Integer> max = null;
        while(iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            if (max == null) {
                max = next;
            } else {
                if (max.getValue() < next.getValue()) {
                    max = next;
                }
            }
        }
        System.out.println(max.getKey());
    }

    public void findByHashMap05(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        System.out.println(map.toString());
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
        Map.Entry<Integer, Integer> max = null;
        while(iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            if (max == null || next.getValue() > max.getValue()) {
                max = next;
            }
        }
        System.out.println(max.getKey());
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        FindCountMoreHalfArray findCountMoreHalfArray = new FindCountMoreHalfArray();
        findCountMoreHalfArray.findByHashMap05(arr);
    }

    // 使用HashMap进行统计
    public void findByHashMap03(int[] arr) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (countMap.containsKey(arr[i])) {
                countMap.put(arr[i], countMap.get(arr[i]) +1);
            }  else {
                countMap.put(arr[i], 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = countMap.entrySet();
        Map.Entry<Integer, Integer> maxEntry = null;
        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            if (maxEntry == null) {
                maxEntry = next;
            } else {
                if (maxEntry.getValue() < next.getValue()) {
                    maxEntry = next;
                }
            }
        }
        System.out.println(maxEntry.getKey());
    }

    public void findByHashMap02(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Map.Entry<Integer, Integer> temp = null;
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (temp == null) {
                temp = entry;
            } else {
                temp = temp.getValue() > entry.getValue() ? temp : entry;
            }
        }
        System.out.println(temp.getKey());

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
