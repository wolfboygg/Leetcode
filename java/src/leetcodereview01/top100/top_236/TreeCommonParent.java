package leetcodereview01.top100.top_236;

import leetcodereview01.top100.top_226.ReverseTree;

/**
 * 二叉树的最近公共祖先
 */
public class TreeCommonParent {

    static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    /**
     * 通过递归的方式进行遍历，然后判断找到的节点是否未null然后判断返回什么
     * 如果左右都不为null,表示左右个有一个，公共的root，
     * 注意在root == null || root == node1 || root == node2 这种情况下公共节点就是root
     */
    public TreeNode findCommonParent(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || root == node1 || node2 == root) {
            return root;
        }
        // 然后开始找
        TreeNode leftComm = findCommonParent(root.left, node1, node2);
        TreeNode rightComm = findCommonParent(root.right, node1, node2);
        if (leftComm == null && rightComm == null) {
            return null;
        }
        if (leftComm  != null && rightComm != null) {
            return root;
        }
        return leftComm == null ? rightComm : leftComm;
    }

    public static void main(String[] args){
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
        TreeNode node = parent.findCommonParent(node1, node4, node6);
        if (node == null) {
            System.out.println("没有公共节点");
            return;
        }
        System.out.println(node.value);
    }
}
