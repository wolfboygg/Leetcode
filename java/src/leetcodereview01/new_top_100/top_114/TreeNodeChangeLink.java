package leetcodereview01.new_top_100.top_114;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树展开为链表
 */
public class TreeNodeChangeLink {

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }


    public void flatten(TreeNode root) {
        // 基本的方式通过前序遍历的方式，然后在进行转换
        if (root == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        preTraversal(root, list);
        // 然后遍历集合进行展开
        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i -1);
            TreeNode cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }

        while(root != null) {
            System.out.print(root.value + " ");
            root = root.right;
        }
    }

    public void preTraversal(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        preTraversal(root.left, list);
        preTraversal(root.right, list);
    }

    // 二叉树转换为链表 通过前序遍历的方式
    public void flatten01(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        preTraversal01(root, list);
        // 开始进行转换
        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i - 1);
            TreeNode cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
        while(root != null) {
            System.out.print(root.value + " ");
            root = root.right;
        }
    }

    public void preTraversal01(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        preTraversal01(root.left, list);
        preTraversal01(root.right, list);
    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;

        TreeNodeChangeLink treeNodeChangeLink = new TreeNodeChangeLink();
        treeNodeChangeLink.flatten01(node1);
        // 直接展开 不需要构建Node
    }
}
