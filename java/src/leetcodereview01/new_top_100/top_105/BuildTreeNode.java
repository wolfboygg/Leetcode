package leetcodereview01.new_top_100.top_105;


import java.util.HashMap;

public class BuildTreeNode {

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public void preTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preTraversal(root.left);
        preTraversal(root.right);
    }

    private HashMap<Integer, Integer> inOrderIndex = new HashMap<>();

    public TreeNode build(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null) {
            return null;
        }
        for (int i = 0; i < inOrder.length; i++) {
            inOrderIndex.put(inOrder[i], i);
        }
        return realBuild(preOrder, 0, preOrder.length -1, inOrder, 0, inOrder.length -1);
    }

    public TreeNode realBuild(int[] preOrder, int preLeft, int preRight, int[] inOrder, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        System.out.println(preLeft + "-->" + preRight + "--->" + inLeft + "-->" + inRight);
        int rootValue = preOrder[preLeft];
        int rootIndex = inOrderIndex.get(rootValue);
        int leftChildSize = rootIndex - inLeft;
        TreeNode root = new TreeNode(rootValue);
        root.left = realBuild(preOrder, preLeft + 1, preLeft + leftChildSize, inOrder, inLeft, rootIndex - 1);
        root.right = realBuild(preOrder, preLeft + leftChildSize + 1, preRight, inOrder, rootIndex + 1, inRight);
        return root;
    }

    // 通过前序中序构建二叉树
    public TreeNode build01(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null) {
            return null;
        }
        for (int i = 0; i < inOrder.length; i++) {
            inOrderIndex.put(inOrder[i], i);
        }
        return realBuild01(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    public TreeNode realBuild01(int[] preOrder, int preLeft, int preRight, int[] inOrder, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        int rootValue = preOrder[preLeft];
        int rootValueIndex = inOrderIndex.get(rootValue);
        int leftChildCount = rootValueIndex - inLeft;
        TreeNode root = new TreeNode(rootValue);
        root.left = realBuild01(preOrder, preLeft + 1, preLeft + leftChildCount, inOrder, inLeft, rootValueIndex -1);
        root.right = realBuild01(preOrder, preLeft + leftChildCount + 1, preRight,  inOrder, rootValueIndex + 1, inRight);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = { 3,9,20,15,7};
        int[] inOrder = {9,3,15,20,7};
        BuildTreeNode buildTreeNode = new BuildTreeNode();
        TreeNode root = buildTreeNode.build01(pre, inOrder);
        buildTreeNode.preTraversal(root);
    }
}
