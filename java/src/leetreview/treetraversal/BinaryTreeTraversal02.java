package leetreview.treetraversal;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 复习一遍
 */
public class BinaryTreeTraversal02 {

    /**
     * 跟左右
     *
     * @param node
     */
    public void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }

    /**
     * 左根右
     *
     * @param node
     */
    public void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.leftChild);
        System.out.print(node.value + " ");
        inOrderTraversal(node.rightChild);
    }

    /**
     * 左右根
     *
     * @param node
     */
    public void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        System.out.print(node.value + " ");
    }


    /**
     * 前序遍历 通过栈进行回溯然后进行完成遍历
     * 根左右
     *
     * @param node
     */
    public void preOrderTraversalByStack(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> helperStack = new Stack<TreeNode>();
        TreeNode tempNode = node;
        while (tempNode != null || !helperStack.isEmpty()) {
            while (tempNode != null) {
                System.out.print(tempNode.value + " ");
                helperStack.push(tempNode);
                tempNode = tempNode.leftChild;
            }
            if (!helperStack.isEmpty()) {
                TreeNode pop = helperStack.pop();
                tempNode = pop.rightChild;
            }
        }

    }


    /**
     * 中序遍历
     * 左根右
     *
     * @param node
     */
    public void inOrderTraversalByStack(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> helperStack = new Stack<>();
        TreeNode tempNode = node;
        while (tempNode != null || !helperStack.isEmpty()) {
            while (tempNode != null) {
                helperStack.push(tempNode);
                tempNode = tempNode.leftChild;
            }
            if (!helperStack.isEmpty()) {
                TreeNode pop = helperStack.pop();
                System.out.print(pop.value + " ");
                tempNode = pop.rightChild;
            }
        }
    }

    /**
     * 后序遍历
     * 后序遍历比较复杂，需要判断是否能打印根节点，主要方式就是通过记录右节点是否已经遍历完成
     * 如果当前已经打印了右节点，那么就可以打印根节点了
     * 一定要记住如果是根节点还需要再次入栈才能完成打印
     *
     * @param node
     */
    public void postOrderTraversalByStack(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> helperStack = new Stack<>();
        TreeNode tempNode = node;
        TreeNode preNode = null;
        while(tempNode != null || !helperStack.isEmpty()) {
            while(tempNode != null) {
                helperStack.push(tempNode);
                tempNode = tempNode.leftChild;
            }
            TreeNode pop = helperStack.pop();
            if (pop.rightChild == null || pop.rightChild == preNode) {// 当前节点的右孩子== null 或者右孩子已经打印过了
                System.out.print(pop.value + " ");
                preNode = pop;
                tempNode = null;
            } else {
                helperStack.push(pop); // 当前节点还需要再次入栈，在打印完成右节点才能再次出栈
                tempNode = pop.rightChild;
            }
        }
    }


    /**
     * 构建二叉树
     *
     * @param input
     * @return
     */
    public TreeNode buildBinary(LinkedList<Integer> input) {
        if (input == null || input.size() == 0) {
            return null;
        }
        Integer value = input.removeFirst();
        if (value == null) {
            return null;
        }
        TreeNode headNode = new TreeNode(value);
        headNode.leftChild = buildBinary(input);
        headNode.rightChild = buildBinary(input);
        return headNode;
    }

    public static void main(String[] args) {
        LinkedList<Integer> input = new LinkedList<>(Arrays.asList(
                3, 2, 9, null, null, 10, null, null, 8, null, 4
        ));
        BinaryTreeTraversal02 traversal = new BinaryTreeTraversal02();
        TreeNode headNode = traversal.buildBinary(input);
        traversal.preOrderTraversal(headNode);
        System.out.println();
        traversal.inOrderTraversal(headNode);
        System.out.println();
        traversal.postOrderTraversal(headNode);
        System.out.println();
        traversal.preOrderTraversalByStack(headNode);
        System.out.println();
        traversal.inOrderTraversalByStack(headNode);
        System.out.println();
        traversal.postOrderTraversalByStack(headNode);

    }
}
