package leetcodereview01.jiandan.leetcode32;

import java.util.*;

public class TopToBottomPrintTree {

    public static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    // 3,9,20,null,null,15,7
    public TreeNode createTree() {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        return node1;
    }


    public void print(TreeNode node) {
        // 使用队列实现
        List<Object> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            list.add(poll.value);
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
        System.out.println(list.toString());
    }

    public void printMoreLine(TreeNode head) {
        List<List<Integer>> moreLine = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                list.add(poll.value);
            }
            moreLine.add(list);
        }
        System.out.println(moreLine.toString());
    }

    public void zPrintTree(TreeNode head) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        // 多行吧
        List<List<Integer>> moreLine = new ArrayList<>();
        boolean reverse = false;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (!reverse) {
                    list.add(poll.value);
                } else {
                    list.add(0, poll.value);
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            moreLine.add(list);
            reverse = !reverse;
        }
        System.out.println(moreLine.toString());
    }


    public static void main(String[] args) {
        TopToBottomPrintTree topToBottomPrintTree = new TopToBottomPrintTree();
        TreeNode tree = topToBottomPrintTree.createTree();
        topToBottomPrintTree.zPrintTree(tree);
    }
}
