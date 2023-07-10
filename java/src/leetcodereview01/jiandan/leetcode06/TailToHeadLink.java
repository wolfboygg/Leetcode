package leetcodereview01.jiandan.leetcode06;

public class TailToHeadLink {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void printLinkByDG(Node head) {
        if (head.next != null) {
            printLinkByDG(head.next);
            System.out.print(head.value);
        } else {
            System.out.print(head.value);
        }
    }

    public void printLinkByNode(Node head) {
        Node newNode = new Node(-1);
        while (head != null) {
            Node temp = head.next;
            head.next = newNode.next;
            newNode.next = head;
            head = temp;
        }

        Node next = newNode.next;
        while (next != null) {
            System.out.print(next.value);
            next = next.next;
        }
    }

    public void printLinkByDG2(Node node) {
        if (node == null) {
            return;
        }
        printLinkByDG(node.next);
        System.out.print(node.value);
    }

    public void printLinkByHead(Node node) {
        Node newNode = new Node(-1);
        while (node != null) {
            Node tempNode = node.next;
            node.next = newNode.next;
            newNode.next = node;
            node = tempNode;
        }
        Node next = newNode.next;
        while (next != null) {
            System.out.print(next.value);
            next = next.next;
        }
    }


    public static void main(String[] args) {
        TailToHeadLink tailToHeadLink = new TailToHeadLink();
        TailToHeadLink.Node node01 = new TailToHeadLink.Node(1);
        TailToHeadLink.Node node02 = new TailToHeadLink.Node(2);
        TailToHeadLink.Node node03 = new TailToHeadLink.Node(3);
        TailToHeadLink.Node node04 = new TailToHeadLink.Node(4);
        TailToHeadLink.Node node05 = new TailToHeadLink.Node(5);
        node01.next = node02;
        node02.next = node03;
        node03.next = node04;
        node04.next = node05;
        tailToHeadLink.printLinkByHead(node01);
    }
}
