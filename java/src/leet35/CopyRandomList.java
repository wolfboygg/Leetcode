package leet35;

import node.RandomNode;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class CopyRandomList {

    public RandomNode buildList() {
        RandomNode node1 = new RandomNode(7);
        RandomNode node2 = new RandomNode(3);
        RandomNode node3 = new RandomNode(1);
        RandomNode node4 = new RandomNode(0);
        RandomNode node5 = new RandomNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        return node1;
    }

    public RandomNode copyRandomList(RandomNode root) {
        // 先复制节点进行链接
        if (root == null) {
            return null;
        }
        RandomNode cur = root;
        while (cur != null) {
            RandomNode temp = new RandomNode(cur.value);
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }
        // 完成链接
        cur = root;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random;
            }
            cur = cur.next.next;
        }
        // 删除原来节点
        // cur 现在是复制的节点
        cur = root.next;
        RandomNode pre = root;
        RandomNode res = root.next;
        while (cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        // 处理原来的链表
        pre.next = null;
        return res;
    }


    public static void main(String[] args) {
        CopyRandomList copyRandomList = new CopyRandomList();
        RandomNode randomNode = copyRandomList.buildList();
        RandomNode randomNode1 = copyRandomList.copyRandomList(randomNode);
        while (randomNode1 != null) {
            String value1 = randomNode1.next == null ? "null" : randomNode1.next.value + "";
            String value2 = randomNode1.random == null ? "null" : randomNode1.random.value+"";
            System.out.println(randomNode1.value + "" + value1 + value2);
            randomNode1 = randomNode1.next;
        }

//        HashMap<String, String> map = new HashMap<>();
//        System.out.println(tableSizeFor(11));
//        ConcurrentHashMap
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 200) ? 200 : n + 1;
    }
}
