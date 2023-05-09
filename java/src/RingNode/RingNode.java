package RingNode;

import node.Node;

public class RingNode {

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
        node6.next = node3;
        return node1;
    }


    /**
     * 先假定这个给定的就是一个有环的链表，那么我们需要这样操作
     * 给定两个指针，第一次我们让一个快，一个慢，追上以后。我们让两一个指针再次重头开始
     * 这时候再次相遇就是入环点
     *
     * @param head
     * @return
     */
    public Node findRingEnterNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node p1 = head;
        Node p2 = head;
        do {
            p1 = p1.next;
            p2 = p2.next.next;
        } while (p1 != p2);
        p2 = head;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    /**
     * 判断是否有环还是要通过指针追赶的方式进行判断，如果没有环可能回返回一个null
     * @param args
     */

    public static void main(String[] args) {
        RingNode ringNode = new RingNode();
        Node ringLinked = ringNode.createRingLinked();
        Node result = ringNode.findRingEnterNode(ringLinked);
        System.out.println(result.value);
    }
}
