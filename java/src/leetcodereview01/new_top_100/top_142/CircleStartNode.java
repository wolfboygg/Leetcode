package leetcodereview01.new_top_100.top_142;

/**
 * 环形链表的入环点
 */
public class CircleStartNode {

    static class Node {
        public Node(int value) {
            this.value = value;
        }

        int value;
        Node next;

    }

    private Node findCircleStart(Node head) {
        if (head == null) {
            return null;
        }
        // 先找到环然后在快慢找
        Node fast = head;
        Node slow = head;
        boolean isHas = false;
        while(fast != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                isHas = true;
                break;
            }
        }
        if (isHas) {
            Node start = head;
            while(start != slow) {
                start = start.next;
                slow = slow.next;
            }
            return start;
        }
        return null;
    }

    public Node findCircleStart01(Node head) {
        if (head == null) {
            return null;
        }
        Node fast = head;
        Node slow = head;
        boolean hasCircle = false;
        while(fast != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasCircle = true;
                break;
            }
        }
        // 需要判断
        if (hasCircle) {
            Node start = head;
            while(start != slow) {
                start = start.next;
                slow = slow.next;
            }
            return slow;
        }
        return null;
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
        node6.next = node3;
        CircleStartNode circleStartNode = new CircleStartNode();
        System.out.println(circleStartNode.findCircleStart(node1).value);
    }

}
