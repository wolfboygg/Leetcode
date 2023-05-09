package leet36;

import node.TreeNode;

public class TreeToDoubleList {

    public TreeNode buildTree() {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node4;
        node1.left = node2;
        node1.right = node3;
        return root;
    }

    TreeNode pre, head;

    public TreeNode treeToDoubleList(TreeNode root) {
        if (root == null) return null;
        // 这是一个循环列表
        dfs(root);
        // 执行完以后head为头，pre为尾
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void dfs(TreeNode node) {
        if (node == null) return;
        // 然后中序遍历找到左边的节点
        dfs(node.left);
        if (pre != null) {
            pre.right = node;
        } else {
            head = node;
        }
        node.left = pre;
        pre = node;
        dfs(node.right);
    }

    public static void main(String[] args) {
        TreeToDoubleList treeToDoubleList = new TreeToDoubleList();
        TreeNode root = treeToDoubleList.buildTree();
        TreeNode head = treeToDoubleList.treeToDoubleList(root);
        TreeNode cur = head;
        while(cur != null) {

            System.out.print(cur.value);
            System.out.print(cur.left.value);
            System.out.print(cur.right.value);
            System.out.println();
            if (cur.right != head) {
                cur = cur.right;
            } else {
                cur = null;
            }
        }
    }
}
