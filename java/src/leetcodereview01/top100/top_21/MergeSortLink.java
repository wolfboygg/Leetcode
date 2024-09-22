package leetcodereview01.top100.top_21;

import leetcodereview01.top100.top_19.DeleteTailKNode;

// 合并两个有序链表
public class MergeSortLink {

    static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node mergeLink(Node node1, Node node2) {
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

    public Node mergeLink01(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        Node node = new Node(-1);
        Node pre = node;
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
        pre.next =  node1 == null ? node2 : node1;
        return node.next;
    }

    public static void main(String[] args){

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(4);

        node1.next = node2;
        node2.next = node3;

        Node node4 = new Node(1);
        Node node5 = new Node(3);
        Node node6 = new Node(4);
        node4.next = node5;
        node5.next = node6;


        MergeSortLink mergeSortLink = new MergeSortLink();
        Node node = mergeSortLink.mergeLink01(node1, node4);
        while(node != null) {
            System.out.print(node.value);
            node = node.next;
        }
    }

}
