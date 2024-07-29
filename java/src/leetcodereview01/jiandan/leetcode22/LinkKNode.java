package leetcodereview01.jiandan.leetcode22;

public class LinkKNode {

    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node getTailKNode(Node head, int k) {
        Node P1 = head;
        Node P2 = head;
        for (int i = 0; i < k; i++) {
            P1 = P1.next;
        }
        while(P1 != null) {
            P1 = P1.next;
            P2 = P2.next;
        }
        return P2;
    }

    public Node getTailKNode02(Node head, int k) {
        Node pre = head;
        for (int i = 0; i < k; i++) {
            pre = pre.next;
        }
        while(pre != null) {
            pre = pre.next;
            head = head.next;
        }
        return head;
    }

    public Node getTailKNode03(Node head, int k) {
        // k= n-(n-k)
        Node P1 = head;
        for (int i = 0; i < k; i++) {
            P1 = P1.next;
        }
        while(P1 != null) {
            head = head.next;
            P1 = P1.next;
        }
        return head;
    }

    /** 倒数第k个节点 */
    public Node getTailKNode04(Node head, int k) {
        // 先走k
        Node P1 = head;
        for (int i = 0; i < k; i++) {
            P1 = P1.next;
        }
        // 然后在走
        Node P2 = head;
        while(P1 != null) {
            P1 = P1.next;
            P2 = P2.next;
        }
        return P2;
    }

    public Node getTailKNode05(Node head, int k) {
        // 两个指针进行处理
        Node P1 = head;
        Node P2 = head;
        for (int i = 0; i < k; i++) {
            P1 = P1.next;
        }
        while(P1 != null) {
            P1 = P1.next;
            P2 = P2.next;
        }
        return P2;
    }

    public Node getTailKNode06(Node root, int k) {
        // 获取链表倒数第K个元素
        Node P1 = root;
        Node P2 = root;
        for (int i = 0; i < k; i++) {
            P1 = P1.next;
        }
        while(P1 != null) {
            P1 = P1.next;
            P2 = P2.next;
        }
        return P2;
    }

    public Node getTailKNode07(Node head, int k) {
        // 获取链表倒数第K个节点
        // 使用双指针进行处理 一个指针先走K个步骤，第二个指针和第一个指针 同时走，最后第二个指针的停止位置就是倒数第K个位置
        Node P1 = head;
        Node P2 = head;
        for (int i = 0; i < k; i++) {
            P1 = P1.next;
        }
        while(P1 != null) {
            P1 = P1.next;
            P2 = P2.next;
        }
        return P2;
        // 1 2 3 4 5  // 倒数4
    }

    public Node getTailKNode08(Node head, int k) {
        // 链表中倒数第K个节点
        Node pre = head;
        for (int i = 0; i < k; i++) {
            if (pre != null) {
                pre = pre.next;
            }
        }
        // 然后开始处理
        while(pre != null) {
            pre = pre.next;
            head = head.next;
        }
        return head;
    }

    // 1 2 3 4 5  k = 2
    public Node getTailKNode09(Node head, int k) {
        // 找到链表倒数第K个节点
        // 通过快慢指针的方式
        Node P1 = head;
        Node P2 = head;
        for (int i = 0; i < k; i++) {
            P1 = P1.next;
        }
        while(P1 != null) {
            P1 = P1.next;
            P2 = P2.next;
        }
        return  P2;
    }

    public Node getTailKNode10(Node head, int k) {
        // 倒数第K个节点
        if (k < 0 || head == null) {
            return null;
        }
        // 先走K步，然后在统一开始走
        Node P1 = head;
        Node P2 = head;
        for (int i = 0; i < k; i++) {
            P1 = P1.next;
        }
        while(P1 != null) {
            P1 = P1.next;
            P2 = P2.next;
        }

        return P2;
    }

    // 1, 2, 3, 4, 5
    public static void main(String[] args) {
        LinkKNode linkKNode = new LinkKNode();
        Node node01 = new Node(1);
        Node node02 = new Node(2);
        Node node03 = new Node(3);
        Node node04 = new Node(4);
        Node node05 = new Node(5);
        node01.next = node02;
        node02.next = node03;
        node03.next = node04;
        node04.next = node05;
        Node node = linkKNode.getTailKNode10(node01, 1);
        System.out.println(node.value);
    }
}
