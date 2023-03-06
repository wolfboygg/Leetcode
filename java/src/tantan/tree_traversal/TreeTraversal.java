package tantan.tree_traversal;

import tantan.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(
                3, 2, 9, null, null, 10, null, null, 8, null, 4
        ));
        TreeTraversal treeTraversal = new TreeTraversal();
        TreeNode binaryTree = treeTraversal.createBinaryTree(inputList);
        treeTraversal.preOrderTraversal(binaryTree);
        System.out.println();
        treeTraversal.inOrderTraversal(binaryTree);
        System.out.println();
        treeTraversal.postOrderTraversal(binaryTree);
        System.out.println();
        treeTraversal.preOrderTraversalByStack(binaryTree);
        System.out.println();
        treeTraversal.inOrderTraversalByStack(binaryTree);
        System.out.println();
        treeTraversal.postOrderTraversalByStack(binaryTree);
    }
}
