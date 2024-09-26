package leetcodereview01.zhongdeng.top_236;

public class TreeCommonParent {

    static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public TreeNode findCommonParent(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null ) {
            return null;
        }
        if (node1.value == root.value || node2.value== root.value) {
            return root;
        }
        // 通过递归的方式进行查找
        TreeNode left = findCommonParent(root.left, node1, node2);
        TreeNode right = findCommonParent(root.right, node1, node2);
        if (left == null && right == null) {
            return null;
        }
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }


    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(9);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        TreeCommonParent parent = new TreeCommonParent();
        TreeNode node = parent.findCommonParent(node1, node4, node5);
        if (node == null) {
            System.out.println("未找到");
        } else {
            System.out.println(node.value);
        }

    }

}
