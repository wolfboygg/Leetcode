package leetcodereview01.new_top_100.top_02;

/**
 * 两数相加 两个链表
 */
public class TwoAddLink {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumber(ListNode node1, ListNode node2) {
        ListNode pre = new ListNode(-1);
        ListNode temp = pre;
        int carry = 0;
        while (node1 != null && node2 != null) {
            ListNode node = new ListNode(carry);
            node.val += node1.val;
            node.val += node2.val;
            carry = node.val / 10;
            node.val %= 10;
            temp.next = node;
            temp = temp.next;
            node1 = node1.next;
            node2 = node2.next;
        }
        if (carry != 0 && node1 == null && node2 == null) {
            ListNode node = new ListNode(carry);
            temp.next = node;
        } else {
            temp.next = node1 == null ? node2 : node1;
            temp = temp.next;
            temp.val += carry;
        }

        // 反转
        ListNode newNode = new ListNode(-1);
        pre = pre.next;
        while (pre != null) {
            ListNode next = pre.next;
            pre.next = newNode.next;
            newNode.next = pre;
            pre = next;
        }
        return newNode.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        TwoAddLink twoAddLink = new TwoAddLink();
        ListNode node = twoAddLink.addTwoNumber(node1, node4);
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
    }

}
