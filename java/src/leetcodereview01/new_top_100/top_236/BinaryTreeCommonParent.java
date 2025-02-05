package leetcodereview01.new_top_100.top_236;

import leetcodereview01.top100.top_236.TreeCommonParent;
import node.TreeNode;

/**
 * 二叉树的最近公共祖先
 */
public class BinaryTreeCommonParent {

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public TreeNode findCommonParent(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || node1 == root || node2 == root) {
            return root;
        }
        TreeNode left = findCommonParent(root.left, node1, node2);
        TreeNode right = findCommonParent(root.right, node1, node2);
        if (left == null && right == null) {// 都没找到
            return null;
        }
        if (left != null && right != null) {
            return root;// 各找到一个
        }
        return left == null ? root : left;
    }

    public TreeNode findCommonParent01(TreeNode root, TreeNode node1, TreeNode node2) {
        // 找到二叉树公共节点 判断是否在左边， 判断是否在右边，左右各一个，那么就是根
        if (root == null) {
            return null;
        }
        if (node1 == root || node2 == root) {
            return root;
        }
        TreeNode left = findCommonParent01(root.left, node1, node2);
        TreeNode right = findCommonParent01(root.right, node1, node2);
        if (left == null && right == null) {
            return null;
        }
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

    // 二叉树的公共祖先
    public TreeNode findCommonParent02(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null) {
            return null;
        }
        // 必须判断是否等于root
        if (node1 == root || node2 == root) {
            return root;
        }
        // 递归处理
        TreeNode leftChild = findCommonParent02(root.left, node1, node2);
        TreeNode rightChild = findCommonParent02(root.right, node1, node2);
        if (leftChild == null && rightChild == null) {
            return null;
        }
        if (leftChild != null && rightChild != null) {
            return root;
        }
        return leftChild == null ? rightChild : leftChild;
    }

    public TreeNode findCommonParent03(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null) {
            return null;
        }
        if (node1 == root || node2 == root) {
            return root;
        }
        TreeNode leftChild = findCommonParent03(root.left, node1, node2);
        TreeNode rightChild = findCommonParent03(root.right, node1, node2);
        if (leftChild == null && rightChild == null) {
            return null;
        }
        if (leftChild != null && rightChild != null) {
            return root;
        }
        return leftChild == null ? rightChild : leftChild;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(9);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        BinaryTreeCommonParent binaryTreeCommonParent = new BinaryTreeCommonParent();
        TreeNode commonParent = binaryTreeCommonParent.findCommonParent03(node1, node4, node5);
        if (commonParent == null) {
            System.out.println("找不到");
        } else {
            System.out.println(commonParent.value);
        }

    }

}
