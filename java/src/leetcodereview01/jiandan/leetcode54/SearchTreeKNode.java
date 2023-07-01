package leetcodereview01.jiandan.leetcode54;

public class SearchTreeKNode {
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
        node04.left = node06;

        return node01;
    }

    public int result = -1;
    public int k = -1;

    public static void main(String[] args) {
        SearchTreeKNode searchTreeKNode = new SearchTreeKNode();
        TreeNode tree = searchTreeKNode.createTree();
        searchTreeKNode.k = 3;
        searchTreeKNode.dfs(tree);
        System.out.println(searchTreeKNode.result);
    }


    private void dfs(TreeNode tree) {
        if (tree == null) {
            return;
        }
        if (k == 0) {
            return;
        }
        dfs(tree.right);
        if (--k == 0) result = tree.value;
        dfs(tree.left);
    }
}
