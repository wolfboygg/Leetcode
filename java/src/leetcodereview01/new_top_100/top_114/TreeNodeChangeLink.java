package leetcodereview01.new_top_100.top_114;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树展开为链表
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
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

    // 二叉树转换为链表
    public void flatten03(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        preTraversal02(root, list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i-1);
            TreeNode cur = list.get(i);
            pre.right = cur;
            pre.left = null;
        }
        while(root != null) {
            System.out.print(root.value + " ");
            root = root.right;
        }
    }

    public void preTraversal02(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        preTraversal02(root.left, list);
        preTraversal02(root.right, list);
    }

    // 通过前序遍历排好序之后在进行连接
    public void flatten04(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        preOrderTraversal04(root, list);
        // 开始处理
        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i-1);
            TreeNode node = list.get(i);
            pre.left = null;
            pre.right = node;
        }
        while(root != null) {
            System.out.print(root.value + " ");
            root = root.right;
        }
    }

    public void preOrderTraversal04(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        preOrderTraversal04(root.left, list);
        preOrderTraversal04(root.right, list);
    }

    // 二叉树转换为链表，需要通过List来进行转换
    public void flatten05(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        preOrderTraversal05(root, list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i - 1);
            TreeNode node = list.get(i);
            pre.left = null;
            pre.right = node;
        }
        while(root != null) {
            System.out.print(root.value + " ");
            root = root.right;
        }
    }

    public void preOrderTraversal05(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        preOrderTraversal05(root.left, list);
        preOrderTraversal05(root.right, list);
    }


    public void flatten06(TreeNode root) {
        // 借助list来实现
        if (root == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        preOrderTraversal06(root, list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i-1);
            TreeNode cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
        TreeNode treeNode = list.get(0);
        while (treeNode != null) {
            System.out.print(treeNode.value + " ");
            treeNode = treeNode.right;
        }
    }

    public void preOrderTraversal06(TreeNode root, List<TreeNode>  list) {
        if (root == null) {
            return;
        }
        list.add(root);
        preOrderTraversal06(root.left, list);
        preOrderTraversal06(root.right, list);
    }


    // 二叉树转换为列表。其实不用考虑递归直接转换，可以使用list存储，根据前序列进行遍历就好了
    public void flatten07(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        preorderTraversal07(root, list);

        for (int i = 1; i < list.size(); i++) {
            TreeNode node = list.get(i);
            TreeNode pre = list.get(i-1);
            pre.right = node;
            pre.left = null;
        }
        while(root != null) {
            System.out.print(root.value + " ");
            root = root.right;
        }

    }

    public void preorderTraversal07(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        preorderTraversal07(root.left, list);
        preorderTraversal07(root.right, list);
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
        treeNodeChangeLink.flatten07(node1);
        // 直接展开 不需要构建Node
    }
}
