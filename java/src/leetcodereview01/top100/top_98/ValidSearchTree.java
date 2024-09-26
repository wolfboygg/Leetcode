package leetcodereview01.top100.top_98;

import leetcodereview01.top100.top_94.TreeInorderTraversal;

import java.util.Stack;

/**
 * 验证二叉搜索树，二叉搜索树的特点是 左节点比跟节点小，右节点比跟节点大
 */
public class ValidSearchTree {
    static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public boolean validSearchTree(TreeNode node) {
        if (node == null) {// 这里不能直接返回true 需要更具对应的节点进行操作
            return false;
        }
        return realValid(node);
    }

    public boolean realValid(TreeNode node) {
        if (node == null) {
            return true;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        if (left != null && left.value > node.value) {
            return false;
        }
        if (right != null && right.value < node.value) {
            return false;
        }
        return realValid(left) && realValid(right);
    }

    public boolean validByStack(TreeNode node) {
        // 通过Stack进行遍历，然后通过记录上一个节点然后进行比较，最后的结果就是始终比前一个记录的节点大，如果有不大的，那就不是二叉索搜树
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode temp = node;
        while(!stack.isEmpty() || temp != null) {
            while(temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            System.out.println(stack.size());
            // 使用的是中序遍历的方式
            TreeNode pop = stack.pop();
            if (pre != null && pop.value < pre.value) {
                System.out.println(pre.value + "===>" + pop.value);
                return false;
            }
            pre = pop;
            temp = pop.right;
        }
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (pre != null && pre.value >= node.value) {
                return false;
            }
            pre = node;
            node = node.right;
        }
        return true;
    }

    public static void main(String[] args){
      TreeNode node1 = new TreeNode(5);
      TreeNode node2 = new TreeNode(4);
      TreeNode node3 = new TreeNode(6);
      TreeNode node4 = new TreeNode(7);
      TreeNode node5 = new TreeNode(1);
      node1.left = node2;
      node1.right = node3;
      node2.right = node4;
      node3.left = node5;
      ValidSearchTree validSearchTree = new ValidSearchTree();
      boolean valid = validSearchTree.validByStack(node1);
      System.out.println(valid);
    }
}
