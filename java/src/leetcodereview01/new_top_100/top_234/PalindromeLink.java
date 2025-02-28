package leetcodereview01.new_top_100.top_234;

public class PalindromeLink {

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    // 判断是否是回文链表
    public boolean isPalindromeLink(Node head) {
        if (head == null) {
            return false;
        }
        /**
         * 方案就是找到对称的链表进行翻转，之后在进行链表遍历比较
         */
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node pHead = slow.next;
        // 进行翻转
        Node temp = new Node(-1);
        while (pHead != null) {
            Node next = pHead.next;
            pHead.next = temp.next;
            temp.next = pHead;
            pHead = next;
        }
        Node node1 = head;
        Node node2 = temp.next;
        while (node2 != null) {
            if (node1.value != node2.value) {
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;
    }

    // 回文链表其实就是找到中心位置进行反转比较
    public boolean isPalindromeLink01(Node head) {
        // 首先通过快慢指针找到中心位置，然后反转之后比较
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node pHead = slow.next;
        Node pre = new Node(-1);
        while (pHead != null) {
            Node next = pHead.next;
            pHead.next = pre.next;
            pre.next = pHead;
            pHead = next;
        }
        Node node1 = head;
        Node node2 = pre.next;
        while (node2 != null) {
            if (node1.value != node2.value) {
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;
    }

    public boolean isPalindromeLink02(Node head) {
        if (head == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 然后进行判断
        Node pHead = new Node(-1);
        // 这里要走到下一个
        slow = slow.next;
        while (slow != null) {
            Node next = slow.next;
            slow.next = pHead.next;
            pHead.next = slow;
            slow = next;
        }
        // 然后在进行比较判断
        Node temp = pHead.next;
        while (temp != null) {
            if (head.value != temp.value) {
                return false;
            }
            head = head.next;
            temp = temp.next;
        }
        return true;
    }

    // 1 2 3 4 5
    public boolean isPalindromeLink03(Node head) {
        if (head == null) {
            return false;
        }

        Node P1 = head;
        Node P2 = head;
        if (P2.next != null && P2.next.next != null) {
            P1 = P1.next;
            P2 = P2.next.next;
        }
        Node newHead = P1.next;
        P1.next = null;
        // 反转
        Node pre = new Node(-1);
        Node temp = pre;
        while (newHead != null) {
            Node next = newHead.next;
            newHead.next = temp.next;
            temp.next = newHead;
            newHead = next;
        }
        // 开始比较
        Node node1 = head;
        Node node2 = pre.next;
        while (node2 != null) {
            if (node1.value != node2.value) {
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;
    }

    // 回文链表
    public boolean isPalindromeLink04(Node head) {
        if (head == null) {
            return false;
        }
        // 先找到中心点，然后进行比较
        Node P1 = head;
        Node P2 = head;
        // 1 2  4 5
        while(P2 != null && P2.next != null) {
            P1 = P1.next;
            P2 = P2.next.next;
        }
        Node start = P1.next;
        P1.next = null;
        while(start != null) {
            if (start.value != head.value) {
                return false;
            }
            start = start.next;
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(2);
        Node node4 = new Node(1);
        Node node5 = new Node(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        PalindromeLink palindromeLink = new PalindromeLink();
        System.out.println(palindromeLink.isPalindromeLink04(node1));
    }

}
