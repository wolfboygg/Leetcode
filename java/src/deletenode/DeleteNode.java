package deletenode;

public class DeleteNode {

    class Node {
        int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node createLinked() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;
        return node1;
    }


    public void deleteNode(Node head, Node tobeDelete) {
        if (head == null || tobeDelete == null) {
            return;
        }
        if (tobeDelete.next != null) {// 表示删除的是中间节点
            // 这里进行值的覆盖
            Node next = tobeDelete.next;
            tobeDelete.value = next.value;
            tobeDelete.next = next.next;
        } else {
            if (head == tobeDelete) {
                head = null;
            } else {
                Node cur = head;
                while (cur.next != tobeDelete) {
                    cur = cur.next;
                }
                cur.next = null;
            }
        }
        Node forNode = head;
        if (forNode == null) {
            System.out.println("链表为空");
        } else {
            System.out.println(forNode.value);
            while (forNode.next != null) {
                forNode = forNode.next;
                System.out.println(forNode.value);
            }
        }
    }

    public static void main(String[] args) {
        DeleteNode deleteNode = new DeleteNode();
        Node head = deleteNode.createLinked();
        Node tobeDelete = head.next.next.next.next.next;
        deleteNode.deleteNode(head, tobeDelete);
    }
}
