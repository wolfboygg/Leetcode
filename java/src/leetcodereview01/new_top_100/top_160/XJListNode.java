package leetcodereview01.new_top_100.top_160;

// 相交链表
public class XJListNode {

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node findXJNode(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        Node pre1 = node1;
        Node pre2 = node2;
        while (pre1 != pre2) {
            pre1 = pre1.next == null ? node2 : pre1.next;
            pre2 = pre2.next == null ? node1 : pre2.next;
        }
        return pre2;
    }


    public static void main(String[] args) {
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

        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);

        node7.next = node8;
        node8.next = node9;
        node9.next = node4;

        XJListNode xjListNode = new XJListNode();
        Node xjNode = xjListNode.findXJNode(node1, node7);
        System.out.println(xjNode.value);
    }
}
