package leetcodereview01.top100.top_226;

import leetcodereview01.top100.top_206.ReverseLink;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 翻转二叉树
 */
public class ReverseTree {

    static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public TreeNode reverse(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = reverse(root.left);
        TreeNode right = reverse(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            System.out.print(poll.value + " ");
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }

    }

    public static void main(String[] args){
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

        ReverseTree reverseTree = new ReverseTree();
        reverseTree.traversal(node1);
        System.out.println();
        reverseTree.reverse(node1);
        reverseTree.traversal(node1);

    }

}
