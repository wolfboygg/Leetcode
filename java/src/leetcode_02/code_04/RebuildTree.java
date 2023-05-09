package leetcode_02.code_04;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class RebuildTree {
    // 缓存中序遍历数组每个值对应的索引
    private Map<Integer, Integer> indexForInOrders = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++)
            indexForInOrders.put(in[i], i);
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR)
            return null;
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = indexForInOrders.get(root.val);
        System.out.println("inIndex:" + inIndex);// inIndex 表示的是个数
        int leftTreeSize = inIndex - inL;
        System.out.println("leftTreeSize:" + leftTreeSize);
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }

    class TreeNode {
        public int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public static void main(String[] args) {
//        int[] preOrder = {3, 9, 20, 15, 7};
//        int[] inOrder = {9, 3, 15, 20, 7};
//        RebuildTree rebuildTree = new RebuildTree();
//        TreeNode treeNode = rebuildTree.reConstructBinaryTree(preOrder, inOrder);
//        rebuildTree.preTraversal(treeNode);
    }

    public void preTraversal(TreeNode treeNode) {
        if (treeNode == null) {
            System.out.print("null");
            return;
        }
        System.out.print(treeNode.val);
        preTraversal(treeNode.left);
        preTraversal(treeNode.right);
    }


}
