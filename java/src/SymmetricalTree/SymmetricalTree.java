package SymmetricalTree;

import node.TreeNode;

public class SymmetricalTree {

    public TreeNode buildTree() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
        return node1;
    }

    public boolean isSymmetricalTree(TreeNode root1) {
        if (root1 == null) {
            return false;
        }
        return isSymmetricalTree(root1, root1);
    }

    public boolean isSymmetricalTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.value != root2.value) {
            return false;
        }

        return isSymmetricalTree(root1.left, root2.right) && isSymmetricalTree(root1.right, root2.left);
    }


    public static void main(String[] args) {
        SymmetricalTree tree = new SymmetricalTree();
        System.out.println(tree.isSymmetricalTree(tree.buildTree()));
    }

}
