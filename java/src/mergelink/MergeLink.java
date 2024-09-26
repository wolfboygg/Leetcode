package mergelink;

import node.Node;

public class MergeLink {

    public Node createLinkOne() {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        return node1;
    }

    public Node createLinkTwo() {
        Node node1 = new Node(2);
        Node node2 = new Node(4);
        Node node3 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        return node1;
    }

    public Node merge(Node link1, Node link2) {
        if (link1 == null || link2 == null) {
            return null;
        }
        Node head = new Node(0);
        Node cur = head;
        while (link1 != null && link2 != null) {
            if (link1.value < link2.value) {
                cur.next = link1;
                link1 = link1.next;
            } else {
                cur.next = link2;
                link2 = link2.next;
            }
            cur = cur.next;
        }
        cur.next = link1 == null ? link1 : link2;
        return head.next;
    }

    public static void main(String[] args) {
        MergeLink mergeLink = new MergeLink();
        Node linkOne = mergeLink.createLinkOne();
        Node linkTwo = mergeLink.createLinkTwo();
        Node result = mergeLink.merge(linkOne, linkTwo);
        while (result != null) {
            System.out.println(result.value);
            result = result.next;
        }
    }
}
