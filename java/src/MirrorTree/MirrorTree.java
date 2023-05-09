package MirrorTree;

import node.TreeNode;

public class MirrorTree {


    public TreeNode buildSubTree() {
        TreeNode node = new TreeNode(8);
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(1);
        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        return node;
    }


    public void mirror(TreeNode root1) {
        if (root1 == null) {
            return;
        }
        if (root1.left == null && root1.right == null) {
            return;
        }
        swap(root1);
        if (root1.left != null) {
            mirror(root1.left);
        }
        if (root1.right != null) {
            mirror(root1.right);
        }
    }

    public void swap(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        if (root.left != null) {
            traverse(root.left);
        } else {
            System.out.println("null");
        }

        if (root.right != null) {
            traverse(root.right);
        } else {
            System.out.println("null");
        }

    }

    public static void main(String[] args) {
        MirrorTree mirrorTree = new MirrorTree();
        TreeNode root = mirrorTree.buildSubTree();
        mirrorTree.traverse(root);
        mirrorTree.mirror(root);
        mirrorTree.traverse(root);


    }
}
