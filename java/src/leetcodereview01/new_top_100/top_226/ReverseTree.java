package leetcodereview01.new_top_100.top_226;

public class ReverseTree {

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public void traversalTree(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        traversalTree(node.left);
        traversalTree(node.right);
    }

    public TreeNode reverseTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = reverseTree(root.left);
        TreeNode right = reverseTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    // 反转二叉树就是调换左右
    public TreeNode reverseTree01(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = reverseTree01(root.left);
        TreeNode right = reverseTree01(root.right);
        root.left = right;
        root.right = left;
        return root;
    }


    public TreeNode reverseTree02(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 反转二叉树 使用递归的方式处理
        TreeNode left = reverseTree02(root.left);
        TreeNode right = reverseTree02(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public TreeNode reverseTree03(TreeNode root) {
        // 反转二叉树
        if (root == null) {
            return null;
        }
        TreeNode leftNode = reverseTree03(root.left);
        TreeNode rightNode = reverseTree03(root.right);
        root.left = rightNode;
        root.right = leftNode;
        return root;
    }

    public TreeNode reverseTree04(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = reverseTree04(root.left);
        TreeNode right = reverseTree04(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    // 递归反转二叉树
    public TreeNode reverseTree05(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = reverseTree05(root.left);
        TreeNode right = reverseTree05(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        ReverseTree reverseTree = new ReverseTree();
        TreeNode root0 = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(4);
        TreeNode root3 = new TreeNode(5);
        TreeNode root4 = new TreeNode(6);
        TreeNode root5 = new TreeNode(7);
        TreeNode root6 = new TreeNode(9);

        root0.left = root1;
        root0.right = root2;
        root1.left = root3;
        root1.right = root4;
        root2.left = root5;
        root2.right = root6;
        reverseTree.traversalTree(root0);
        System.out.println();
        TreeNode node = reverseTree.reverseTree05(root0);
        reverseTree.traversalTree(node);
        System.out.println();
    }

}
