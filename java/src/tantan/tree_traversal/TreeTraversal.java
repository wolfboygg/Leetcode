package tantan.tree_traversal;

import tantan.TreeNode;

import java.util.*;

public class TreeTraversal {
    /**
     * 构建二叉树
     *
     * @param inputList
     * @return
     */
    public TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        TreeNode node = null;
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * 前序遍历二叉树
     *
     * @param node
     */
    public void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data);
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }

    /**
     * 中序遍历二叉树
     *
     * @param node
     */
    public void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.leftChild);
        System.out.print(node.data);
        inOrderTraversal(node.rightChild);
    }

    /**
     * 后序遍历二叉树
     *
     * @param node
     */
    public void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        System.out.print(node.data);
    }

    /**
     * 前序遍历二叉树不使用递归
     *
     * @param node
     */
    public void preOrderTraversalByStack(TreeNode node) {
        Stack<TreeNode> valueStack = new Stack<>();
        TreeNode treeNode = node;
        while(treeNode != null || !valueStack.isEmpty()) {
            while(treeNode != null) {
                System.out.print(treeNode.data);
                valueStack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if (!valueStack.isEmpty()) {
                TreeNode pop = valueStack.pop();
                treeNode = pop.rightChild;
            }
        }
    }

    /**
     * 中序遍历二叉树不使用递归
     *
     * @param node
     */
    public void inOrderTraversalByStack(TreeNode node) {
        Stack<TreeNode> helpStack = new Stack<>();
        TreeNode treeNode = node;
        while(treeNode != null || !helpStack.isEmpty()) {
            while(treeNode != null) {
                helpStack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if (!helpStack.isEmpty()) {
                TreeNode pop = helpStack.pop();
                System.out.print(pop.data);
                treeNode = pop.rightChild;
            }
        }
    }

    /**
     * 后序遍历二叉树不使用递归
     *
     * @param node
     */
    public void postOrderTraversalByStack(TreeNode node) {
        // 后序遍历比较复杂
        Stack<TreeNode> helpStack = new Stack<>();
        TreeNode treeNode = node;
        TreeNode pre = null;
        while(treeNode != null || !helpStack.isEmpty()) {
            while(treeNode != null) {
                helpStack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            treeNode = helpStack.pop();
            if (treeNode.rightChild == null || treeNode.rightChild == pre) {
                System.out.print(treeNode.data);
                pre = treeNode;
                treeNode = null;
            } else {
                helpStack.push(treeNode);
                treeNode = treeNode.rightChild;
            }
        }
    }

    public void preOrderTraversal01(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data);
        preOrderTraversal01(node.leftChild);
        preOrderTraversal01(node.rightChild);
    }

    public void inOrderTraversal01(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal01(node.leftChild);
        System.out.print(node.data);
        inOrderTraversal01(node.rightChild);
    }

    public void postOrderTraversal01(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal01(node.leftChild);
        postOrderTraversal01(node.rightChild);
        System.out.print(node.data);
    }

    public void preOrderTraversalByStack01(TreeNode node) {
        if (node == null) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(node != null || !stack.isEmpty()) {
            while(node != null) {
                list.add(node.data);
                stack.push(node);
                node = node.leftChild;
            }
            if (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                node = pop.rightChild;
            }
        }
        System.out.print(list.toString());
    }

    public void inOrderTraversalByStack01(TreeNode node) {
        if (node == null) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(node != null || !stack.isEmpty()) {
            while(node != null) {
                stack.push(node);
                node = node.leftChild;
            }
            if (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                list.add(pop.data);
                node = pop.rightChild;
            }
        }
        System.out.print(list.toString());
    }

    public void postOrderTraversalByStack01(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        List<Integer> list = new ArrayList<>();
        while(node != null || !stack.isEmpty()) {
            while(node != null) {
                stack.push(node);
                node = node.leftChild;
            }
            if (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                if (pop.rightChild == null || pop.rightChild == pre) {
                    list.add(pop.data);
                    pre = pop;
                } else {
                    stack.push(pop);
                    node = pop.rightChild;
                }
            }
        }
        System.out.print(list.toString());
    }

    public void preOrderTraversalByStack02(TreeNode root) {
        if (root == null) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                list.add(root.data);
                stack.push(root);
                root = root.leftChild;
            }
            if (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                root = pop.rightChild;
            }
        }
        System.out.print(list.toString());
    }

    public void inOrderTraversalByStack02(TreeNode root) {
        if (root == null) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.leftChild;
            }
            if (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                list.add(pop.data);
                root = pop.rightChild;
            }
        }
        System.out.print(list.toString());
    }

    public void postOrderTraversalByStack02(TreeNode root) {
        if (root == null) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.leftChild;
            }
            TreeNode pop = stack.pop();
            if (pop.rightChild == null || pop.rightChild == pre) {
                pre = pop;
                list.add(pop.data);
            } else {
                stack.push(pop);
                root = pop.rightChild;
            }
        }
        System.out.print(list.toString());
    }

    public void preOrderTraversal03(TreeNode root) {
        // 通过递归的方式进行遍历
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderTraversal03(root.leftChild);
        preOrderTraversal03(root.rightChild);
    }

    public void inOrderTraversal03(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal03(root.leftChild);
        System.out.print(root.data + " ");
        inOrderTraversal03(root.rightChild);
    }

    public void postOrderTraversal03(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal03(root.leftChild);
        postOrderTraversal03(root.rightChild);
        System.out.print(root.data + " ");
    }

    // 不使用递归的方式进行实现
    public void preOrderTraversalByStack03(TreeNode root) {
        if (root == null) return;
        // 使用stack可以遍历处理
        Stack<TreeNode> stack = new Stack<>();
        // 这里不能直接使用while循环进行处理,需要双层处理
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                System.out.print(root.data + " ");
                stack.push(root);
                root = root.leftChild;
            }
            if (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                root = pop.rightChild;
            }
        }
    }

    public void inOrderTraversalByStack03(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null ||  !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.leftChild;
            }
            if (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                System.out.print(pop.data + " ");
                root = pop.rightChild;
            }
        }
    }

    public void postOrderTraversalByStack03(TreeNode root) {
        // 后续遍历有点复杂
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;// 需要记录前一个节点
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.leftChild;
            }
            // 根节点还是要入栈 需要二次入栈
            TreeNode pop = stack.pop();
            if (pop.rightChild == null || pop.rightChild == pre) {
                pre = pop;
                System.out.print(pop.data + " ");
            } else {
                stack.push(pop);
                root = pop.rightChild;
            }
        }
    }

    // 递归进行遍历
    public void preOrderTraversal04(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderTraversal04(root.leftChild);
        preOrderTraversal04(root.rightChild);
    }

    public void inOrderTraversal04(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal04(root.leftChild);
        System.out.print(root.data + " ");
        inOrderTraversal04(root.rightChild);
    }

    public void postOrderTraversal04(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal04(root.leftChild);
        postOrderTraversal04(root.rightChild);
        System.out.print(root.data + " ");
    }

    public void preOrderTraversalByStack04(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                System.out.print(root.data + " ");
                root = root.leftChild;
            }
            if (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                root = pop.rightChild;
            }
        }
    }

    public void inOrderTraversalByStack04(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.leftChild;
            }
            if (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                System.out.print(pop.data + " ");
                root = pop.rightChild;
            }
        }
    }

    public void postOrderTraversalByStack04(TreeNode root) {
        // 后续遍历比较复杂一点就是临界条件，需要是right== null || root.right == pre
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.leftChild;
            }
            TreeNode pop = stack.pop();
            if (pop.rightChild == null || pop.rightChild == pre) {
                System.out.print(pop.data + " ");
                pre = pop;
            } else {
                stack.push(pop);
                root = pop.rightChild;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(
                3, 2, 9, null, null, 10, null, null, 8, null, 4
        ));
        TreeTraversal treeTraversal = new TreeTraversal();
        TreeNode binaryTree = treeTraversal.createBinaryTree(inputList);
        treeTraversal.preOrderTraversal04(binaryTree);
        System.out.println();
        treeTraversal.inOrderTraversal04(binaryTree);
        System.out.println();
        treeTraversal.postOrderTraversal04(binaryTree);
        System.out.println();
        treeTraversal.preOrderTraversalByStack04(binaryTree);
        System.out.println();
        treeTraversal.inOrderTraversalByStack04(binaryTree);
        System.out.println();
        treeTraversal.postOrderTraversalByStack04(binaryTree);
    }
}
