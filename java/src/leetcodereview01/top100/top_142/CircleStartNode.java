package leetcodereview01.top100.top_142;

import leetcodereview01.top100.top_141.HasCircle;

/**
 * 返回如环节点
 */
public class CircleStartNode {
    static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node findStartNode(Node head) {
        // 先判断是否有环，然后再进行找到入口
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = head;
                break;
            }
        }
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
    
    public static void main(String[] args){
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(0);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        CircleStartNode circleStartNode = new CircleStartNode();
        Node node = circleStartNode.findStartNode(node1);
        System.out.println(node.value);

    }
}
