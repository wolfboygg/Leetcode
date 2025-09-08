package leetcodereview01.new_top_100.top_206;

public class ReverseLink {
    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node reverse(Node head) {
        if (head == null) {
            return null;
        }
        Node pre = new Node(-1);
        Node temp = pre;
        while(head != null) {
            Node next = head.next;
            head.next = temp.next;
            temp.next = head;
            head = next;
        }
        return pre.next;
    }

    public Node reverse01(Node head) {
        if (head == null) {
            return null;
        }
        Node pre = new Node(-1);
        Node temp = pre;
        while(head != null) {
            Node next = head.next;
            head.next = temp.next;
            temp.next= head;
            head = next;
        }
        return pre.next;
    }

    public Node reverse02(Node head) {
        if (head == null) {
            return null;
        }
        Node pre = new Node(-1);
        Node temp = pre;
        while(head != null) {
            Node next = head.next;
            head.next = temp.next;
            temp.next = head;
            head = next;
        }
        return pre.next;
    }

    public Node reverse03(Node head) {
        // 反转链表
        if (head == null) {
            return null;
        }
        Node pre = new Node(-1);
        Node temp = pre;
        while(head != null) {
            Node next = head.next;
            head.next = temp.next;
            temp.next = head;
            head = next;
        }
        return pre.next;
    }

    public Node reverse04(Node head) {
        if (head == null) {
            return null;
        }
        Node pre = new Node(-1);
        Node temp = pre;
        while(head != null) {
            Node next = head.next;
            head.next = pre.next;
            pre.next = head;
            head = next;
        }
        return pre.next;
    }

    public Node reverse05(Node head) {
        if (head == null) {
            return null;
        }
        Node pre = new Node(-1);
        Node temp = pre;
        while(head != null) {
            Node next = head.next;
            head.next = temp.next;
            temp.next = head;
            head = next;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ReverseLink reverseLink = new ReverseLink();
        Node node = reverseLink.reverse05(node1);
        while(node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }

    }
}
