package leetcodereview01.jiandan.leetcode24;


public class ReverseLink {

    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node reverseLink02(Node head) {
        Node pre = new Node(-1);
        while(head != null) {
            Node temp = head.next;
            head.next = pre.next;
            pre.next = head;
            head = temp;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        Node node01 = new Node(1);
        Node node02 = new Node(2);
        Node node03 = new Node(3);
        Node node04 = new Node(4);
        Node node05 = new Node(5);
        node01.next = node02;
        node02.next = node03;
        node03.next = node04;
        node04.next = node05;
        ReverseLink reverseLink = new ReverseLink();
        Node node = reverseLink.reverseLink02(node01);
        while(node != null) {
            System.out.print(node.value);
            node = node.next;
        }
    }

    private Node reverseLink(Node head) {
        Node cur = new Node(-1);
        while (head != null) {
            Node temp = head.next;
            head.next = cur.next;
            cur.next = head;
            head = temp;

        }
        return cur.next;
    }
}
