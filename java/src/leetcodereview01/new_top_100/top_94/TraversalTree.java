package leetcodereview01.new_top_100.top_94;

import leetcodereview01.top100.top_94.TreeInorderTraversal;

import java.util.Stack;

public class TraversalTree {
    static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private void traversalByDG(TreeNode root) {
        if (root == null) {
            return;
        }
        traversalByDG(root.left);
        System.out.print(root.value + " ");
        traversalByDG(root.right);
    }

    private void traversalByStack(TreeNode root) {
        if (root == null) {
            return;
        }
        // 通过栈进行遍历
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            if (pop != null) {
                System.out.print(pop.value + " ");
                root = pop.right;
            }
        }
    }

    private void preTraversalByStack(TreeNode root) {
        if (root == null) {
            return;
        }
        // 通过栈进行遍历
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                System.out.print(root.value + " ");
                root = root.left;
            }
            TreeNode pop = stack.pop();
            if (pop != null) {
//                System.out.print(pop.value + " ");
                root = pop.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node1.left = node3;

        TraversalTree traversalTree = new TraversalTree();
        traversalTree.traversalByDG(node1);
        System.out.println();
        traversalTree.preTraversalByStack(node1);

    }
}
