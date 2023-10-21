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

    public RandomListNode clone01(RandomListNode node) {
        // 复杂链表的复制，先进行挨个复制，然后在拆分
        if (node == null) {
            return null;
        }
        RandomListNode head = node;
        while(head != null) {
            RandomListNode temp = new RandomListNode(head.label);
            temp.next = head.next;
            head.next = temp;
            head = temp.next;
        }
        // 进行随机节点链接
        head = node;
        while(head != null) {
            RandomListNode next = head.next;
            if (head.random != null) {
                next.random = head.random.next;
            }
            head = next.next;
        }
        // 进行拆分
        head = node.next;
        RandomListNode res = head;
        while(head.next != null) {
            RandomListNode next = head.next;
            head.next = next.next;
            head = head.next;
        }
        return res;
    }

    public RandomListNode clone02(RandomListNode node) {
        // 先复制后续，在复制随机，然后再进行拆分
        RandomListNode cur = node;
        while(cur != null) {
            RandomListNode next = cur.next;
            RandomListNode temp = new RandomListNode(cur.label);
            temp.next = next;
            cur.next = temp;
            cur = next;
        }

        // 进行随机复制
        cur = node;
        while(cur != null) {
            RandomListNode next = cur.next;
            next.random = cur.random;
            cur = next.next;
        }

        // 进行拆分
        cur = node.next;
        RandomListNode root = cur;
        while (cur.next != null) { // 这里要判断下一个是否为null
            RandomListNode next = cur.next.next;
            cur.next = next;
            cur = next;
        }
        return root;
    }

    // 复杂链表的复制
    public RandomListNode clone03(RandomListNode root) {
        // 复制方案就是先挨个在每一个连标的后面clone一个相同的节点，然后在链接随机节点，最后断开
        RandomListNode temp = root;
        while(temp != null) {
            RandomListNode node = new RandomListNode(temp.label);
            RandomListNode next = temp.next;
            node.next = next;
            temp.next = node;
            temp = next;
        }
        temp = root;
        // 连接随机节点
        while(temp != null) {
            RandomListNode next = temp.next;
            next.random = temp.random;
            temp = next.next;
        }
        // 拆分
        temp = root.next;
        RandomListNode cur = temp;
        while(temp.next != null) {
            RandomListNode node = temp.next.next;
            temp.next = node;
            temp = node;
        }
        return cur;
    }

    public static void main(String[] args) {
        LinkedClone linkedClone = new LinkedClone();
        RandomListNode linked = linkedClone.createLinked();
        RandomListNode randomNode1 = linkedClone.clone02(linked);
        while (randomNode1 != null) {
            String value1 = randomNode1.next == null ? "null" : randomNode1.next.label + " ";
            String value2 = randomNode1.random == null ? "null" : randomNode1.random.label + " ";
            System.out.println(randomNode1.label + " " + value1 + value2);
            randomNode1 = randomNode1.next;
        }
    }
}
