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

    // 二叉搜索树第K大的节点 可以等同于后续遍历的k个节点
    public void dfs04(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs04(root.right);
        if (--k == 0) {
            result = root.value;
        }
        dfs04(root.left);
    }

    // 二叉搜索数的第K大节点 (左边的比跟节点小 右边的比跟节点小)  通过后续遍历找到倒数第K个节点即可
    public void dfs05(TreeNode root) {
        // 后序遍历第K个节点
        if (root == null) {
            return;
        }
        dfs05(root.right); // 要倒着进行遍历
        if (--k == 0) {
            result = root.value;
        }
        dfs05(root.left);
    }

    // 二叉搜索数的第K大节点 左根右， 那么我们使用倒着中序列遍历即刻
    public void dfs06(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs06(root.right);
        if (--k == 0) {
            this.result = root.value;
        }
        dfs06(root.left);
    }

    public void dfs07(TreeNode root) {
        // 搜索二叉树倒数k个节点
        if (root == null) {
            return;
        }
        dfs07(root.right);
        if (--k == 0) {
            result = root.value;
        }
        dfs07(root.left);
    }

    // 搜索二叉搜索树的第K大的节点 先右 根 左
    public void  dfs08(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs08(root.right);
        k--;
        if (k == 0) {
            result = root.value;

        }
        dfs08(root.left);
    }

    // 找到搜索二叉树的第k个节点
    public void dfs09(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs09(root.right);
        if (--k== 0) {
            this.result = root.value;
        }
        dfs09(root.left);
    }

    public void dfs10(TreeNode root) {
        // 搜索二叉树的倒数K个节点
        if (root == null) {
            return ;
        }
        // 先遍历右子树，然后在根，最后才是左子树
        dfs10(root.right);
        if (--k==0) { // 使用统一的K
            result = root.value;
        }
        dfs10(root.left);
    }

    public static void main(String[] args) {
        SearchTreeKNode searchTreeKNode = new SearchTreeKNode();
        TreeNode tree = searchTreeKNode.createTree();
        searchTreeKNode.k = 3;
        searchTreeKNode.dfs10(tree);
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
