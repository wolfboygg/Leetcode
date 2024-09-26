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

    public int getTreeDepth06(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getTreeDepth06(root.left);
        int rightDepth = getTreeDepth06(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int getTreeDepth07(TreeNode root) {
        // 二叉树的深度，就是看左右子树的深度+1
        if (root == null) {
            return 0;
        }
        int leftDepth = getTreeDepth07(root.left);
        int rightDepth = getTreeDepth07(root.right);
        return Math.max(leftDepth, rightDepth) +1;
    }

    // 获取二叉树的深度
    public int getTreeDepth08(TreeNode root) {
        // 通过递归的方式进行增加深度
        if (root == null) {
            return 0;
        }
        int leftDepth = getTreeDepth08(root.left);
        int rightDepth = getTreeDepth08(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int getTreeDepth09(TreeNode root) {
        // 求二叉树的深度
        if (root == null) {
            return 0;
        }
        int leftDepth = getTreeDepth(root.left);
        int rightDepth = getTreeDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int getTreeDepth10(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getTreeDepth10(root.left);
        int rightDepth = getTreeDepth10(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }


    public static void main(String[] args) {
        TreeDepth treeDepth = new TreeDepth();
        TreeNode tree = treeDepth.createTree();
        int depth = treeDepth.getTreeDepth09(tree);
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
