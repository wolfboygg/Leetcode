package leetcodereview01.top100.top_160;

/**
 * 两个链表的相交的节点
 */
public class TowLinkXJNode {

    static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node findXJNode(Node node1, Node node2) {
        Node P1 = node1;
        Node P2 = node2;
        while (P1 != P2) {
            P1 = P1.next != null ? P1.next : node2;
            P2 = P2.next != null ? P2.next : node1;
        }
        return P1;
    }

    public Node findXJNode01(Node node1, Node node2) {
        // 快慢高
        Node first = node1;
        Node second = node2;
        while (first != second) {
            first = first.next == null ? node2 : first.next;
            second = second.next == null ? node1 : second.next;
        }
        return first;
    }


    public static void main(String[] args) {
        Node node1 = new Node(4);
        Node node2 = new Node(1);
        Node node3 = new Node(8);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        Node node6 = new Node(5);
        Node node7 = new Node(0);
        Node node8 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node6.next = node7;
        node7.next = node8;
        node8.next = node3;

        TowLinkXJNode xjNode = new TowLinkXJNode();
        Node node = xjNode.findXJNode01(node1, node6);
        System.out.println(node.value);
    }
}
