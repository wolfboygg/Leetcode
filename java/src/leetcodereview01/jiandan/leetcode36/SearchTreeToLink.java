package leetcodereview01.jiandan.leetcode36;

public class SearchTreeToLink {
    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public TreeNode createSearchTree() {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        return node1;
    }

    TreeNode head = null;
    TreeNode pre = null;

    public TreeNode convert(TreeNode root) {
        inOrder02(root);
        return head;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        root.left = pre; // 舍掉了一个pre
        if (pre != null) {
            pre.right = root;
        }
        pre = root;
        if (head == null) {
            head = root;
        }
        inOrder(root.right);
    }

    public void inOrder02(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        root.left = pre;
        if (pre != null) {
            pre.right = root;
        }
        pre = root;
        if (head == null) {
            head = root;
        }
        inOrder(root.right);
    }


    public static void main(String[] args) {
        SearchTreeToLink searchTreeToLink = new SearchTreeToLink();
        TreeNode searchTree = searchTreeToLink.createSearchTree();
        TreeNode convert = searchTreeToLink.convert(searchTree);
        TreeNode right = null;
        while (convert != null) {
            right = convert;
            System.out.print(convert.value);
            convert = convert.right;
        }
        while (right != null) {
            System.out.print(right.value);
            right = right.left;
        }
    }
}
