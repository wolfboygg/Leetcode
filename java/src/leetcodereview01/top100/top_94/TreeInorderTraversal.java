package leetcodereview01.top100.top_94;

import java.util.Stack;

/**
 * 二叉树的中序遍历
 */
public class TreeInorderTraversal {
    static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public void inorderByDG(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderByDG(node.left);
        System.out.print(node.value + " ");
        inorderByDG(node.right);
    }

    public void inorderByStack(TreeNode node) {
        if (node == null) {
            return;
        }
        // 通过栈来进行辅助实现
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || node != null) {
            while(node != null) { // 使用while循环直接干到最左边的节点
                stack.push(node);
                node = node.left;
            }
            TreeNode pop = stack.pop();
            System.out.print(pop.value + " ");
            node = pop.right;
        }
    }

    public static void main(String[] args){
      TreeNode node1 = new TreeNode(1);
      TreeNode node2 = new TreeNode(2);
      TreeNode node3 = new TreeNode(3);
      node1.right = node2;
      node2.left = node3;

        TreeInorderTraversal traversal = new TreeInorderTraversal();
        traversal.inorderByDG(node1);
    }
}
