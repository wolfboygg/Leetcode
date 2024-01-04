package leetcodereview01.top100.top_101;
public class SymmetricTree {

    static class TreeNode  {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public boolean isSymmetric(TreeNode node) {
        if (node == null) {
            return false;
        }
        return realSymmetric(node.left, node.right);
    }

    public boolean realSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.value == right.value && realSymmetric(left.left, right.right) && realSymmetric(left.right, right.left);
    }

    public static void main(String[] args){
        // 判断是否是对称的二叉树
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;
        SymmetricTree symmetricTree = new SymmetricTree();
        boolean symmetric = symmetricTree.isSymmetric(node1);
        System.out.println(symmetric);

    }
}
