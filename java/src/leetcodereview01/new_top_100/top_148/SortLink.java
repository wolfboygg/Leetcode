package leetcodereview01.new_top_100.top_148;

public class SortLink {
    // 使用二分的方式进行处理，注意右边处理一下mid

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node sortLink(Node head, Node tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        Node slow = head;
        Node fast = head;
        // 这里不能直接使用null 因为比如左边就不可能为null
        // 所以要判断是否等于tail
        while(fast != tail) {
            fast = fast.next;
            slow = slow.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        Node mid = slow;
        System.out.println(head.value + "--->" + slow.value);
        Node node1 = sortLink(head, mid);
        Node node2 = sortLink(mid, tail);
        return merge(node1, node2);
    }

    public Node merge(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        // 合并排序链表
        Node pre = new Node(-1);
        Node temp = pre;
        while(node1 != null && node2 != null) {
            if (node1.value > node2.value) {
                temp.next = node2;
                node2 = node2.next;
            } else {
                temp.next = node1;
                node1 = node1.next;
            }
            temp = temp.next;
        }
        temp.next = node1 == null ? node2 : node1;
        return pre.next;
    }

    public static void main(String[] args) {
        Node node1 = new Node(4);
        Node node2 = new Node(2);
        Node node3 = new Node(1);
        Node node4 = new Node(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        SortLink sortLink = new SortLink();
        Node node = sortLink.sortLink(node1, null);
        while(node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }
}
