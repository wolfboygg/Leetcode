package leetcodereview01.new_top_100.top_21;

/**
 * 合并两个有序的链表
 */
public class MergeLinkedList {

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }


    private Node merge(Node node1, Node node2) {
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
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.next = node3;
        node3.next = node5;

        node2.next = node4;

        MergeLinkedList mergeLinkedList = new MergeLinkedList();
        Node merge = mergeLinkedList.merge(node1, node2);
        while (merge != null) {
            System.out.print(merge.value + " ");
            merge = merge.next;
        }
    }


}
