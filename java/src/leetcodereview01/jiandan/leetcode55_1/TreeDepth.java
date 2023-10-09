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

    public int getTreeDepth03(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 看左右子树的深度 去最大值
        int leftDepth = getTreeDepth03(node.left);
        int rightDepth = getTreeDepth03(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int getTreeDepth04(TreeNode node) {
        // 二叉树的深度就是通过比较左右子树的最大深度
        if (node == null) {
            return 0;
        }
        int leftDepth = getTreeDepth04(node.left);
        int rightDepth = getTreeDepth04(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int getTreeDepth05(TreeNode root) {
        // 求二叉树的深度就是通过求左右子树的深度的最大值
        if (root == null) {
            return 0;
        }
        int leftDepth = getTreeDepth05(root.left);
        int rightDepth = getTreeDepth05(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }


    public static void main(String[] args) {
        TreeDepth treeDepth = new TreeDepth();
        TreeNode tree = treeDepth.createTree();
        int depth = treeDepth.getTreeDepth04(tree);
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
