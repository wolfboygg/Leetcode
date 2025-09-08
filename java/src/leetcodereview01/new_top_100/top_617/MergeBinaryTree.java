package leetcodereview01.new_top_100.top_617;

import leetcodereview01.top100.top_617.MergeTree;
import node.TreeNode;

/**
 * 合并二叉树
 */
public class MergeBinaryTree {

    static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public void traversalTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        traversalTree(root.left);
        traversalTree(root.right);
    }

    // 统一合并到一颗树上就可以了，没必要搞两次
    public TreeNode merge(TreeNode root1, TreeNode root2) {
        // 合并二叉树， 应该是通过递归的方式进行合并
        if (root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }
        root1.value += root2.value;
        root1.left = merge(root1.left, root2.left);
        root1.right = merge(root1.right, root2.right);
        return root1;
    }

    public TreeNode merge01(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }
        // 都要合并到第一颗树上
        root1.value += root2.value;
        // 使用递归的方式进行处理
        root1.left = merge01(root1.left, root2.left);
        root1.right = merge01(root1.right, root2.right);
        return root1;
    }

    public TreeNode merge02(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }
        root1.value += root2.value;
        root1.left = merge02(root1.left, root2.left);
        root1.right = merge02(root1.right, root2.right);
        return root1;
    }

    // 合并二叉树
    public TreeNode merge03(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }
        root1.value += root2.value;
        root1.left = merge03(root1.left, root2.left);
        root1.right = merge03(root1.right, root2.right);
        return root1;
    }

    public TreeNode merge04(TreeNode node1, TreeNode node2) {
        // 递归进行合并
        if (node1 == null || node2 == null) {
            return node1 == null ? node2 : node1;
        }

        node1.value += node2.value;
        node1.left = merge04(node1.left, node2.left);
        node1.right = merge04(node1.right, node2.right);
        return node1;
    }

    public TreeNode merge05(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        if (node1 == null || node2 == null) {
            return node1 == null ? node2 : node1;
        }
        node1.value += node2.value;
        node1.left = merge05(node1.left, node2.left);
        node1.right = merge05(node1.right, node2.right);
        return node1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(2);

        node1.left = node2;
        node2.left = node3;
        node1.right = node4;


        TreeNode node11 = new TreeNode(2);
        TreeNode node22 = new TreeNode(1);
        TreeNode node33 = new TreeNode(3);
        TreeNode node44 = new TreeNode(4);
        TreeNode node55 = new TreeNode(7);

        node11.left = node22;
        node11.right = node33;
        node22.right = node44;
        node33.right = node55;

        MergeBinaryTree mergeBinaryTree = new MergeBinaryTree();
        TreeNode root = mergeBinaryTree.merge05(node1, node11);
        mergeBinaryTree.traversalTree(root);
    }
}
