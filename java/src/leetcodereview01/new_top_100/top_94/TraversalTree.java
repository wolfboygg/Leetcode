package leetcodereview01.new_top_100.top_94;

import leetcodereview01.top100.top_94.TreeInorderTraversal;

import java.util.Stack;

public class TraversalTree {
    static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private void traversalByDG(TreeNode root) {
        if (root == null) {
            return;
        }
        traversalByDG(root.left);
        System.out.print(root.value + " ");
        traversalByDG(root.right);
    }

    private void traversalByStack(TreeNode root) {
        if (root == null) {
            return;
        }
        // 通过栈进行遍历
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            if (pop != null) {
                System.out.print(pop.value + " ");
                root = pop.right;
            }
        }
    }

    private void preTraversalByStack(TreeNode root) {
        if (root == null) {
            return;
        }
        // 通过栈进行遍历
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                System.out.print(root.value + " ");
                root = root.left;
            }
            TreeNode pop = stack.pop();
            if (pop != null) {
//                System.out.print(pop.value + " ");
                root = pop.right;
            }
        }
    }

    public void traverseByDG01(TreeNode root) {
        if (root == null) {
            return;
        }
        traverseByDG01(root.left);
        System.out.print(root.value + " ");
        traverseByDG01(root.right);
    }

    public void preTraversalByStack01(TreeNode root) {
        if (root == null) {
            return;
        }
        // 通过栈进行遍历
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                System.out.print(pop.value + " ");
                root = pop.right;
            }
        }
    }

    public void traverseByDG02(TreeNode root) {
        if (root == null) {
            return;
        }
        traverseByDG02(root.left);
        System.out.print(root.value + " ");
        traverseByDG02(root.right);
    }

    public void traverseByStack02(TreeNode root) {
        if (root == null) {
            return;
        }
        // 通过栈
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            System.out.print(node.value + " ");
            root = node.right;
        }
    }

    // 中序遍历二叉树
    public void traverseByDG03(TreeNode root) {
        if (root == null) {
            return;
        }
        traverseByDG03(root.left);
        System.out.print(root.value + " ");
        traverseByDG03(root.right);
    }

    public void traverseByStack03(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                System.out.print(node.value + " ");
                root = node.right;
            }
        }
    }

    public void traversalByDG04(TreeNode root) {
        if (root == null) {
            return;
        }
        traversalByDG04(root.left);
        System.out.print(root.value + " ");
        traversalByDG04(root.right);
    }

    public void traversalByStack04(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            System.out.print(pop.value + " ");
            root = pop.right;
        }
    }

    public void traversalByDG05(TreeNode root) {
        if (root == null) {
            return;
        }
        traversalByDG05(root.left);
        System.out.print(root.value + " ");
        traversalByDG05(root.right);
    }

    public void traversalByStack05(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            if (pop != null) {
                System.out.print(pop.value + " ");
                root = pop.right;
            }
        }
    }

    public void traversalByStack06(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            System.out.print(pop.value + " ");
            root = pop.right;
        }
    }

    public void traversalByStack07(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            System.out.print(pop.value + " ");
            if (pop.right != null) {
                root = pop.right;
            }
        }
    }

    public void traversalByStack08(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || node != null) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
            TreeNode pop = stack.pop();
            if (pop != null) {
                System.out.print(pop.value + " ");
                node = pop.right;
            }
        }
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node1.left = node3;

        TraversalTree traversalTree = new TraversalTree();
        traversalTree.traversalByDG05(node1);
        System.out.println();
        traversalTree.traversalByStack08(node1);

    }
}
