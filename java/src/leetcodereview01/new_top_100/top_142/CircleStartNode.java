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
        if (head == null) {
            return null;
        }
        Node slow = head;
        Node fast = head;
        boolean isHas = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isHas = true;
                break;
            }
        }
        if (isHas) {
            // 这里要同步移动
            Node start = head;
            while (start != slow) {
                start = start.next;
                slow = slow.next;
            }
            return slow;
        }
        return null;
    }

    // 找如环点
    public Node findCircleStart03(Node head) {
        if (head == null) {
            return null;
        }
        Node P1 = head;
        Node P2 = head;
        boolean isHas = false;
        while(P2 != null && P2.next != null) {
            P1 = P1.next;
            P2 = P2.next.next;
            if (P1 == P2) {
                isHas = true;
                break;
            }
        }
        if (isHas) {
            P2 = head;
            while (P1 != P2) {
                P1 = P1.next;
                P2 = P2.next;
            }
            return P1;
        }
        return null;
    }

    // 找入环节点
    public Node findCircleStart04(Node head) {
        if (head == null) {
            return null;
        }
        Node P1 = head;
        Node P2 = head;
        boolean isHas = false;
        while(P2 != null && P2.next != null) {
            P1 = P1.next;
            P2 = P2.next.next;
            if (P1 == P2) {
                isHas = true;
                break;
            }
        }
        if (isHas) {
            P2 = head;
            while(P1 != P2) {
                P1 = P1.next;
                P2 = P2.next;
            }
            return P1;
        }
        return null;
    }

    // 找到入环点
    public Node findCircleStart05(Node head) {
        if (head == null) {
            return null;
        }
        // 先判断是否有环
        boolean isHasCircle = false;
        Node P1 = head;
        Node P2 = head;
        while(P2 != null && P2.next != null) {
            P1 = P1.next;
            P2 = P2.next.next;
            if (P1 == P2) {
                isHasCircle = true;
                break;
            }
        }
        if (isHasCircle) {
            P1 = head;
            while(P1 != P2) {
                P2 = P2.next;
                P1 = P1.next;
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
        System.out.println(circleStartNode.findCircleStart05(node1).value);
    }

}
