package leetcodereview01.new_top_100.top_141;

public class CircleLink {

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public boolean isCircle(Node node) {
        if (node == null) {
            return false;
        }
        // 通过快慢指针进行判断 追上就干
        Node slow = node;
        Node fast = node;
        while(slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


    public boolean isCircle01(Node node) {
        if (node == null) {
            return false;
        }
        Node fast = node;
        Node slow = node;
        while(fast != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public boolean isCircle02(Node head) {
        // 判断链表是否有环
        if (head == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        CircleLink circleLink = new CircleLink();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next= node5;
        node5.next = node6;
        node6.next = node3;
        boolean circle = circleLink.isCircle02(node1);
        System.out.println(circle);
    }
}
