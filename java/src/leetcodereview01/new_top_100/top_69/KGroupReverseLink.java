package leetcodereview01.new_top_100.top_69;

/**
 * K个一组翻转链表
 * 解题思路通过一个while循环将链表遍历完成
 * 在通过一个for循环进行分组 然后进行指针的移动翻转
 */
public class KGroupReverseLink {
    static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node kGroupReverse(Node head, int k) {
        if (head == null) {
            return null;
        }
        // 声明一个节点
        Node pre = new Node(-1);
        pre.next = head;
        Node start = pre;
        Node end = pre;

        while(end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            Node next = end == null ? null : end.next;// 将下一个节点存下来 start end 始终指向前一个节点
            if (end != null) {
                end.next = null;
            }
            start.next = reverse(start.next);
            start = end;
            if (end == null) {
                break;
            }
            end.next = next;
        }

        return pre.next;
    }

    private Node reverse(Node root) {
        if (root == null) {
            return null;
        }
        Node pre = new Node(-1);
        while(root != null) {
            Node next = root.next;
            root.next = pre.next;
            pre.next = root;
            root = next;
        }
//        Node temp = pre.next;
//        while(temp != null) {
//            System.out.print(temp.value + " ");
//            temp = temp.next;
//        }
        return pre.next;
    }

    public Node kGroupReverse01(Node head, int k) {
        // k个一组反转链表
        if (head == null) {
            return null;
        }
        Node newHead = new Node(-1);
        newHead.next = head;
        Node start = newHead;
        Node last = newHead;
        while(last.next != null) {
            for (int i = 0; i < k && last != null; i++) {
                last = last.next;
            }
            Node next = last == null ? null : last.next;
            if (last != null) {
                last.next = null;
            }
            // 反转之后指针发生变化，需要先换一下
            last = start.next;
            start.next = realReverse01(start.next);

            start = last;
            if (last == null) {
                break;
            }
            last.next = next;
        }
        return newHead.next;
    }

    public Node realReverse01(Node head) {
        Node pre = new Node(-1);
        while(head != null) {
            Node next = head.next;
            head.next = pre.next;
            pre.next = head;
            head = next;
        }
        return pre.next;
    }

    // 调整的太费劲了，还需要熟悉
    public Node kGroupReverse02(Node head, int k) {
        if (head == null) {
            return null;
        }
        Node start = new Node(-1);
        start.next = head;
        Node pre = start;
        Node last = start;
        while(last.next != null) {
            for (int i = 0; i < k && last != null; i++) {
                last = last.next;
            }
            Node next = last == null ? null : last.next;
            if (last != null) {
                last.next = null;
            }
            last = start.next;
            start.next = reverse01(start.next);
            if (last == null) {
                break;
            }
            last.next = next;
            start = last;

        }
        return pre.next;
    }

    public Node reverse01(Node head) {
        Node pre = new Node(-1);
        Node temp = pre;
        while(head != null) {
            Node next = head.next;
            head.next = temp.next;
            temp.next = head;
            head = next;
        }
        Node next = pre.next;
//        while(pre != null) {
//            System.out.print(pre.value + " ");
//            pre = pre.next;
//        }
        return next;
    }

    public Node kGroupReverse03(Node root, int k) {
        if (root == null) {
            return null;
        }
        Node start = new Node(-1);
        start.next = root;
        Node last = start;
        Node temp = start;
        while(last != null) {
            for (int i = 0; i < k && last != null; i++) {
                last = last.next;
            }
            Node next = last == null ? null : last.next;
            if (last != null) {
                last.next = null;
            }
            last = start.next;
            start.next = reverse03(start.next);
            start = last;
            if (last == null) {
                break;
            }
            last.next = next;
        }
        return temp.next;
    }

    public Node reverse03(Node head) {
        Node pre = new Node(-1);
        Node temp = pre;
        while(head != null) {
            Node next = head.next;
            head.next = temp.next;
            temp.next = head;
            head = next;
        }
        Node node = pre.next;
        while(pre != null) {
            System.out.print(pre.value + " ");
            pre = pre.next;
        }
        System.out.println();
        return node;
    }

    public Node kGroupReverse04(Node head, int k) {
        if (head == null) {
            return null;
        }
        Node pre = new Node(-1);
        pre.next = head;
        Node start = pre;
        Node last = pre;
        while(last.next != null) {
            for (int i = 0; i < k && last != null; i++) {
                last = last.next;
            }
            // 找到一组
            Node next = last == null ? null : last.next;
            if (last != null) {
                last.next = null;
            }
            last = start.next;
            start.next = reverse03(start.next);
            if (last == null) {
                break;
            }
            start = last;
            last.next = next;
        }
        return pre.next;
    }




    public static void main(String[] args){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        KGroupReverseLink reverseLink = new KGroupReverseLink();
        Node node = reverseLink.kGroupReverse04(node1, 3);
        while(node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }

}
