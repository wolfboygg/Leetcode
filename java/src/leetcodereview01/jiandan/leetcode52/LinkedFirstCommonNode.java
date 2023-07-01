package leetcodereview01.jiandan.leetcode52;

public class LinkedFirstCommonNode {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }


    public static void main(String[] args) {
        LinkedFirstCommonNode linkedFirstCommonNode = new LinkedFirstCommonNode();
        Node node01 = new Node(4);
        Node node02 = new Node(1);

        Node node011 = new Node(5);
        Node node012 = new Node(0);
        Node node013 = new Node(1);


        Node node03 = new Node(8);
        Node node04 = new Node(4);
        Node node05 = new Node(5);

        node01.next = node02;
        node02.next = node03;
        node03.next = node04;
        node04.next = node05;

        node011.next = node012;
        node012.next = node013;
        node013.next = node03;

        linkedFirstCommonNode.findCommonNode(node01, node011);

    }

    private void findCommonNode(Node head1, Node head11) {
        Node P1 = head1;
        Node P2 = head11;
        while (P1 != P2) {
            P1 = P1 == null ? head11 : P1.next;
            P2 = P2 == null ? head1 : P2.next;
        }
        System.out.println(P1.value);
    }
}
