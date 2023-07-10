package leetcodereview01.jiandan.leetcode68_1;

public class SearchTreeCommonRoot {

    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    // [6,2,8,0,4,7,9,null,null,3,5]
    public TreeNode createTree() {
        TreeNode treeNode01 = new TreeNode(6);
        TreeNode treeNode02 = new TreeNode(2);
        TreeNode treeNode03 = new TreeNode(8);
        TreeNode treeNode04 = new TreeNode(0);
        TreeNode treeNode05 = new TreeNode(4);
        TreeNode treeNode06 = new TreeNode(7);
        TreeNode treeNode07 = new TreeNode(9);
        TreeNode treeNode08 = new TreeNode(3);
        TreeNode treeNode09 = new TreeNode(5);

        treeNode01.left = treeNode02;
        treeNode01.right = treeNode03;

        treeNode03.left = treeNode06;
        treeNode03.right = treeNode07;

        treeNode02.left = treeNode04;
        treeNode02.right = treeNode05;

        treeNode05.left = treeNode08;
        treeNode05.right = treeNode09;

        return treeNode01;

    }

    public static void main(String[] args) {
        SearchTreeCommonRoot searchTreeCommonRoot = new SearchTreeCommonRoot();
        TreeNode tree = searchTreeCommonRoot.createTree();
        TreeNode node = searchTreeCommonRoot.findComRoot(tree, new TreeNode(2), new TreeNode(8));
        if (node != null) {
            System.out.println(node.value);
        }
    }

    private TreeNode findComRoot(TreeNode tree, TreeNode p, TreeNode q) {
        while (tree != null) {
            if (p.value > tree.value && q.value > tree.value) {
                // 表明一定在右边
                tree = tree.right;
            } else if (p.value < tree.value && q.value < tree.value) {
                tree = tree.left;
            } else {
                return tree;
            }
        }
        return null;
    }

}
