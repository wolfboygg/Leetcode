package leetreview.printlink;

import java.util.*;

/**
 * 从尾到头打印列表
 */
public class PrintLinkFromTailToHead {

    private static List<Integer> list = new ArrayList<>();

    static class Node {
        private int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void printLinkFromTailToHeadByDG(Node headNode) {
        if (headNode == null) {
            return;
        }
        printLinkFromTailToHeadByDG(headNode.next);
        list.add(headNode.value);
    }

    /**
     * 通过栈进行辅助处理
     */
    public void printLinkFromTailToHeadByStack(Node headNode) {
        if (headNode == null) {
            return;
        }
        Stack<Integer> helpStack = new Stack<>();
        while (headNode != null) {
            helpStack.push(headNode.value);
            headNode = headNode.next;
        }
        while (!helpStack.isEmpty()) {
            list.add(helpStack.pop());
        }
    }

    /**
     * 通过头插法进行处理
     * @param headNode
     */
    public void printLinkFromTailToHeadByHeader(Node headNode) {
        Node helpNode = new Node(-1);
        while(headNode != null) {
            Node temp = headNode.next;
            headNode.next = helpNode.next;// 死循环了，先要赋值后面的next，要不然就是来回赋值
            helpNode.next = headNode;
            headNode = temp;
        }
        helpNode = helpNode.next;
        while(helpNode != null) {
            list.add(helpNode.value);
            helpNode = helpNode.next;

        }
    }

    public void printLinkFromTailToHeadByHeadPointer(Node headNode) {
        if (headNode == null) {
            return;
        }
        Node helpNode = new Node(-1);
        while(headNode != null) {
            Node temp = headNode.next;
            headNode.next = helpNode.next;
            helpNode.next = headNode;
            headNode = temp;
        }
        helpNode = helpNode.next;
        while(helpNode != null) {
            list.add(helpNode.value);
            helpNode = helpNode.next;

        }
    }

    public static void main(String[] args) {
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        PrintLinkFromTailToHead printLinkFromTailToHead = new PrintLinkFromTailToHead();
        list.clear();
        printLinkFromTailToHead.printLinkFromTailToHeadByDG(node0);
        System.out.println(list.toString());
        list.clear();
        printLinkFromTailToHead.printLinkFromTailToHeadByStack(node0);
        System.out.println(list);
        list.clear();
//        printLinkFromTailToHead.printLinkFromTailToHeadByHeader(node0);
        System.out.println(list);
        list.clear();
        printLinkFromTailToHead.printLinkFromTailToHeadByHeadPointer(node0);
        System.out.println(list);

        HashMap<Integer, Integer> indexOrder = new HashMap<>();
    }


}
