package leetcodereview01.jiandan.leetcode27;

import javax.xml.bind.annotation.XmlID;

public class MirrorTree {

    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public TreeNode createTree() {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7= new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        return node1;
    }

    public TreeNode mirrorTree(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = mirrorTree(node.left);
        TreeNode right = mirrorTree(node.right);
        node.left = right;
        node.right = left;
        return node;
    }

    public TreeNode mirrorTree02(TreeNode head) {
        if (head == null) {
            return null;
        }
        TreeNode left = mirrorTree02(head.left);
        TreeNode right = mirrorTree02(head.right);
        head.left = right;
        head.right = left;
        return head;
    }

    public TreeNode mirrorTree03(TreeNode head) {
        // 通过递归的方式进行左右交换
        if (head == null) {
            return null;
        }
        TreeNode left = mirrorTree03(head.left);
        TreeNode right = mirrorTree03(head.right);
        head.left = right;
        head.right = left;
        return head;
    }

    public void traversalTree(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value);
        traversalTree(node.left);
        traversalTree(node.right);
    }

    public TreeNode mirrorTree04(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftChild = mirrorTree04(root.left);
        TreeNode rightChild = mirrorTree04(root.right);
        root.left = rightChild;
        root.right = leftChild;
        return root;
    }

    public TreeNode mirrorTree05(TreeNode head) {
        if (head == null) {
            return null;
        }
        TreeNode left = mirrorTree05(head.left);
        TreeNode right =  mirrorTree05(head.right);
        head.left = right;
        head.right = left;
        return head;
    }

    public static void main(String[] args) {
        MirrorTree mirrorTree = new MirrorTree();
        TreeNode tree = mirrorTree.createTree();
        mirrorTree.traversalTree(tree);
        System.out.println();
        mirrorTree.mirrorTree05(tree);
        mirrorTree.traversalTree(tree);
    }


}
