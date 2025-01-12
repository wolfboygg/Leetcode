package leetcodereview01.new_top_100.top_101;

/**
 * 检查是否是一颗对称的二叉树
 */
public class SymmetricTree {
    static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        // 如何判断是否一颗对称的二叉树呢？通过传入两颗树来进行判断
        return realIsSymmertic(root, root);
    }

    public boolean realIsSymmertic(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.value == root2.value && realIsSymmertic(root1.left, root2.right) && realIsSymmertic(root1.right, root2.left);
    }

    public boolean isSymmetric01(TreeNode root) {
        if (root == null) {
            return false;
        }
        return realIsSymmetric01(root, root);
    }

    public boolean realIsSymmetric01(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.value == root2.value && realIsSymmetric01(root1.left, root2.right) && realIsSymmetric01(root1.right, root2.left);
    }


    public static void main(String[] args) {
        // 判断是否是对称的二叉树
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;
        SymmetricTree symmetricTree = new SymmetricTree();
        boolean symmetric = symmetricTree.isSymmetric01(node1);
        System.out.println(symmetric);
    }
}
