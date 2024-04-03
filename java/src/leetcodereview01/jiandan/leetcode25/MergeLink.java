package leetcodereview01.jiandan.leetcode25;

import leetcodereview01.jiandan.leetcode24.ReverseLink;

public class MergeLink {

    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node merge02(Node head01, Node head02) {
        Node preNode = new Node(-1);
        Node curNode = preNode;
        while (head01 != null && head02 != null) {
            if (head01.value > head02.value) {
                curNode.next = head02;
                curNode = head02;
                head02 = head02.next;
            } else {
                curNode.next = head01;
                curNode = head01;
                head01 = head01.next;
            }
        }
        curNode.next = head01 == null ? head02 : head01;
        return preNode.next;
    }

    public Node merge03(Node head1, Node head2) {
        // 需要使用两个节点记录当前节点和头节点。这个不要省略，否则找不到了
        // 判断那个链表完结了
        Node preNode = new Node(-1);
        Node cur = preNode;
        while(head1 != null && head2 != null) {
            if (head1.value > head2.value) {
                cur.next = head2;
                cur = head2;
                head2 = head2.next;
            } else {
                cur.next = head1;
                cur = head1;
                head1 = head1.next;
            }
        }
        cur.next = head1 == null ? head2 : head1;
        return preNode.next;
    }

    public Node merge04(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return null;
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

    public Node merge05(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        Node pre = new Node(-1);
        Node cur = pre;
        while(node1 != null && node2 != null) {
            if (node1.value > node2.value) {
                cur.next = node2;
                node2 = node2.next;
            } else {
                cur.next = node1;
                node1 = node1.next;
            }
            cur = cur.next;
        }
        cur.next = node1 == null ? node2 : node1;
        return pre.next;
    }

    // 合并两个排序的列表
    public Node merge06(Node node1, Node node2) {
        Node temp = new Node(-1);
        Node pre = temp;
        while(node1 != null && node2 != null) {
            if (node1.value > node2.value) {
                temp.next = node2;
                temp = temp.next;
                node2 = node2.next;
            } else {
                temp.next = node1;
                temp = temp.next;
                node1 = node1.next;
            }
        }
        temp.next = node1 == null ? node2 : node1;
        return pre.next;
    }

    // 合并两个排序的列表
    public Node merge07(Node node1, Node node2) {
        Node temp = new Node(-1);
        Node pre = temp;
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

    public Node merge08(Node node1, Node node2) {
        // 合并两个排序的链表
        Node pre = new Node(-1);
        Node temp = pre;
        while(node1 != null && node2 != null) {
            if (node1.value > node2.value) {
                pre.next = node2;
                node2 = node2.next;
            } else {
                pre.next = node1;
                node1 = node1.next;
            }
            pre = pre.next;
        }
        pre.next = node1 == null ? node2 : node1;
        return temp.next;
    }

    public Node merge09(Node node1, Node node2) {
        // 合并两个排序的链表
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

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(5);
        node1.next = node2;
        node2.next = node3;


        Node node4 = new Node(2);
        Node node5 = new Node(4);
        Node node6 = new Node(6);
        node4.next = node5;
        node5.next = node6;

        MergeLink mergeLink = new MergeLink();
        Node node = mergeLink.merge09(node1, node4);
        while (node != null) {
            System.out.print(node.value);
            node = node.next;
        }
    }

    // 先讲一个链表干完在直接链接后面的就好了
    private Node merge(Node head1, Node head2) {
        Node preNode = new Node(-1);
        Node cur = preNode;
        while (head1 != null && head2 != null) {
            if (head1.value > head2.value) {
                cur.next = head2;
                head2 = head2.next;
            } else {
                cur.next = head1;
                head1 = head1.next;
            }
            cur = cur.next;
        }
        cur.next = head1 == null ? head2 : head1;
        return preNode.next;
    }
}
