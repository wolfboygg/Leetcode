package leetcodereview01.xhs_code;

public class ReverseLink {

    static class Node {

        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void reverse(Node head) {
        if (head == null) {
            return;
        }
        Node pre = new Node(-1);
        while(head != null) {
            Node next = head.next;
            head.next = pre.next;
            pre.next = head;
            head = next;
        }
        Node newHead = pre.next;
        while(newHead != null) {
            System.out.print(newHead.value + " ");
            newHead = newHead.next;
        }
    }

    public void reverse01(Node node) {
        if (node == null) {
            return;
        }
        Node temp = new Node(-1);
        Node pre = temp;
        while(node != null) {
            Node next = node.next;
            node.next = temp.next;
            temp.next = node;
            node = next;
        }
        pre = pre.next;
        while(pre != null) {
            System.out.print(pre.value + " ");
            pre = pre.next;
        }

    }

    public static void main(String[] args) {
        Node node1 = new Node(0);
        Node node2 = new Node(1);
        Node node3 = new Node(2);
        Node node4 = new Node(3);
        Node node5 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ReverseLink link = new ReverseLink();
        link.reverse01(node1);
    }


}
