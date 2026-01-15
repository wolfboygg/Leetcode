package leetcodereview01.jiandan.leetcode52;

public class LinkedFirstCommonNode {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void findCommonNode03(Node head1, Node head2) {
        Node P1 = head1;
        Node P2 = head2;
        while(P1 != P2) {
            // 三元表达式
            P1 = P1.next == null ? head2: P1.next;
            P2 = P2.next == null ? head1: P2.next;
//            if (P1.next == null) {
//                P1 = head2;
//            }
//            if (P2.next == null) {
//                P2 = head1;
//            }
//            P1 = P1.next;
//            P2 = P2.next;
        }
        System.out.println(P1.value);
    }

    public void findCommonNode04(Node node1, Node node2) {
        // 交换指针方案
        Node P1 = node1;
        Node P2 = node2;
        while(P1 != P2) {
            P1 = P1.next == null ? node2 : P1.next;
            P2 = P2.next == null ? node1 : P2.next;
        }
        System.out.println(P1.value);
    }

    public void findCommonNode05(Node node1, Node node2) {
        // 主要是通过指针交换
        Node P1 = node1;
        Node P2 = node2;
        while(P1 != P2) {
            P1 = P1.next == null ? node2: P1.next;
            P2 = P2.next == null ? node1 : P2.next;
        }
        System.out.println(P1.value);
    }

    public void findCommonNode06(Node node1, Node node2) {
        Node P1 = node1;
        Node P2 = node2;
        while(P1 != P2) {
            P1 = P1.next == null ? node2 : P1.next;
            P2 = P2.next == null ? node1 : P2.next;
        }
        System.out.println(P1.value);
    }

    public void findCommonNode07(Node node1, Node node2) {
        Node P1 = node1;
        Node P2 = node2;
        while(P1 != P2) {
            P1 = P1.next == null ? node2 : P1.next;
            P2 = P2.next == null ? node1 : P2.next;
        }
        System.out.println(P1.value);
    }

    public void findCommonNode08(Node node1, Node node2) {
        // 找到两个链表的第一个公共节点
        Node P1 = node1;
        Node P2 = node2;
        while(P1 != P2) {
            P1 = P1.next == null ? node2 : P1.next;
            P2 = P2.next == null ? node1 : P2.next;
        }
        System.out.println(P1.value);
    }

    public void findCommonNode09(Node node1, Node node2) {
        // 找到公共节点 使用快慢指针的方式进行切换
        Node P1 = node1;
        Node P2 = node2;
        while(P1 != P2) {
            P1 = P1 != null ? P1.next : node2;
            P2 = P2 != null ? P2.next : node1;
        }
        System.out.println(P1.value);
    }

    public void findCommonNode10(Node node1, Node node2) {
        // 找到两个链表中第一个公共的节点 使用双指针的方式
        Node P1 = node1;
        Node P2 = node2;
        while(P1 != P2) {
            P1 = P1 == null ? node2 : P1.next;
            P2 = P2 == null ? node1 : P2.next;
        }
        System.out.println(P1.value);
    }


    // 找到公共的节点 通过指针的交换方式进行处理
    public void findCommonNode11(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return;
        }
        Node P1 = node1;
        Node P2 = node2;
        while(P1 != P2) {
            P1 = P1 == null ? node2 : P1.next;
            P2 = P2 == null ? node1 : P2.next;
        }
        System.out.println(P1.value);
    }

    public void findCommonNode12(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return;
        }
        Node P1 = node1;
        Node P2 = node2;
        while(P1 != P2) {
            P1 = P1.next == null ? node2 : P1.next;
            P2 = P2.next == null ? node1 : P2.next;
        }
        System.out.println(P1.value);
    }


    public static void main(String[] args) {
        LinkedFirstCommonNode linkedFirstCommonNode = new LinkedFirstCommonNode();
        Node node00 = new Node(2);
        Node node01 = new Node(4);
        Node node02 = new Node(1);

        Node node011 = new Node(5);
        Node node012 = new Node(0);
        Node node013 = new Node(1);


        Node node03 = new Node(8);
        Node node04 = new Node(4);
        Node node05 = new Node(5);

        node00.next = node01;
        node01.next = node02;
        node02.next = node03;
        node03.next = node04;
        node04.next = node05;

        node011.next = node012;
        node012.next = node013;
        node013.next = node03;

        linkedFirstCommonNode.findCommonNode(node01, node011);
        linkedFirstCommonNode.findCommonNode12(node01, node011);

    }

    private void findCommonNode(Node head1, Node head11) {
        Node P1 = head1;
        Node P2 = head11;
        while (P1 != P2) {
            P1 = P1 == null ? head11 : P1.next;
            P2 = P2 == null ? head1 : P2.next;
        }
        System.out.println(P1.value);
    }

    private void findCommonNode02(Node head1, Node head2) {
        Node P1 = head1;
        Node P2 = head2;
        while(P1 != P2) {
            P1 = P1.next== null ? head2 : P1.next;
            P2 = P2.next == null ? head1: P2.next;
        }
        System.out.println(P1.value);
    }
}
