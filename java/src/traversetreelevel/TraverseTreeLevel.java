package traversetreelevel;

import node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TraverseTreeLevel {

    public TreeNode buildTree() {
        TreeNode node = new TreeNode(8);
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(1);
        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        return node;
    }

    public void traverseTreeLevel(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.println(temp.value);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }

    }

    public static void main(String[] args) {
        TraverseTreeLevel traverseTreeLevel = new TraverseTreeLevel();
        traverseTreeLevel.traverseTreeLevel(traverseTreeLevel.buildTree());
    }
}
