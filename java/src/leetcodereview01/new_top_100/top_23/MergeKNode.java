package leetcodereview01.new_top_100.top_23;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// 合并K个排序列表
public class MergeKNode {
    static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node merge(Node[] nodes) {
        // 使用辅助工具进行处理 堆 小头堆 辅助实现
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));
        for (Node node : nodes) {
            if (node != null) {
                queue.offer(node);
            }
        }
        Node temp = new Node(-1);
        Node pre = temp;
        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            temp.next = poll;
            temp = temp.next;
            Node next = poll.next;
            if (next != null) {
                queue.offer(next);
            }
        }
        return pre.next;
    }

    public Node merge01(Node[] node) {
        // 按顺序排序的合并链表，采用顺序队列的方式
        if (node == null || node.length == 0) {
            return null;
        }
        Queue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);
        for (Node node1 : node) {
            queue.offer(node1);
        }
        Node pre = new Node(-1);
        Node temp = pre;
        while(!queue.isEmpty()) {
            Node nodeRet = queue.poll();
            temp.next = nodeRet;
            temp = temp.next;
            if (nodeRet.next != null) {
                queue.offer(nodeRet.next);
            }
        }
        return pre.next;
    }

    // 合并多个链表，那么就需要上点手段了
    public Node merge02(Node[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }
        Node pre = new Node(-1);
        Node temp = pre;
        Queue<Node> queue = new PriorityQueue<>( (o1, o2) -> o1.value - o2.value);
        for (int i = 0; i < nodes.length; i++) {
            queue.offer(nodes[i]);
        }
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            Node next = node.next;
            temp.next = node;
            temp = temp.next;
            if (next != null) {
                queue.offer(next);
            }
        }
        return pre.next;
    }

    public Node merge03(Node[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }
        Queue<Node> queue = new PriorityQueue<Node>((o1, o2) -> o1.value - o2.value);
        for (int i = 0; i < nodes.length; i++) {
            queue.offer(nodes[i]);
        }
        Node pre = new Node(-1);
        Node temp = pre;
        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            Node next = poll.next;
            temp.next = poll;
            temp = temp.next;
            if (next != null) {
                queue.offer(next);
            }
        }
        return pre.next;
    }

    public Node merge04(Node[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }
        Queue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);
        for (int i = 0; i < nodes.length; i++) {
            queue.offer(nodes[i]);
        }
        Node node = new Node(-1);
        Node temp = node;
        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            Node next = poll.next;
            temp.next = poll;
            temp = temp.next;
            if (next != null) {
                queue.offer(next);
            }
        }
        return node.next;
    }


    public static void main(String[] args){
        //1->4->5,
        //1->3->4,
        //2->6
        Node node1 = new Node(1);
        Node node2 = new Node(4);
        Node node3 = new Node(5);

        node1.next = node2;
        node2.next = node3;

        Node node4 = new Node(1);
        Node node5 = new Node(3);
        Node node6 = new Node(4);
        node4.next = node5;
        node5.next = node6;

        Node node7 = new Node(2);
        Node node8 = new Node(6);
        node7.next = node8;

        Node[] nodes = {node1, node4, node7};
        MergeKNode mergeKNode = new MergeKNode();
        Node node = mergeKNode.merge04(nodes);
        while (node != null) {
            System.out.print(node.value);
            node = node.next;
        }

    }
}
