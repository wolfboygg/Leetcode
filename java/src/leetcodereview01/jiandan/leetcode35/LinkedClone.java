package leetcodereview01.jiandan.leetcode35;

import node.RandomNode;

public class LinkedClone {

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode createLinked() {
        RandomListNode node1 = new RandomListNode(7);
        RandomListNode node2 = new RandomListNode(3);
        RandomListNode node3 = new RandomListNode(1);
        RandomListNode node4 = new RandomListNode(0);
        RandomListNode node5 = new RandomListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        return node1;
    }

    public RandomListNode clone(RandomListNode root) {
        if (root == null) {
            return null;
        }
        // 进行复制节点
        RandomListNode cur = root;
        while (cur != null) {
            RandomListNode node = new RandomListNode(cur.label);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        // 进行随机指针的复制
        cur = root;
        while (cur != null) {
            RandomListNode node = cur.next;
            if (cur.random != null) {
                node.random = cur.random.next;
            }
            cur = node.next;
        }
        // 只需要管新的链表即可，老得不管链接了
        cur = root.next;
        RandomListNode res = root.next;
        while (cur.next != null) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return res;
    }

    public static void main(String[] args) {
        LinkedClone linkedClone = new LinkedClone();
        RandomListNode linked = linkedClone.createLinked();
        RandomListNode randomNode1 = linkedClone.clone(linked);
        while (randomNode1 != null) {
            String value1 = randomNode1.next == null ? "null" : randomNode1.next.label + " ";
            String value2 = randomNode1.random == null ? "null" : randomNode1.random.label + " ";
            System.out.println(randomNode1.label + " " + value1 + value2);
            randomNode1 = randomNode1.next;
        }
    }
}
