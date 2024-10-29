package leetcodereview01.new_top_100.top_104;

import leetcodereview01.new_top_100.top_617.MergeBinaryTree;

public class BinaryDepth {

    static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    /**
     * 二叉树的深度
     *
     * @param root
     * @return
     */
    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0; // 万万不能返回-1，root 为0 就是0
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode node11 = new TreeNode(2);
        TreeNode node22 = new TreeNode(1);
        TreeNode node33 = new TreeNode(3);
        TreeNode node44 = new TreeNode(4);
        TreeNode node55 = new TreeNode(7);

        node11.left = node22;
        node11.right = node33;
        node22.right = node44;
        node33.right = node55;

        BinaryDepth binaryDepth = new BinaryDepth();
        int depth = binaryDepth.getDepth(node11);
        System.out.println(depth);

    }

}
