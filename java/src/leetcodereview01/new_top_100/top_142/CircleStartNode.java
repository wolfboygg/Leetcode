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

    public Node findCircleStart02(Node head) {
        // 找到入环点，就要找到是否存在环
        if (head == null) {
            return null;
        }
        boolean hasCircle = false;
        Node P1 = head;
        Node P2 = head;
        while(P2 != null && P2.next != null) {
            P1 = P1.next;
            P2 = P2.next.next;
            if (P1 == P2) {
                hasCircle = true;
                break;
            }
        }
        if (hasCircle) {
            P1 = head;
            while(P1 != P2) {
                P1 = P1.next;
                P2 = P2.next;
            }
            return P1;
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
        System.out.println(circleStartNode.findCircleStart02(node1).value);
    }

}
