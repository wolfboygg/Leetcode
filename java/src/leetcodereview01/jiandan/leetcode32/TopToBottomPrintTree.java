package leetcodereview01.jiandan.leetcode32;

import javax.sound.sampled.Line;
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

    public void print02(TreeNode node) {
        // 使用栈进行辅助
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
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

    public void print03(TreeNode node) {
        // 二叉树的广序遍历 使用队列辅助
        if (node == null) {
            return;
        }
        List<Integer> list = new ArrayList<>();
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

    public void print04(TreeNode node) {
        // 层次遍历，需要队列辅助
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        List<Integer> list = new ArrayList<>();
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

    public void print05(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
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

    public void print06(TreeNode root) {
        // 使用队列进行辅助
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
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

    public void print07(TreeNode root) {
        // 从上到下打印二叉树就是二叉树的广度遍
        // 需要使用栈进行辅助
        Queue<TreeNode> stack = new LinkedList<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.poll();
            System.out.print(pop.value + " ");
            if (pop.left != null) {
                stack.offer(pop.left);
            }
            if (pop.right != null) {
                stack.offer(pop.right);
            }
        }
    }

    public void print08(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            System.out.print(poll.value + " ");
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
    }

    private void print09(TreeNode node) {
        if (node == null) {
            return;
        }
        // 从上到下打印二叉树
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
            System.out.print(poll.value + " ");
        }
    }

    public void print10(TreeNode root) {
        // 层次遍历 使用队列进行辅助
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
            System.out.print(poll.value + " ");
        }
    }

    public void print11(TreeNode root) {
        // 二叉树的广度遍历 使用一个队列的来实现
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
            System.out.print(poll.value + " ");
        }
    }

    // 广度优先遍历二叉树
    public void print12(TreeNode root) {
        // 使用广度优先遍历就需要使用队列辅助打印
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                System.out.print(poll.value + " ");
            }
        }
    }

    // 广度优先遍历二叉树
    public void print13(TreeNode root) {
        // 广度优先需要使用队列的方式进行进行遍历
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            System.out.print(poll.value + "  ");
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
    }

    public void print14(TreeNode root) {
        // 广序遍历二叉树
        if (root == null) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        // 使用队列进行辅助
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll != null) {
                list.add(poll.value);
                if (poll.left !=  null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        System.out.println(list.toString());
    }

    // 广度优先遍历二叉树
    public void print15(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            System.out.print(poll.value + " ");
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
    }


    public static void main(String[] args) {
        TopToBottomPrintTree topToBottomPrintTree = new TopToBottomPrintTree();
        TreeNode tree = topToBottomPrintTree.createTree();
        topToBottomPrintTree.print15(tree);
    }
}
