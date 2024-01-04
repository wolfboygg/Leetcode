package leetcodereview01.top100.top_102;

import leetcodereview01.top100.top_94.TreeInorderTraversal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 */
public class TreeLevelTraversal {

    static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public void levelTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            System.out.print(poll.value + " ");
            if (poll.left!= null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }

    }
    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(4);
        node1.right = node2;
        node1.left = node3;
        node2.left = node4;
        node3.right = node5;
        new TreeLevelTraversal().levelTraversal(node1);
    }
}
