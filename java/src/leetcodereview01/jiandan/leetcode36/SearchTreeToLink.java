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

    public TreeNode convert09(TreeNode root) {
        // 转换为双向列表
        if (root == null) {
            return null;
        }
        // 双向列表 有序的，需要排序好的双向列表 // 所以要中序遍历一下
        inOrder09(root);
        return head;
    }

    public void inOrder09(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder09(root.left);
        if (head == null) {
            head = root;
        }
        root.left = pre;
        if (pre != null) {
            pre.right = root;
        }
        pre = root;
        inOrder09(root.right);
    }

    // 二叉搜索树转换为排序的双向链表  左根右 这样的遍历顺序才是一个排序的链表
    public TreeNode convert10(TreeNode root) {
        // 需要进行转换
        if (root == null) {
            return null;
        }
        inOrder10(root);
        return head;
    }

    public void inOrder10(TreeNode root) {
        // 主要通过两个节点head， pre进行转换，pre指向前一个节点，目的是为了让left进行找到它
        if (root == null) {
            return;
        }
        inOrder10(root.left);
        if (head == null) {
            head = root;
        }
        if (pre != null) {
            pre.right = root;
        }
        root.left = pre;
        pre = root;
        inOrder10(root.right);
    }

    public TreeNode convert11(TreeNode root) {
        // 转换为双向链表 // 通过head pre进行转换
        if (root == null) {
            return null;
        }
        inOrder11(root);
        return head;
    }

    public void inOrder11(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder11(root.left);
        if (head == null) {
            head = root;
        }
        if (pre != null) {
            pre.right = root;
        }
        root.left = pre;
        pre = root;
        inOrder11(root.right);
    }

    // 搜索二叉树转换为一个有序列表 左跟右 这样进行遍历 然后进行转换
    public TreeNode convert12(TreeNode root) {
        if (root == null) {
            return null;
        }
        inOrder12(root);
        return head;
    }

    public void inOrder12(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder12(root.left);
        // 找到最左边的节点
        if (head == null) {
            head = root;
        }
        // 没遍历right 先遍历左孩子
        root.left = pre;
        if (pre != null) {
            pre.right = root;
        }
        pre = root;
        inOrder12(root.right);
    }

    public TreeNode convert13(TreeNode root) {
        // 搜索二叉树转换为链表
        if (root == null) {
            return null;
        }
        // 通过中序遍历进行转换 从小到大 左 根 右
        inOrder13(root);
        if (head != null) {
            return head;
        }
        return null;
    }


    public void inOrder13(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder13(root.left);
        // 这里需要进行抓换
        if (head == null) {
            head = root;
        }
        root.left = pre;
        if (pre != null) {
            pre.right = root;
        }
        pre = root;
        inOrder13(root.right);
    }


    public static void main(String[] args) {
        SearchTreeToLink searchTreeToLink = new SearchTreeToLink();
        TreeNode searchTree = searchTreeToLink.createSearchTree();
        TreeNode convert = searchTreeToLink.convert13(searchTree);
        TreeNode right = null;
        // 123321
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
