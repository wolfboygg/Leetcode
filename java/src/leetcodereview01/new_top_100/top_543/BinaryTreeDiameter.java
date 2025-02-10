package leetcodereview01.new_top_100.top_543;

import node.TreeNode;

/**
 * 二叉树直径
 */
public class BinaryTreeDiameter {

    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    static int res;

    public int diameter(TreeNode root) {
        // 求这个树的直径 左右子树深度相加
        if (root == null) {
            return 0;
        }
        int left = diameter(root.left);
        int right = diameter(root.right);
        int depth = Math.max(left, right) + 1;
        res = Math.max(res, left + right);
        return depth;
    }

    // 求二叉树的直径
    public int diameter01(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 左右子树深度的和 最大的就是直径
        int left = diameter01(root.left);
        int right = diameter01(root.right);
        int depth = Math.max(left, right) + 1;
        res = Math.max(res, left + right);
        return depth;
    }

    public int diameter02(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = diameter02(root.left);
        int right = diameter02(root.right);
        int depth = Math.max(left, right) + 1;
        res = Math.max(res, depth);
        return depth;
    }

    // 求二叉树的直径
    public int diameter03(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = diameter03(root.left);
        int rightDepth = diameter03(root.right);
        int depth = Math.max(leftDepth, rightDepth) + 1;
        res = Math.max(res, depth);
        return depth;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        BinaryTreeDiameter binaryTreeDiameter = new BinaryTreeDiameter();
        int diameter = binaryTreeDiameter.diameter02(node1);
        System.out.println(diameter);
    }

}
