package leetcodereview01.jiandan.leetcode26;

public class TreeSub {

    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public boolean isSub(TreeNode root, TreeNode node) {
        if (root == null || node == null) {
            return false;
        }
        return isSubTreeWithRoot(root, node) || isSub(root.left, node) || isSub(root.right, node);
    }

    private boolean isSubTreeWithRoot(TreeNode root, TreeNode node) {
        if (node == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.value != node.value) {
            return false;
        }
        return isSubTreeWithRoot(root.left, node.left) && isSubTreeWithRoot(root.right, node.right);
    }


    public boolean isSub01(TreeNode root, TreeNode node) {
        if (root == null || node == null) {
            return false;
        }
        return isSubTreeWithRoot01(root, node) || isSub01(root.left, node) || isSub01(root.right, node);
    }

    private boolean isSubTreeWithRoot01(TreeNode root, TreeNode node) {
        if (node == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (node.value != root.value) {
            return false;
        }
        return node.value == root.value && isSubTreeWithRoot01(root.left, node.left) && isSubTreeWithRoot01(root.right, node.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(3);

        node8.left = node9;
        node8.right = node10;

        System.out.println(new TreeSub().isSub01(node1, node8));

    }
}
