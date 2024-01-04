package leetcodereview01.top100.top_02;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 */
public class TwoAdd {

    static class LinkNode {

        public LinkNode(int value) {
            this.value = value;
        }

        public int value;

        public LinkNode next;
    }

    // 主要是考虑好进位的问题
    public LinkNode towAdd(LinkNode node1, LinkNode node2) {
        LinkNode pre = new LinkNode(-1);
        LinkNode head = pre;
        int nextValue = 0;
        while(node1 != null || node2 != null || nextValue != 0) {
            int value = 0;
            if (node1 != null) {
                value += node1.value;
            }
            if (node2 != null) {
                value += node2.value;
            }
            int realValue = value % 10;
            LinkNode temp = new LinkNode(realValue + nextValue);
            nextValue = value / 10;
            System.out.println(temp.value);
            pre.next = temp;
            pre = temp;
            if (node1 != null) {
                node1 = node1.next;
            }
            if (node2 != null) {
                node2 = node2.next;
            }
        }
        // 再翻转一下
        LinkNode reverse = new LinkNode(-1);
        head = head.next;
        while(head != null) {
            LinkNode next = head.next;
            head.next = reverse.next;
            reverse.next = head;
            head = next;
        }
        return reverse.next;
    }

    public static void main(String[] args){
        LinkNode node1 = new LinkNode(2);
        LinkNode node2 = new LinkNode(4);
        LinkNode node3 = new LinkNode(3);

        node1.next = node2;
        node2.next = node3;


        LinkNode node4 = new LinkNode(5);
        LinkNode node5 = new LinkNode(6);
        LinkNode node6 = new LinkNode(6);

        node4.next = node5;
        node5.next = node6;

        TwoAdd twoAdd = new TwoAdd();
        LinkNode head = twoAdd.towAdd(node1, node4);
        while(head != null) {
            System.out.print(head.value);
            head = head.next;
        }
        System.out.println();

    }

}
