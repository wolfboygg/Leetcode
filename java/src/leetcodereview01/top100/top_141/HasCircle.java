package leetcodereview01.top100.top_141;

/**
 * 判断列表中是否有环
 */
public class HasCircle {
    static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public boolean hasCircle(Node head) {
        if (head == null) {
            return false;
        }
        // 这种判断是否有环的操作就是使用一个快慢指针进行追赶，如果追上了就说明有环
        Node fast = head;
        Node slow = head;
        while(fast !=null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(0);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node2;

        HasCircle hasCircle = new HasCircle();
        boolean isExit = hasCircle.hasCircle(node1);
        System.out.println(isExit);
    }
}
