package leetcodereview01.top100.top_543;
public class BinaryTreeDiameter {
    static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        System.out.println("left, right" + left +"->" + right); // 不要根节点
        int depth = Math.max(left, right) + 1;
        res = Math.max(res, left + right);
        return depth;
    }

    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node2.left = node4;
        node2.right = node5;
        node1.right = node3;
        BinaryTreeDiameter binaryTreeDiameter = new BinaryTreeDiameter();
        System.out.println(binaryTreeDiameter.diameterOfBinaryTree(node1));

        System.out.println(res);
    }
}
