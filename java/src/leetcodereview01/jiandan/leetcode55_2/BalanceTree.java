package leetcodereview01.jiandan.leetcode55_2;


public class BalanceTree {

    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public TreeNode createTree() {
        TreeNode node01 = new TreeNode(5);
        TreeNode node02 = new TreeNode(3);
        TreeNode node03 = new TreeNode(6);
        TreeNode node04 = new TreeNode(2);
        TreeNode node05 = new TreeNode(4);
        TreeNode node06 = new TreeNode(1);

        node01.left = node02;
        node01.right = node03;
        node02.left = node04;
        node02.right = node05;

        return node01;
    }


    public boolean isBalance = true;
    
    public int isBalanceTree(TreeNode node) {
        if (node == null || !isBalance) {
            return 0;
        }
        int leftHeight = isBalanceTree(node.left);
        int rightHeight = isBalanceTree(node.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            isBalance = false;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public static void main(String[] args) {
        BalanceTree balanceTree = new BalanceTree();
        TreeNode tree = balanceTree.createTree();
        balanceTree.isBalanceTree(tree);
        System.out.println(balanceTree.isBalance);
    }
}
