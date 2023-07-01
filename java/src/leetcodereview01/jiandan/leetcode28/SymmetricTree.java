package leetcodereview01.jiandan.leetcode28;

public class SymmetricTree {

    public static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public TreeNode createTree() {
        // 1,2,2,3,4,4,3
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        return node1;
    }

    public boolean isSymmetric(TreeNode head) {
        // 两个指针都指向了head
        return check(head, head);
    }

    public boolean check(TreeNode head1, TreeNode head2) {
        if (head1 == null && head2 == null) {
            return true;
        }
        if (head1 == null || head2 == null) {
            return false;
        }
        return head1.value == head2.value && check(head1.left, head2.right) && check(head1.right, head2.left);
    }


    public static void main(String[] args) {
        SymmetricTree symmetricTree = new SymmetricTree();
        TreeNode tree = symmetricTree.createTree();
        System.out.println(symmetricTree.isSymmetric(tree));
    }

}
