package leetcodereview01.jiandan.leetcode34;


import java.util.ArrayList;
import java.util.List;

public class TreeFindSumTargetPath {

    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public TreeNode createTree() {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(12);
        root.left = node1;
        root.right = node4;
        node1.left = node2;
        node1.right = node3;
        return root;
    }

    List<List<Integer>> ret = new ArrayList<>();

    public boolean findPath(TreeNode node, int target) {
        if (node == null) {
            return false;
        }
        backTracking(node, target, new ArrayList<Integer>());
        return !ret.isEmpty();
    }

    public void backTracking(TreeNode node, int target, ArrayList<Integer> arr) {
        if (node == null) {
            return;
        }
        int value = node.value;
        target -= value;
        arr.add(value);
        if (target == 0 && node.left == null && node.right == null) {
            ret.add(new ArrayList<>(arr));
        } else {
            backTracking(node.left, target, arr);
            backTracking(node.right, target, arr);
        }
        arr.remove(arr.size() - 1);
    }

    public boolean findPath01(TreeNode node, int target) {
        if (node == null) {
            return false;
        }
        backTracking01(node, target, new ArrayList<Integer>());
        return !ret.isEmpty();
    }

    private void backTracking01(TreeNode node, int target, ArrayList<Integer> integers) {
        // 记得回溯
        if (node == null) {
            return;
        }
        target -= node.value;
        integers.add(node.value);
        if (target == 0 && node.left == null && node.right == null) { // 路径，必须到跟节点
            ret.add(new ArrayList<>(integers));
        } else {
            backTracking(node.left, target, integers);
            backTracking(node.right, target, integers);
        }
        integers.remove(integers.size() - 1);
    }

    public static void main(String[] args) {
        TreeFindSumTargetPath treeFindSumTargetPath = new TreeFindSumTargetPath();
        TreeNode tree = treeFindSumTargetPath.createTree();
        boolean isExit = treeFindSumTargetPath.findPath(tree, 22);
        if (isExit) {
            System.out.println(treeFindSumTargetPath.ret.toString());
        }
    }
}
