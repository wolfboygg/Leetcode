package leetcodereview01.new_top_100.top_19;

/**
 * 删除链表的倒数第N个节点
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
public class DeleteTailKNode {
    static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    // 删除列表的倒数第K个节点，解题思路就是通过两个指针进行走处理
    public Node deleteTailKNode(Node head, int k) {
        // 删除倒数第K个节点，那么使用两个指针，第一个先走K，第二个指针从开始走，第一个走到尾部，第二个就到了倒数第k个节点了
        Node P1 = head;
        Node P2 = head;
        for (int i = 0; i < k; i++) {
            P1 = P1.next;
        }
        while(P1 != null) {
            P1 = P1.next;
            P2 = P2.next;
        }
        // 这里进行删除

        Node next  = P2.next;
        P2.value = next.value;
        P2.next = next.next;
        return head;
    }

    public Node deleteTailKNode01(Node head, int n) {
        //  删除链表倒数第K个节点
        // 要保证删除的一定不是最后一个节点 要找到前一个节点
        Node pre = head;
        //  1->2->3->4->5 n = 2
        for (int i = 0; i < n; i++) {
            pre = pre.next;
        }
        Node temp = head;
        while(pre != null) {
            temp = temp.next;
            pre = pre.next;
        }
        // 进行删除
        Node next = temp.next;
        temp.value = next.value;
        temp.next = next.next;
        return head;
    }

    /** 删除倒数K个节点 */
    public Node deleteTailKNode02(Node node, int k) {
        // 先走K步，然后到结束
        if (node == null) {
            return null;
        }
        Node pre = node;
        Node temp = pre;
        for (int i = 0; i < k; i++) {
            temp = temp.next;
        }
        while(temp != null) {
            temp = temp.next;
            pre = pre.next;
        }
        // 这里要进行判断
        if (node == pre) {
            return node.next;
        }
        if (pre.next == null) {
            // 找到前一个
            Node newTemp = node;
            while (newTemp.next != pre) {
                newTemp = newTemp.next;
            }
            newTemp.next = null;
        } else {
            Node next = pre.next;
            pre.value = next.value;
            pre.next = next.next;
        }
        return node;
    }

    public Node deleteTailKNode03(Node head, int target) {
        if (head == null) {
            return null;
        }
        Node P1 = head;
        Node P2 = head;
        for (int i = 0; i < target; i++) {
            P1 = P1.next;
        }
        while(P1 != null) {
            P1 = P1.next;
            P2 = P2.next;
        }
        // 查看P2然后删除
        if (P2.next != null) {
            Node next = P2.next;
            P2.value = next.value;
            P2.next = next.next;
        } else {
            if (P2 == head) {
                head = null;
            } else {
                // 需要找到前一个
                Node temp = head;
                while(temp.next != P2) {
                    temp = temp.next;
                }
                temp.next = null;
            }
        }
        return head;
    }

    public Node deleteTailKNode04(Node head, int k) {
        // 删除倒数第K个节点
        if (head == null) {
            return null;
        }
        Node P1 = head;
        Node P2 = head;
        for (int i = 0; i < k; i++) {
            P1 = P1.next;
        }
        while(P1 != null) {
            P1 = P1.next;
            P2 = P2.next;
        }
        // 然后删除节点
        if (P2.next != null) {
            Node next = P2.next;
            P2.value = next.value;
            P2.next = next.next;
        } else {
            if (P2 == head) {
                head = null;
            } else {
                // 这里需要遍历找到前一个才能处理
                P1 = head;
                while(P1.next != P2) {
                    P1 = P1.next;
                }
                P1.next = null;
            }
        }
        return head;
    }

    public static void main(String[] args){
        // 给定一个链表: 1->2->3->4->5, 和 n = 2.
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        DeleteTailKNode deleteTailKNode = new DeleteTailKNode();
        Node node = deleteTailKNode.deleteTailKNode04(node1, 1);
        while(node != null) {
            System.out.print(node.value);
            node = node.next;
        }
    }
}
