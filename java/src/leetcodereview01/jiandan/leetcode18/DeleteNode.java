package leetcodereview01.jiandan.leetcode18;

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

    public void deleteNode(Node head, Node deleteNode) {
        if (head == null || deleteNode == null) {
            return;
        }
        if (deleteNode.next != null) {// 删除的是中间节点,为了不找前一个节点，那么需要进行覆盖
            Node temp = deleteNode.next;
            deleteNode.value = temp.value;
            deleteNode.next = temp.next;
        } else {
            if (head == deleteNode) {
                head = null; // 表示头节点被删除了
            } else {
                // 表示是尾节点，那么一定要找到前一个节点才能删除
                Node cur = head;
                while(cur != deleteNode) {
                    cur = cur.next;
                }
                cur.next = null;
            }
        }
    }

    public void deleteNode02(Node head, Node deleteNode) {
        // 判断是否为中间节点
        if (deleteNode.next != null) {
            // 进行覆盖处理
            Node next = deleteNode.next;
            deleteNode.value = next.value;
            deleteNode.next = next.next;
        } else {
            if (head == deleteNode) {
                head = null;
            } else { // 删除的末尾的节点
                Node cur = head;
                while(cur.next != deleteNode) {
                    cur = cur.next;
                    System.out.println(cur.value);
                    System.out.println(cur == deleteNode);
                }
                System.out.println(cur.value);
                cur.next = null;
            }
        }
    }

    public void deleteNode03(Node head, Node delete) {
        // 判断是否是中间节点或者是头尾节点
        if (delete.next != null) {
            // 表示删除的是中间节点，进行覆盖处理
            Node next = delete.next.next;
            delete.value = delete.next.value;
            delete.next = next;
        } else {
            if (delete == head) { // 删除的是头
                head = null; // 已经没了
            } else {
                Node temp = head;
                while (temp.next != delete) {
                    temp = temp.next;
                }
                temp.next = null;
            }
        }
    }

    public void deleteNode04(Node head, Node delete) {

        if (delete == null ||  head == null) {
            return;
        }
        if (delete.next != null) {
            Node temp = delete.next;
            delete.value = temp.value;
            delete.next = temp.next;
        } else {
            if (head == delete) {
                head = null;
            } else {
                // 找到前一个
                Node temp = head;
                while(temp.next != delete) {
                    temp = temp.next;
                }
                temp.next = null;
            }
        }
    }

    public void deleteNode05(Node head, Node deleteNode) {
        if (deleteNode.next != null) {
            // 用后面一个覆盖掉自己
            Node next = deleteNode.next;
            deleteNode.next = next.next;
            deleteNode.value = next.value;
        } else {
            if (head == deleteNode) {
                head = null;
            } else {
                // 找到前一个节点处理
                Node temp = head;
                while(temp.next != deleteNode) {
                    temp = temp.next;
                }
                temp.next = null;
            }
        }
    }



    public static void main(String[] args) {
        DeleteNode deleteNode = new DeleteNode();
        Node head = deleteNode.createLinked();
        Node tobeDelete = head.next.next.next.next;
        System.out.println(tobeDelete.value);
        deleteNode.deleteNode05(head, tobeDelete);
        while(head != null) {
            System.out.print(head.value);
            head = head.next;
        }
    }
}
