package leetcodereview01.new_top_100.top_437;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeTargetSum {

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

    private List<List<Integer>> ret = new ArrayList<>();

    public boolean findPath(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        realFindPath(root, target, new ArrayList<>());
        return !ret.isEmpty();
    }

    public void realFindPath(TreeNode root, int target, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.value);
        target -= root.value;
        if (root.left == null && root.right == null && target == 0) {
            ret.add(new ArrayList<>(result));
        } else {
            realFindPath(root.left, target, result);
            realFindPath(root.right, target, result);
        }
        // 移除掉最后一个 因为是递归，肯定会走结束的这一步
        result.removeLast();
    }

    public boolean findPath01(TreeNode root, int target) {
        // 通过递归的方式找到对应path
        if (root == null) {
            return false;
        }
        realFindPath01(root, target, new ArrayList<>());
        return !ret.isEmpty();
    }

    public void realFindPath01(TreeNode root, int target, List<Integer> list) {
        if (root == null) {
            return;
        }
        target -= root.value;
        list.add(root.value);
        if (target == 0 && root.left == null && root.right == null) {
            ret.add(new ArrayList<>(list));
        } else {
            realFindPath01(root.left, target, list);
            realFindPath01(root.right, target, list);
        }
        list.removeLast();
    }

    public boolean findPath02(TreeNode root, int target) {
        // 使用递归的方式进行处理
        if (root == null) {
            return false;
        }
        // 通过递归的方式进行处理
        realFindPath02(root, target, new ArrayList<Integer>());
        return !ret.isEmpty();
    }

    public void realFindPath02(TreeNode root, int target, List<Integer> list) {
        if (root == null) {
            return;
        }
        target -= root.value;
        list.add(root.value);
        if (root.right == null && root.left == null && target == 0) {
            ret.add(new ArrayList<>(list));
        } else {
            realFindPath02(root.left, target, list);
            realFindPath02(root.right, target, list);
        }
        list.removeLast();
    }

    public boolean findPath03(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        realFindPath03(root, target, new ArrayList<>());
        return !ret.isEmpty();
    }

    public void realFindPath03(TreeNode root, int target, List<Integer> list) {
        if (root == null) {
            return;
        }
        target -= root.value;
        list.add(root.value);
        if (target == 0 && root.left == null && root.right == null) {
            ret.add(new ArrayList<>(list));
        } else {
            realFindPath03(root.left, target, list);
            realFindPath03(root.right, target, list);
        }
        list.removeLast();
    }

    public static void main(String[] args) {
        TreeNodeTargetSum treeFindSumTargetPath = new TreeNodeTargetSum();
        TreeNode tree = treeFindSumTargetPath.createTree();
        boolean isExit = treeFindSumTargetPath.findPath03(tree, 22);
        if (isExit) {
            System.out.println(treeFindSumTargetPath.ret.toString());
        }

    }
}
