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
        inOrder05(root);
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

    public void inOrder03(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder03(root.left);
        root.left = pre;
        if (pre != null) {
            pre.right = root;
        }
        pre = root;
        if (head == null) {
            head = root;
        }
        inOrder03(root.right);
    }

    public void inOrder04(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder04(node.left);
        node.left = pre;
        if (pre != null) {
            pre.right = node;
        }
        pre = node;
        if (head == null) {
            head = node;
        }
        inOrder04(node.right);
    }

    public void inOrder05(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder05(root.left);
        root.left = pre;
        if (pre != null) {
            pre.right = root;
        }
        pre = root;
        if (head == null) {
            head = root;
        }
        inOrder05(root.right);
    }

    // 二叉搜索树转换了排序的双向链表
    public TreeNode convert06(TreeNode root) {
        // 注意这里要找到head头
        inOrder06(root); // 通过中序遍历来进行转换
        return head;
    }
    public void inOrder06(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder06(root.left);
        if (head == null) {
            head = root;
        }
        root.left = pre; // 这是用来处理右子树
        if (pre != null) {
            pre.right = root;
        }
        pre = root;
        inOrder06(root.right);
    }

    public TreeNode convert07(TreeNode root) {
        if (root == null) {
            return null;
        }
        inOrder07(root);
        return head;
    }
    public void inOrder07(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder07(root.left);
        if (head == null) {
            head = root;
        }
        root.left = pre;
        if (pre != null) {
            pre.right = root;
        }
        pre = root; // 这里要重制pre的位置
        inOrder07(root.right);
    }

    public TreeNode convert08(TreeNode root) {
        if (root == null) {
            return null;
        }
        inOrder08(root);
        return head;
    }

    public void inOrder08(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder08(root.left);
        if (head == null) {
            head = root;
        }
        root.left = pre;
        if (pre != null) {
            pre.right = root;
        }
        pre = root;
        inOrder08(root.right);
    }

    public static void main(String[] args) {
        SearchTreeToLink searchTreeToLink = new SearchTreeToLink();
        TreeNode searchTree = searchTreeToLink.createSearchTree();
        TreeNode convert = searchTreeToLink.convert08(searchTree);
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
