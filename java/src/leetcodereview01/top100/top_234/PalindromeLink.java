package leetcodereview01.top100.top_234;

/**
 * 回文列表
 */
public class PalindromeLink {
    static class Node  {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public boolean isPalindrome(Node head) {
        // 解题思路 1.先找到回文的头节点。通过快慢指针
        // 2.通过列表翻转的方式翻转找到回文头的后续节点。
        // 3.通过列表遍历进行比较
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 然后翻转列表
        Node pHead = slow.next;
        slow.next = null; // 将第一个链表后续重置为null
        while(pHead != null) {
            Node next = pHead.next;
            pHead.next = slow.next;
            slow.next = pHead;
            pHead = next;
        }
        // 然后进行比较
        pHead = slow.next;
        slow.next = null; // 这里需要重置为null 不然会和翻转的链表连接起来
        slow = head;
        while(pHead != null && slow != null) {
            System.out.println("pHead:" + pHead.value);
            System.out.println("slow:" + slow.value);
            if (pHead.value != slow.value) {
                return false;
            }
            pHead = pHead.next;
            slow = slow.next;
        }
        return pHead == null && slow == null;
    }


    public static void main(String[] args){
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
        System.out.println(palindromeLink.isPalindrome(node1));
    }

}
