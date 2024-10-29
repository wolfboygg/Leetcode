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
        System.out.println(palindromeLink.isPalindromeLink(node1));
    }

}