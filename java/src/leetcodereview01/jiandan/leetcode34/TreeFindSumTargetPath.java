package leetcodereview01.jiandan.leetcode34;



import java.lang.reflect.Array;
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

    public boolean findPath02(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        // 进行递归处理
        backTracking02(root, target, new ArrayList<>());// 就是找到当前节点然后剪掉root.value 最后看是否为0，必须到跟节点
        return !ret.isEmpty();
    }

    public void backTracking02(TreeNode root, int target, List<Integer> list) {
        if (root == null) {
            return;
        }
        target -= root.value;
        list.add(root.value);
        if (root.left == null && root.right == null && target == 0) {
            // 表示找到了路径
            ret.add(new ArrayList<>(list));
        } else {
            backTracking02(root.left, target, list);
            backTracking02(root.right, target, list);
        }
        list.remove(list.size() - 1);
    }

    public boolean findPath03(TreeNode root, int target) {
        // 确定是路径，必须到子节点
        if (root == null) {
            return false;
        }
        backTracking03(root, target, new ArrayList<>());
        return !ret.isEmpty();
    }

    private void backTracking03(TreeNode root, int target, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }
        target -= root.value;
        arr.add(root.value);
        if (target == 0 && root.left == null && root.right == null) {
            ret.add(new ArrayList<>(arr));
        } else {
            backTracking03(root.left, target, arr);
            backTracking03(root.right, target, arr);
        }
        arr.remove(arr.size() -1);
    }

    public boolean findPath04(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        backtracking04(root, target, new ArrayList<Integer>());
        return !ret.isEmpty();
    }

    private void backtracking04(TreeNode root, int target, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }
        target -= root.value;
        arr.add(root.value);
        if (target == 0 && root.left == null && root.right == null) {
            ret.add(new ArrayList<>(arr));
        } else {
            backtracking04(root.left, target, arr);
            backtracking04(root.right, target, arr);
        }
        arr.remove(arr.size() - 1);
    }

    public boolean findPath05(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        backTracking05(root, target, new ArrayList<Integer>());
        return !ret.isEmpty();
    }

    public void backTracking05(TreeNode root, int target, List<Integer> list) {
        if (root == null) {
            return;
        }
        target -= root.value;
        list.add(root.value);
        if (root.left == null && root.right == null && target == 0) {
            ret.add(new ArrayList<>(list));
        } else {
            backTracking05(root.left, target, list);
            backTracking05(root.right, target, list);
        }
        list.remove(list.size() -1);

    }

    public boolean findPath06(TreeNode root, int target) {
        // 找到路径 就需要不停的回溯
        if (root ==  null) {
            return false;
        }
        backTracking06(root, target, new ArrayList<Integer>());
        return !ret.isEmpty();
    }

    public void backTracking06(TreeNode root, int target, ArrayList<Integer> treeNodes) {
        if (root == null) {
            return;
        }
        target -= root.value;
        treeNodes.add(root.value);
        if (target == 0 && root.right == null && root.left == null) {// 到达叶子节点
            ret.add(new ArrayList<>(treeNodes)); // 这里要重新new一个集合
        } else {
            backTracking06(root.left, target, treeNodes);
            backTracking06(root.right, target, treeNodes);
        }
        treeNodes.remove(treeNodes.size() - 1);
    }

    public boolean findPath07(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        backTracking07(root, target, new ArrayList<Integer>());
        return !ret.isEmpty();
    }

    public void backTracking07(TreeNode root, int target, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }
        target -= root.value;
        arr.add(root.value);
        if (target == 0 && root.left == null && root.right == null) {
            ret.add(new ArrayList<>(arr));
        } else {
            backTracking07(root.left, target, arr);
            backTracking07(root.right, target, arr);
        }
        arr.remove(arr.size() - 1);
    }

    public boolean findPath08(TreeNode node, int target) {
        if (node == null) {
            return false;
        }
        backTracking08(node, target, new ArrayList<>());
        return ret.size() != 0;
    }

    public void backTracking08(TreeNode node, int target, List<Integer> arr) {
        if (node == null) {
            return ;
        }
        target -= node.value;
        arr.add(node.value);
        if (node.left == null && node.right == null && target == 0) {
            ret.add(new ArrayList<>(arr));
        } else {
            backTracking08(node.left, target, arr);
            backTracking08(node.right, target, arr);
        }
        arr.remove(arr.size() -1);
    }

    public boolean findPath09(TreeNode root, int target) {
        // 从二叉树找到一个path 每一个节点的和为target。需要注意一点就是需要从根出发，到叶子节点结束
        // 同样思路还是通过递归进行遍历
        if (root == null) {
            return false;
        }
        backTracking09(root, target, new ArrayList<Integer>());
        return !ret.isEmpty();
    }

    private void backTracking09(TreeNode root, int target, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        target -= root.value;
        list.add(root.value);
        if (target == 0 && root.left == null && root.right == null) {
            ret.add(new ArrayList<>(list));
        } else {
            backTracking09(root.left, target, list);
            backTracking09(root.right, target, list);
        }
        list.remove(list.size()-1);
    }

    public boolean findPath10(TreeNode root, int target) {
        // 还是需要通过递归的进行查找
        if (root == null) {
            return false;
        }
        backTracking10(root, target, new ArrayList<Integer>());
        return !ret.isEmpty();
    }

    public void backTracking10(TreeNode root, int target, ArrayList<Integer> integers) {
        if (root == null) {
            return;
        }
        target -= root.value;
        integers.add(root.value);
        if (target == 0 && root.left == null && root.right == null) {
            ret.add(new ArrayList<>(integers));
        } else {
            backTracking10(root.left, target, integers);
            backTracking10(root.right, target, integers);
        }
        integers.remove(integers.size() - 1);

    }

    // 从二叉树中找到一个路径和目标值相同 递归的方式处理
    public boolean findPath11(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        // 通过递归的方式进行处理
        realFindPath(root, target, new ArrayList<Integer>());
        return !ret.isEmpty();
    }

    public void realFindPath(TreeNode root, int target, List<Integer> list) {
        if (root == null) {
            return;
        }
        // 看看是否为0
        list.add(root.value);
        target -= root.value;
        if (target == 0 && root.left == null && root.right == null) {
            // 表示找到了
            ret.add(new ArrayList<>(list));
        } else {
            // 接着找左右子树
            realFindPath(root.left, target, list);
            realFindPath(root.right, target, list);
        }
        list.remove(list.size() - 1);
    }

    // 在树上找到一个路径 为target值 注意必须是最后一个节点为叶子节点这样的才是路径
    public boolean findPath12(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        realFindPath12(root, target, new ArrayList<>());
        return !this.ret.isEmpty();
    }

    public void realFindPath12(TreeNode root, int target, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }
        target -= root.value;
        arr.add(root.value);
        if (target == 0 && root.right == null && root.left == null) {
            // 表示路径找到
            ret.add(new ArrayList<>(arr));
        } else {
            realFindPath12(root.left, target, arr);
            realFindPath12(root.right, target, arr);
        }
        arr.remove(arr.size() - 1);
    }


    public static void main(String[] args) {
        TreeFindSumTargetPath treeFindSumTargetPath = new TreeFindSumTargetPath();
        TreeNode tree = treeFindSumTargetPath.createTree();
        boolean isExit = treeFindSumTargetPath.findPath12(tree, 22);
        if (isExit) {
            System.out.println(treeFindSumTargetPath.ret.toString());
        }
    }
}
