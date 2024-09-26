package FindKTail;

import node.Node;

/**
 * 找到一个链表倒数第K个节点
 */
public class FindKTail {

    public Node createLinkedList() {
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
        node6.next = null;
        return node1;
    }

    public Node findKTail(Node head, int k) {
        if (head == null) {
            return null;
        }
        Node p1 = head;
        while (p1 != null && k-- > 0) {
            p1 = p1.next;
        }
        // 找到K的位置
        if (k > 0) {
            // 做一个防止错误数据的操作
            return null;
        }
        // 放到这里更合理防止提前返回
        Node p2 = head;
        while(p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public static void main(String[] args) {
        FindKTail findKTail = new FindKTail();
        Node head = findKTail.createLinkedList();
        Node result = findKTail.findKTail(head, 3);
        System.out.println(result.value);
    }
}
