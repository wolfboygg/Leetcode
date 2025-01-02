package leetcodereview01.jiandan.leetcode06;

public class TailToHeadLink {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void printLinkByDG(Node head) {
        if (head.next != null) {
            printLinkByDG(head.next);
            System.out.print(head.value);
        } else {
            System.out.print(head.value);
        }
    }

    public void printLinkByNode(Node head) {
        Node newNode = new Node(-1);
        while (head != null) {
            Node temp = head.next;
            head.next = newNode.next;
            newNode.next = head;
            head = temp;
        }

        Node next = newNode.next;
        while (next != null) {
            System.out.print(next.value);
            next = next.next;
        }
    }

    public void printLinkByDG2(Node node) {
        if (node == null) {
            return;
        }
        printLinkByDG(node.next);
        System.out.print(node.value);
    }

    public void printLinkByHead(Node node) {
        Node newNode = new Node(-1);
        while (node != null) {
            Node tempNode = node.next;
            node.next = newNode.next;
            newNode.next = node;
            node = tempNode;
        }
        Node next = newNode.next;
        while (next != null) {
            System.out.print(next.value);
            next = next.next;
        }
    }

    public void printLinkByHead02(Node node) {
        // 使用头插法进行处理
        Node head = new Node(-1);
        while (node != null) {
            Node next = node.next;
            node.next = head.next;
            head.next = node;
            node = next;
        }
        Node newNode = head.next;
        while (newNode != null) {
            System.out.print(newNode.value);
            newNode = newNode.next;
        }
    }

    public void printLinkByHead03(Node node) {
        Node head = new Node(-1);
        while (node != null) {
            Node temp = node.next;
            node.next = head.next;
            head.next = node;
            node = temp;
        }
        head = head.next;
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

    public void printLinkByHead04(Node node) {
        // 添加头指针
        Node head = new Node(-1);
        while (node != null) {
            Node temp = node.next;
            node.next = head.next;
            head.next = node;
            node = temp;
        }
        head = head.next;
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

    public void printLinkByHead05(Node node) {
        // 添加头指针
        Node head = new Node(-1);
        while (node != null) {
            Node temp = node.next;
            node.next = head.next;
            head.next = node;
            node = temp;
        }
        head = head.next;
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

    public void printLinkByHead06(Node node) {
        if (node == null) {
            return;
        }
        Node head = new Node(-1);
        while (node != null) {
            Node temp = node.next;
            node.next = head.next;
            head.next = node;
            node = temp;
        }
        head = head.next;
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

    public void printLinkByHead07(Node head) {
        // 从尾到头打印节点 使用头插法
        Node node = new Node(-1);
        while (head != null) {
            Node next = head.next;
            head.next = node.next;
            node.next = head;
            head = next;
        }
        Node temp = node.next;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }

    }

    public void printLinkByHead08(Node head) {
        // 使用头插法进行打印链表
        if (head == null) {
            return;
        }
        Node pre = new Node(-1);
        while (head != null) {
            Node next = head.next;
            head.next = pre.next;
            pre.next = head;
            head = next;
        }
        pre = pre.next;
        while (pre != null) {
            System.out.print(pre.value);
            pre = pre.next;
        }
    }

    // 反转链表
    public void printLinkByHead09(Node head) {
        if (head == null) {
            return;
        }
        Node pre = new Node(-1);
        while (head != null) {
            Node next = head.next;
            head.next = pre.next;
            pre.next = head;
            head = next;
        }
        head = pre.next;
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

    public void printLinkByHead10(TailToHeadLink.Node head) {
        if (head == null) {
            return;
        }
        Node temp = new Node(-1);
        while(head != null) {
            Node next = head.next;
            head.next = temp.next;
            temp.next = head;
            head = next;
        }
        // 打印一下
        Node node = temp.next;
        while(node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        TailToHeadLink tailToHeadLink = new TailToHeadLink();
        TailToHeadLink.Node node01 = new TailToHeadLink.Node(1);
        TailToHeadLink.Node node02 = new TailToHeadLink.Node(2);
        TailToHeadLink.Node node03 = new TailToHeadLink.Node(3);
        TailToHeadLink.Node node04 = new TailToHeadLink.Node(4);
        TailToHeadLink.Node node05 = new TailToHeadLink.Node(5);
        node01.next = node02;
        node02.next = node03;
        node03.next = node04;
        node04.next = node05;
        tailToHeadLink.printLinkByHead10(node01);
    }
}
