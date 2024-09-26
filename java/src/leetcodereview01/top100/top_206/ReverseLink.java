package leetcodereview01.top100.top_206;

/**
 * 翻转链表 使用头插法进行处理
 */
public class ReverseLink {
    static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node reverseNode(Node head) {
        Node temp = new Node(-1);
        while(head != null) {
            Node next = head.next;
            head.next = temp.next;
            temp.next = head;
            head = next;
        }
        return temp.next;
    }

    public Node reverseLink(Node head) {
        // 头插法
        if (head == null) {
            return null;
        }
        Node pre = new Node(-1);
        while(head != null) {
            Node next = head.next;
            head.next = pre.next;
            pre.next = head;
            head = next;
        }
        return pre.next;
    }

    public static void main(String[] args){
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
        Node node = reverseLink.reverseLink(node1);
        while(node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }
}
