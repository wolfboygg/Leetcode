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
        Node node = linkKNode.getTailKNode05(node01, 4);
        System.out.println(node.value);
    }
}
