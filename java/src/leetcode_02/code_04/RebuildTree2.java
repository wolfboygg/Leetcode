package leetcode_02.code_04;

import java.util.HashMap;
import java.util.Map;

public class RebuildTree2 {
    public static void main(String[] args) {
        RebuildTree2 rebuildTree2 = new RebuildTree2();
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};
        TreeNode treeNode = rebuildTree2.rebuildTree(preOrder, inOrder);
        if (treeNode == null) {
            System.out.println("不能构建二叉树");
            return;
        }
        System.out.println(treeNode.val);

        String str = "%s, %s xxxxx";
        System.out.println(String.format(str, "", "aaaa"));
    }

    private static Map<Integer, Integer> indexHashMap = new HashMap<>();

    public TreeNode rebuildTree(int[] preOrder, int[] inOrder) {

        for (int i = 0; i < inOrder.length; i++) {
            indexHashMap.put(inOrder[i], i);
        }

        return rebuildTree(preOrder, 0, preOrder.length - 1, 0);
    }

    public TreeNode rebuildTree(int[] preOrder, int preLeft, int preRight, int inLeft) {
        if (preLeft > preRight) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preLeft]);
        int leftCount = indexHashMap.get(root.val) - inLeft;
        root.left = rebuildTree(preOrder, preLeft + 1, preLeft + leftCount, inLeft);
        root.right = rebuildTree(preOrder, preLeft + leftCount + 1, preRight, inLeft + leftCount + 1);
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
}
