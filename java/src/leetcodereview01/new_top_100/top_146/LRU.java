package leetcodereview01.new_top_100.top_146;

import java.util.LinkedHashMap;
import java.util.Map;

/** 使用HashMap+双向链表的方式实现，其实直接使用LinkedHashMap即可 */
public class LRU extends LinkedHashMap<Integer, Integer> {

    public int capacity;

    public LRU(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public Integer put(Integer key, Integer value) {
        return super.put(key, value);
    }

    @Override
    public Integer get(Object key) {
        return super.get(key);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return this.size() > capacity;
    }

    public static void main(String[] args) {
        LRU lRUCache = new LRU(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));    // 返回 4

    }
}
