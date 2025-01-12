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
//        node04.left = node06;

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

    // 平衡二叉树指的是左右子树的深度差不超过1
    public int isBalanceTree02(TreeNode node) {
        if (node == null || !isBalance) {
            return 0;
        }
        int leftDepth = isBalanceTree02(node.left);
        int rightDepth = isBalanceTree02(node.right);
        if (Math.abs(rightDepth - leftDepth) > 1) {
            isBalance = false;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int isBalanceTree03(TreeNode node) {
        // 判断是否是一颗平衡二叉树就是看左右子树的差距是否大于1，大于1表示不是一个平衡二叉树
        if (node == null) {
            return 0;
        }
        int leftDepth = isBalanceTree03(node.left);
        int rightDepth = isBalanceTree03(node.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            isBalance = false;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // 判断是否是平衡二叉树就是通过判断左右子树的深度是否大于1
    public int isBalanceTree04(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = isBalanceTree04(root.left);
        int rightDepth = isBalanceTree04(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            isBalance = false;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int isBalanceTree05(TreeNode root) {
        // 是否是平衡二叉树，就是左右子树的差是否小于= 1
        if (root == null) {
            return 0;
        }
        int leftDepth = isBalanceTree05(root.left);
        int rightDepth = isBalanceTree05(root.right);
        if (Math.abs(rightDepth - leftDepth) > 1) {
            isBalance = false;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // 判断是否是平衡二叉树的主要点在于左右子树的差值是否为1
    public int isBalanceTree06(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = isBalanceTree06(root.left);
        int rightDepth = isBalanceTree06(root.right);
        if (Math.abs((leftDepth - rightDepth)) > 1) {
            isBalance = false;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // 这种递归的操作必须有一个全局的变量来承接结果  
    public int isBalanceTree07(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = isBalanceTree07(root.left);
        int rightDepth = isBalanceTree07(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            isBalance = false;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int isBalanceTree08(TreeNode root) {
        // 判断是否是平衡二叉树 就是判断左右两个子树的差值是否大于1
        if (root == null) {
            return 0;
        }
        int leftDepth = isBalanceTree08(root.left);
        int rightDepth = isBalanceTree08(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            isBalance = false;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // 平衡二叉树就是左右子树的差值不能大于1
    public int isBalanceTree09(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = isBalanceTree09(root.left);
        int rightDepth = isBalanceTree09(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            isBalance = false;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // 判断当前是否是一颗平衡二叉树
    public int isBalanceTree10(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = isBalanceTree10(root.left);
        int rightDepth = isBalanceTree10(root.right);
        if (Math.abs(rightDepth - leftDepth) > 1) {
            isBalance = false;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }

    
    public static void main(String[] args) {
        BalanceTree balanceTree = new BalanceTree();
        TreeNode tree = balanceTree.createTree();
        balanceTree.isBalanceTree09(tree);
        System.out.println(balanceTree.isBalance);
    }
}
