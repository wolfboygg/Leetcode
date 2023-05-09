package reverselink;

import node.Node;

public class ReverseLink {

    public Node createRingLinked() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;
        return node1;
    }

    public void reverseLinkByDG(Node head) {
        if (head != null) {
            reverseLinkByDG(head.next);
            System.out.println(head.value);
        }
    }

    public Node reverseLink(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = new Node(-1);
        while (head != null) {
            Node next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }
        return newHead.next;
    }


    public static void main(String[] args) {
        ReverseLink link = new ReverseLink();
        Node head = link.createRingLinked();
//        link.reverseLinkByDG(head);
        Node result = link.reverseLink(head);
        if (result == null) {
            System.out.println("为空");
            return;
        }
        while(result != null) {
            System.out.println(result.value);
            result = result.next;
        }
    }
}
