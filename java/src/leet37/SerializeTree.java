package leet37;

import node.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

public class SerializeTree {
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

    public void serializeTree(TreeNode node, StringBuilder str) {
        // 进行序列化二叉树，序列化的方式通过前序遍历的方式进行处理
        if (node == null) {
            str.append("None,");
        } else {
            str.append(node.value + ",");
            serializeTree(node.left, str);
            serializeTree(node.right, str);
        }
    }

    public TreeNode deserializeTree(String str) {
        String[] split = str.split(",");
        LinkedList<String> list = new LinkedList<String>(Arrays.asList(split));
        return redeserializeTree(list);
    }

    private TreeNode redeserializeTree(LinkedList<String> list) {
        if (list.get(0).equals("None")) {
            // 将数据移除掉
            list.remove(0);
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        node.left = redeserializeTree(list);
        node.right = redeserializeTree(list);
        return node;
    }


    public static void main(String[] args) {
        SerializeTree serializeTree = new SerializeTree();
        TreeNode node = serializeTree.buildTree();
        StringBuilder builder = new StringBuilder();
        serializeTree.serializeTree(node, builder);
        System.out.println(builder.toString());
        TreeNode treeNode = serializeTree.deserializeTree(builder.toString());
        traveser(treeNode);
    }

    private static void traveser(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.value);
        traveser(treeNode.left);
        traveser(treeNode.right);
    }
}
