package leet40;

import java.util.*;

public class MoreThanHalfNum {

    public int moreThanHalfNum(int[] array) {
        HashMap<Integer, Integer> map = getCount(array);
        Map.Entry<Integer, Integer> findEntry = null;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            if ((findEntry == null || findEntry.getValue() < next.getValue()) && next.getValue() > array.length / 2) {
                findEntry = next;
            }
        }
        if (findEntry == null) {
            return 0;
        }
        return findEntry.getKey();
    }

    private HashMap<Integer, Integer> getCount(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 3, 4, 5, 4, 2};
        MoreThanHalfNum moreThanHalfNum = new MoreThanHalfNum();
        System.out.println(moreThanHalfNum.moreThanHalfNum(array));

        // TODO LinkedHashMap学习
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>(16, 0.75f, true);
        map.put(11, "aaaaa");
        map.put(12, "bbbbb");
        map.put(13, "ccccc");
        System.out.println(map.toString());
        map.get(11);
        System.out.println(map.toString());
    }
}
