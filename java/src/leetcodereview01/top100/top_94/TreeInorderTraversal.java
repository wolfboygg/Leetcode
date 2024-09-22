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

    public void inorderByDG01(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderByDG01(root.left);
        System.out.print(root.value + " ");
        inorderByDG01(root.right);
    }


    public void inOrderByStack01(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            System.out.print(node.value + " ");
            root = node.right;
        }
    }


    public static void main(String[] args){
      TreeNode node1 = new TreeNode(1);
      TreeNode node2 = new TreeNode(2);
      TreeNode node3 = new TreeNode(3);
      node1.right = node2;
      node1.left = node3;

        TreeInorderTraversal traversal = new TreeInorderTraversal();
        traversal.inOrderByStack01(node1);
    }
}
