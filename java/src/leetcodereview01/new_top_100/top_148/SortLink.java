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

    public Node sortLink01(Node head, Node tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        // 通过二分的方式在进行merge 主要方式还是递归
        Node P1 = head;
        Node P2 = head;
        while(P2 != tail) {
            P1 = P1.next;
            P2 = P2.next.next;
        }
        Node mid = P1;
        Node left = sortLink01(head, mid);
        Node right = sortLink01(mid, tail);
        return merge01(left, right);
    }

    public Node merge01(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
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

    public Node sortLink02(Node start, Node tail) {
        if (start == null) {
            return null;
        }
        if (start.next == tail) {
            start.next = null;
            return start;
        }
        Node P1 = start;
        Node P2 = start;
        while(P2 != tail && P2.next != null) {
            P1 = P1.next;
            P2 = P2.next.next;
        }
        Node mid = P1;
        Node left = sortLink02(start, mid);
        Node right = sortLink02(mid, tail);
        return merge02(left, right);
    }

    public Node merge02(Node node1, Node node2) {
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

    // 使用递归加merge的方式进行排序
    public Node sortLink03(Node head, Node tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        Node P1 = head;
        Node P2 = head;
        while(P2 != null && P2.next != tail) {
            P1 = P1.next;
            P2 = P2.next.next;
        }
        Node mid = P1;
        Node left = sortLink03(head, mid);
        Node right = sortLink03(mid, tail);
        return merge03(left, right);
    }

    public Node merge03(Node node1, Node node2) {
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

    // 找到中间值进行排序
    public Node sortLink04(Node head, Node tail) {
        // 二分进行排序
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        Node pre = head;
        Node temp = head;
        while( pre != tail && pre.next != null) {
            temp = temp.next;
            pre = pre.next.next;
        }
        Node middle = temp;
        Node left = sortLink04(head, middle);
        Node right = sortLink04(middle, tail);
        return merge01(left, right);
    }

    // 找到中心点，开始排序合并
    public Node sortLink05(Node head, Node tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head; // 这里不能穿透 必须返回 已经到最后一个，那么就是最后一个
        }
        Node P1 = head;
        Node P2 = head;
        while(P2 != null && P2.next != null) {
            P1 = P1.next;
            P2 = P2.next.next;
        }
        Node left = sortLink05(head, P1);
        Node right = sortLink05(P1, tail);
        return merge03(left, right);
    }

    public Node merge06(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        if (node1 == null || node2 == null) {
            return node1 == null ? node2 : node1;
        }
        Node pre = new Node(-1);
        Node temp = pre;
        while(node1 != null && node2 != null) {
            if (node1.value < node2.value) {
                temp.next = node1;
                node1 = node1.next;
            } else {
                temp.next = node2;
                node2 = node2.next;
            }
            temp = temp.next;
        }
        temp.next = node1 == null ? node2 : node1;
        return pre.next;
    }

    // 排序列表。通过二分排序然后在merge 通过递归的方式进行排序，需要知道head 和 tail
    public Node sortLink06(Node head, Node tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        System.out.println("head:" + head.value + ",tail:" + (tail == null ? "null" : tail.value));
        // 找到中心点开始处理
        Node slow = head;
        Node fast = head;
        // 边界条件要对
        while(fast != tail && fast.next != null) { // 这里要递归，那么就需要判断是否需要等于tail，而不是直接为末尾
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("slow:" + slow.value);
        Node left = sortLink06(head, slow);
        Node right = sortLink06(slow, tail);
        return merge06(left, right);
    }


    public Node sortLink07(Node head, Node tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        Node P1 = head;
        Node P2 = head;
        while(P2 != tail && P2.next != null) {
            P1 = P1.next;
            P2 = P2.next.next;
        }
        Node left = sortLink07(head, P1);
        Node right = sortLink07(P1, tail);
        return merge(left, right);
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
        Node node = sortLink.sortLink07(node1, null);
        while(node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }
}
