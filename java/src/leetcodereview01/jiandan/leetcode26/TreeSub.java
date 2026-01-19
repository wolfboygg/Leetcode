package leetcodereview01.jiandan.leetcode26;


public class TreeSub {

    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public boolean isSub(TreeNode root, TreeNode node) {
        if (root == null || node == null) {
            return false;
        }
        return isSubTreeWithRoot(root, node) || isSub(root.left, node) || isSub(root.right, node);
    }

    private boolean isSubTreeWithRoot(TreeNode root, TreeNode node) {
        if (node == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.value != node.value) {
            return false;
        }
        return isSubTreeWithRoot(root.left, node.left) && isSubTreeWithRoot(root.right, node.right);
    }


    public boolean isSub01(TreeNode root, TreeNode node) {
        if (root == null || node == null) {
            return false;
        }
        return isSubTreeWithRoot01(root, node) || isSub01(root.left, node) || isSub01(root.right, node);
    }

    private boolean isSubTreeWithRoot01(TreeNode root, TreeNode node) {
        if (node == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (node.value != root.value) {
            return false;
        }
        return node.value == root.value && isSubTreeWithRoot01(root.left, node.left) && isSubTreeWithRoot01(root.right, node.right);
    }

    public boolean isSub002(TreeNode root, TreeNode childRoot) {
        if (root == null || childRoot == null) {
            return false;
        }
        return isSubTreeWithRoot02(root, childRoot);
    }

    private boolean isSubTreeWithRoot02(TreeNode root, TreeNode childRoot) {
        if (childRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return root.value == childRoot.value && isSubTreeWithRoot02(root.left, childRoot.left) && isSubTreeWithRoot02(root.right, childRoot.right);
    }

    public boolean isSub03(TreeNode root, TreeNode childRoot) {
        if (root == null || childRoot == null) {
            return false;
        }
        return isSubtreeWithRoot03(root, childRoot);
    }

    private boolean isSubtreeWithRoot03(TreeNode root, TreeNode childRoot) {
        if (root == null) {
            return false;
        }
        if (childRoot == null) {
            return true;
        }
        return root.value == childRoot.value && isSubtreeWithRoot03(root.left, childRoot.left) && isSubtreeWithRoot03(root.right, childRoot.right);
    }

    public boolean isSub04(TreeNode root, TreeNode childRoot) {
        if (root == null || childRoot == null) {
            return false;
        }
        return isSubtreeWithRoot04(root, childRoot);
    }

    private boolean isSubtreeWithRoot04(TreeNode root, TreeNode childRoot) {
        if (root == null) {
            return false;
        }
        if (childRoot == null) {
            return true;
        }
        return root.value == childRoot.value && isSubtreeWithRoot04(root.left, childRoot.left) && isSubtreeWithRoot04(root.right, childRoot.right);
    }

    public boolean isSub05(TreeNode root, TreeNode node) {
        if (root == null || node == null) {
            return false;
        }
        return isSubtreeWithRoot05(root, node) || isSub05(root.left, node) || isSub05(root.right, node);
    }

    private boolean isSubtreeWithRoot05(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        if (node == null) {
            return true;
        }
        return root.value == node.value && isSubtreeWithRoot05(root.left, node.left) && isSubtreeWithRoot05(root.right, node.right);
    }

    public boolean isSub06(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return isSubtreeWIthRoot06(root1, root2) || isSub(root1.left, root2) || isSub(root1.right, root2);
    }

    private boolean isSubtreeWIthRoot06(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return false;
        }
        if (root2 == null) {
            return true;
        }
        return root1.value == root2.value && isSubtreeWithRoot05(root1.left, root2.left) && isSubtreeWithRoot05(root1.right, root2.right);
    }

    public boolean isSub07(TreeNode root, TreeNode node) {
        // 判断是不是一棵树的子结构，需要挨个进行递归判断 当然首先要跟节点相同
        if (root == null || node == null) {
            return false;
        }
        return isSubTreeWithRoot07(root, node) || isSub(root.left, node) || isSub(root.right, node);
    }

    public boolean isSubTreeWithRoot07(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        if (node == null) {
            return true;
        }
        return root.value == node.value && isSubTreeWithRoot07(root.left, node.left) && isSubTreeWithRoot07(root.right, node.right);
    }

    public boolean isSub08(TreeNode root, TreeNode node) {
        // 判断是不是一个字结构
        if (root == null || node == null) {
            return false;
        }
        return isSubtreeWithRoot08(root, node) || isSub08(root.left, node) || isSub08(root.right, node);
    }

    private boolean isSubtreeWithRoot08(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        if (node == null) {
            return true;
        }
        return root.value == node.value && isSubtreeWithRoot08(root.left, node.left) && isSubtreeWithRoot08(root.right, node.right);
    }

    public boolean isSub09(TreeNode root, TreeNode childRoot) {
        // 判断是否是子树
        if (root == null || childRoot == null) {
            return false;
        }
        return realIsSub08(root, childRoot) || isSub09(root.left, childRoot) || isSub09(root.right, childRoot);
    }

    public boolean realIsSub08(TreeNode root, TreeNode child) {
        if (root == null) {
            return false;
        }
        if (child == null) {
            return true;
        }
        return root.value == child.value && realIsSub08(root.left, child.left) && realIsSub08(root.right, child.right);
    }

    // 判断是否是树的子结构 使用递归的方式进行判断
    public boolean isSub10(TreeNode root, TreeNode child) {
        // 判断null的 需要判断是否有一个为null
        if (root == null || child == null) {
            return false;
        }
        return isSubTreeWithRoot10(root, child) || isSub10(root.left, child) || isSub10(root.right, child);
    }

    public boolean isSubTreeWithRoot10(TreeNode root, TreeNode child) {
        // 校验
        if (root == null) {
            return false;
        }
        if (child == null) {
            return true;
        }
        return root.value == child.value && isSubTreeWithRoot10(root.left,child.left) && isSubTreeWithRoot10(root.right, child.right);
    }

    public boolean isSub11(TreeNode root, TreeNode target) {
        if (root == null || target == null) {
            return false;
        }
        return realIsSub11(root, target) || isSub11(root.left, target) || isSub11(root.right, target);
    }

    public boolean realIsSub11(TreeNode root, TreeNode target) {
        if (root == null) {
            return false;
        }
        if (target == null) {
            return true;
        }
        return root.value == target.value && realIsSub11(root.left, target.left) && realIsSub11(root.right, target.right);
    }

    public boolean isSub12(TreeNode root, TreeNode node) {
        // 是否是子树
        if (root == null || node == null) {
            return false;
        }
        return realIsSub12(root, node) || isSub12(root.left, root) || isSub12(root.right, root);
    }

    public boolean realIsSub12(TreeNode root, TreeNode node) {
        if (root == null || node == null) {
            return false;
        }
        return root.value == node.value && realIsSub12(root.left, node.left) && realIsSub12(root.right, node.right);
    }

    public boolean isSub13(TreeNode root, TreeNode node1) {
        if (root == null || node1 == null) {
            return false;
        }
        return realIsSub13(root, node1) || isSub13(root.left, node1) || isSub13(root.right, node1);
    }

    public boolean realIsSub13(TreeNode root, TreeNode node1) {
        if (root == null) {
            return false;
        }
        if (node1 == null) {
            return true;
        }
        return root.value == node1.value && realIsSub13(root.left, node1.left) && realIsSub13(root.right, node1.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(8);
        TreeNode node10 = new TreeNode(7);

        node8.left = node9;
        node8.right = node10;

        System.out.println(new TreeSub().isSub13(node1, node8));

    }
}
