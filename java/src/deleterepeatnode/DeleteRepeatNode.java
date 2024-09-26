package deleterepeatnode;

import node.Node;

public class DeleteRepeatNode {

    public Node createLinked() {
        Node node0 = new Node(1);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(2);
        Node node4 = new Node(3);
        Node node5 = new Node(3);
        Node node6 = new Node(4);
        Node node7 = new Node(4);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;
        return node0;
    }

    /**
     * 使用递归进行求解
     * @param head
     * @return
     */
    public Node deleteRepeatNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node next = head.next;
        if (head.value == next.value) {
            // 想等的情况下找到不相等的Node
            while (next != null && head.value == next.value) {
                next = next.next; // 这里的next有可能回为null
            }
            return deleteRepeatNode(next);
        } else {
            head.next = deleteRepeatNode(head.next);
            return head;
        }
    }


    public static void main(String[] args) {
        DeleteRepeatNode node = new DeleteRepeatNode();
        Node head = node.createLinked();
        Node resultNode = node.deleteRepeatNode(head);
        System.out.println(resultNode.value);
        while (resultNode.next != null) {
            resultNode = resultNode.next;
            System.out.println(resultNode.value);
        }
    }
}
