package leetcodereview01.jiandan.leetcode28;

public class SymmetricTree {

    public static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public TreeNode createTree() {
        // 1,2,2,3,4,4,3
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        return node1;
    }

    public boolean isSymmetric(TreeNode head) {
        // 两个指针都指向了head
        return check04(head, head);
    }

    public boolean check(TreeNode head1, TreeNode head2) {
        if (head1 == null && head2 == null) {
            return true;
        }
        if (head1 == null || head2 == null) {
            return false;
        }
        return head1.value == head2.value && check(head1.left, head2.right) && check(head1.right, head2.left);
    }


    public boolean check02(TreeNode head1, TreeNode head2) {
        // 需要递归进行遍历
        if (head1 == null && head2 == null) {
            return true;
        }
        if (head1 == null || head2 == null) {
            return false;
        }
        return head1.value == head2.value && check02(head1.left, head2.right) && check02(head1.right, head2.left);
    }

    public boolean check03(TreeNode head1, TreeNode head2) {
        // 判断一棵树是否对称，使用两个指针，一个向左一个向右看是否相等
        if (head1 == null && head2 == null) {
            return true;
        }
        if (head1 == null || head2 == null) {
            return false;
        }
        return head1.value == head2.value && check03(head1.left, head2.right) && check03(head1.right, head2.left);
    }

    public boolean check04(TreeNode head1, TreeNode head2) {
        if (head1 == null && head2 == null) { // 如何同时为null 则为对称
            return true;
        }
        if (head1 == null || head2 == null) { // 其中一个为null则不对称
            return false;
        }
        // 然后检测左子树和右子树  右子树和左子树是否对称
        return head1.value == head2.value && check04(head1.left, head2.right) && check04(head1.right, head2.left);
    }

    public boolean isSymmetric01(TreeNode node) {
        return check05(node, node);
    }

    public boolean check05(TreeNode head1, TreeNode head2) {
        if (head1 == null && head2 == null) {
            return true;
        }
        if (head1 == null || head2 == null) {
            return false;
        }
        return head1.value == head2.value && check05(head1.left, head2.right) && check05(head1.right, head2.left);
    }

    public boolean isSymmetric06(TreeNode root) {
        if (root == null) {
            return false;
        }
        return check06(root, root);
    }

    public boolean check06(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.value == root2.value && check06(root1.left, root2.right) && check06(root1.right, root2.left);
    }

    // 判断是否一颗对称的二叉树，就是使用两个相同的输进行左右比较
    public boolean isSymmetric07(TreeNode root) {
        if (root == null) {
            return false;
        }
        return check07(root, root);
    }

    public boolean check07(TreeNode left, TreeNode right) {
        // 判断是否对称就是递归进行比较
        if (left == null && right == null) { // 都为null肯定对称 其中一个为null则不对称
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.value == right.value && check07(left.left, right.right) && check07(left.right, right.left);
    }

    public boolean isSymmetric08(TreeNode root) {
        // 判断是否是一个镜像的二叉树，当然还是需要通过递归的方式进行
        if (root == null) {
            return false;
        }
        return check08(root, root);
    }

    public boolean check08(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.value == node2.value && check08(node1.left, node2.right) && check06(node1.right, node2.left);
    }

    public boolean isSymmetric09(TreeNode root) {
        // 判断是否是一个镜像二叉树
        if (root == null) {
            return false;
        }
        return realIsSymmetric09(root, root);
    }

    public boolean realIsSymmetric09(TreeNode root1, TreeNode root2) {
        // 左子树等于右子树
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.value == root2.value && realIsSymmetric09(root1.left, root2.left) && realIsSymmetric09(root1.right, root2.right);
    }

    // 判断是否一颗对称的二叉树
    public boolean isSymmetric10(TreeNode root) {
        if (root == null) {
            return false;
        }
        return realIsSymmetric10(root, root);
    }

    public boolean realIsSymmetric10(TreeNode node1, TreeNode node2) {
        // 判断是否对称，通过递归的方式进行处理
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.value == node2.value && realIsSymmetric10(node1.left, node2.right) && realIsSymmetric10(node1.right, node2.left);
    }

    public boolean isSymmetric11(TreeNode root) {
        // 判断是否是一颗对称的二叉树
        if (root == null) {
            return false;
        }
        return realIsSymmetric11(root, root);
    }

    public boolean realIsSymmetric11(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.value == root2.value && realIsSymmetric11(root1.left, root2.right) && realIsSymmetric11(root1.right, root2.left);
    }

    public boolean isSymmetric12(TreeNode root) {
        if (root == null) {
            return false;
        }
        return realIsSymmetric12(root, root);
    }

    public boolean realIsSymmetric12(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.value == node2.value && realIsSymmetric12(node1.left, node2.right) && realIsSymmetric12(node1.right, node2.left);
    }


    public static void main(String[] args) {
        SymmetricTree symmetricTree = new SymmetricTree();
        TreeNode tree = symmetricTree.createTree();
        System.out.println(symmetricTree.isSymmetric12(tree));
    }

}
