package leetcodereview01.top100.top_104;

import leetcodereview01.top100.top_102.TreeLevelTraversal;

public class TreeNodeDepth {
    static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int getDepth01(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth01(root.left);
        int right = getDepth01(root.right);
        return Math.max(left, right) + 1;
    }
    
    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(4);
        node1.right = node2;
        node1.left = node3;
        node2.left = node4;
        node3.right = node5;
        System.out.println(new TreeNodeDepth().getDepth01(node1));
    }
}
