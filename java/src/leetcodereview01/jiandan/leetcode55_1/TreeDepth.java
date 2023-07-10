package leetcodereview01.jiandan.leetcode55_1;

import leetcodereview01.jiandan.leetcode54.SearchTreeKNode;

public class TreeDepth {

    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public TreeNode createTree() {
        TreeNode node01 = new TreeNode(5);
        TreeNode node02 = new TreeNode(3);
        TreeNode node03 = new TreeNode(6);
        TreeNode node04 = new TreeNode(2);
        TreeNode node05 = new TreeNode(4);
        TreeNode node06 = new TreeNode(1);

        node01.left = node02;
        node01.right = node03;
        node02.left = node04;
        node02.right = node05;
        node04.left = node06;

        return node01;
    }

    public int getTreeDepth02(TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        int leftDepth = getTreeDepth02(tree.left);
        int rightDepth = getTreeDepth02(tree.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeDepth treeDepth = new TreeDepth();
        TreeNode tree = treeDepth.createTree();
        int depth = treeDepth.getTreeDepth02(tree);
        System.out.println(depth);
    }

    public int getTreeDepth(TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        int leftDepth = getTreeDepth(tree.left);
        int rightDepth = getTreeDepth(tree.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

}
