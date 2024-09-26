package leet34;

import node.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

public class FindPath {

    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

    public boolean findPath(TreeNode root, int target) {
        backtracking(root, target, new ArrayList<>());
        return !ret.isEmpty();
    }

    public void backtracking(TreeNode node, int target, ArrayList<Integer> path) {
        if (node == null) {
            return;
        }
        int value = node.value;
        path.add(value);
        target = target - value;
        if (target == 0 && node.left == null && node.right == null) {
            ret.add(new ArrayList<>(path));
        } else {
            backtracking(node.left, target, path);
            backtracking(node.right, target, path);
        }
        path.remove(path.size() - 1);
    }

    public TreeNode buildRoot() {
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

    public static void main(String[] args) {
        FindPath findPath = new FindPath();
        if (findPath.findPath(findPath.buildRoot(), 22)) {
            for (ArrayList<Integer> nodes : findPath.ret) {
                System.out.println(nodes.toString());

            }
        }
    }
}
