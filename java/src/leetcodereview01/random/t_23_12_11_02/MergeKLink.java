package leetcodereview01.random.t_23_12_11_02;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * merge K 个有序链表
 * 借助一个堆实现
 */
public class MergeKLink {
    static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 解题思路通过一个遍历将各个头节点入堆。借助堆排序进行链接
     * @param nodes
     */
    private Node merge(Node[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }
        Queue<Node> queue = new PriorityQueue<Node>((o1, o2) -> o1.value - o2.value);
        for (Node node : nodes) {
            queue.offer(node);
        }
        Node pre = new Node(-1);
        Node temp = pre;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            pre.next = new Node(poll.value);
            pre = pre.next;
            if (poll.next != null) {
                queue.offer(poll.next);
            }
        }
        return temp.next;
    }
    public static void main(String[] args){
       Node node1 = new Node(0);
       Node node2 = new Node(1);
       Node node3 = new Node(5);

       Node node4 = new Node(2);
       Node node5 = new Node(3);
       Node node6 = new Node(7);

       Node node7 = new Node(4);
       Node node8 = new Node(8);

       node1.next = node2;
       node2.next = node3;

       node4.next = node5;
       node5.next = node6;

       node7.next = node8;

       Node[] nodes = {node1, node4, node7};
       MergeKLink mergeKLink = new MergeKLink();
       Node node = mergeKLink.merge(nodes);
       while(node != null) {
           System.out.print(node.value + " ");
           node = node.next;
       }

    }

}
