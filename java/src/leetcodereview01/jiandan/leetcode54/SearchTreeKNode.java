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

    // 二搜索树的第K大节点那么就是找到二叉搜索树的中序遍历的的倒数低k个节点
    private void dfs01(TreeNode node) {
        if (node == null) {
            return;
        }
        if (k == 0) {
            return;
        }
        // 中序列遍历反着来
        dfs01(node.right);
        if (--k == 0) {
            result = node.value;
        }
        dfs01(node.left);
    }

    public void dfs02(TreeNode node) {
        // 二叉树树的第K个节点，就是二叉树中序遍历的倒数第K个节点
        if (node == null) {
            return;
        }
        if (k == 0) {
            return;
        }
        dfs02(node.right); // 倒数所以要先遍历右
        if (--k == 0) {
            result = node.value;
        }
        dfs02(node.left);
    }

    // 搜索二叉树的第K大节点，那么就是中序列遍历的倒数第K大节点
    public void dfs03(TreeNode root) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            return;
        }
        // 中序遍历倒着来
        dfs03(root.right);
        k--;
        if (k == 0) {
            result = root.value;
        }
        dfs03(root.left);
    }

    public static void main(String[] args) {
        SearchTreeKNode searchTreeKNode = new SearchTreeKNode();
        TreeNode tree = searchTreeKNode.createTree();
        searchTreeKNode.k = 3;
        searchTreeKNode.dfs03(tree);
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
