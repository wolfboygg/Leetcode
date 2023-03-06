package subtree;

import node.Node;
import node.TreeNode;

/**
 * 判断是否是树的子结构
 */
public class SubTree {


    public TreeNode buildParentTree() {
        TreeNode node = new TreeNode(8);
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(1);
        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        return node;
    }

    public TreeNode buildSubTree() {
        TreeNode node = new TreeNode(8);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(1);
        node.left = node1;
        node.right = node2;
        return node;
    }


    public boolean hasSubTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        // 然后进行判断
        return isSubtreeWithRoot(root1, root2) || hasSubTree(root1.left, root2) || hasSubTree(root1.right, root2);
    }

    public boolean isSubtreeWithRoot(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }

        if (root1 == null) {
            return false;
        }

        if (root1.value != root2.value) {
            return false;
        }

        return isSubtreeWithRoot(root1.left, root2.left) && isSubtreeWithRoot(root1.right, root2.right);
    }


    public static void main(String[] args) {
        SubTree subTree = new SubTree();
        TreeNode root1 = subTree.buildParentTree();
        TreeNode root2 = subTree.buildSubTree();
        System.out.println(subTree.hasSubTree(root1, root2));
    }
}
