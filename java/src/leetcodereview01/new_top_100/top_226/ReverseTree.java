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
        TreeNode node = reverseTree.reverseTree(root0);
        reverseTree.traversalTree(node);
        System.out.println();
    }

}
