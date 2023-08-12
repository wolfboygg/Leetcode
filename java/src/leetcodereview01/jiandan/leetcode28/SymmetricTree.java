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
        return check04(head, head);
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


    public boolean check02(TreeNode head1, TreeNode head2) {
        // 需要递归进行遍历
        if (head1 == null && head2 == null) {
            return true;
        }
        if (head1 == null || head2 == null) {
            return false;
        }
        return head1.value == head2.value && check02(head1.left, head2.right) && check02(head1.right, head2.left);
    }

    public boolean check03(TreeNode head1, TreeNode head2) {
        // 判断一棵树是否对称，使用两个指针，一个向左一个向右看是否相等
        if (head1 == null && head2 == null) {
            return true;
        }
        if (head1 == null || head2== null) {
            return false;
        }
        return head1.value == head2.value && check03(head1.left, head2.right) && check03(head1.right, head2.left);
    }

    public boolean check04(TreeNode head1, TreeNode head2) {
        if (head1 == null && head2 == null) { // 如何同时为null 则为对称
            return true;
        }
        if (head1 == null || head2 == null) { // 其中一个为null则不对称
            return false;
        }
        // 然后检测左子树和右子树  右子树和左子树是否对称
        return head1.value == head2.value && check04(head1.left, head2.right) && check04(head1.right, head2.left);
    }


    public static void main(String[] args) {
        SymmetricTree symmetricTree = new SymmetricTree();
        TreeNode tree = symmetricTree.createTree();
        System.out.println(symmetricTree.isSymmetric(tree));
    }

}
