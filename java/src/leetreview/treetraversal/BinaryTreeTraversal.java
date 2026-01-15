package leetreview.treetraversal;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class BinaryTreeTraversal {


    public TreeNode buildBinaryTree(LinkedList<Integer> inputList) {
        if (inputList == null || inputList.size() == 0) {
            return null;
        }
        Integer data = inputList.removeFirst();
        TreeNode headerNode = null;
        if (data != null) {
            headerNode = new TreeNode(data);
            headerNode.leftChild = buildBinaryTree(inputList);
            headerNode.rightChild = buildBinaryTree(inputList);
        }
        return headerNode;
    }

    /**
     * 遍历通过递归
     */
    public void preOrderTraversal(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.value + " ");
        preOrderTraversal(treeNode.leftChild);
        preOrderTraversal(treeNode.rightChild);
    }

    /**
     * 中序遍历
     */
    public void inOrderTraversal(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrderTraversal(treeNode.leftChild);
        System.out.print(treeNode.value + " ");
        inOrderTraversal(treeNode.rightChild);
    }

    /**
     * 后序遍历
     */
    public void postOrderTraversal(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        postOrderTraversal(treeNode.leftChild);
        postOrderTraversal(treeNode.rightChild);
        System.out.print(treeNode.value + " ");
    }

    /**
     * 栈前序遍历
     */
    public void preOrderTraversalByStack(TreeNode treeNode) {
        // 主要是要使用栈的可回溯性进行遍历
        Stack<TreeNode> helperStack = new Stack<>();
        TreeNode recodeNode = null;
        recodeNode = treeNode;
        while (recodeNode != null || !helperStack.isEmpty()) {
            while (recodeNode != null) {
                System.out.print(recodeNode.value + " ");
                helperStack.push(recodeNode);
                recodeNode = recodeNode.leftChild;
            }
            if (!helperStack.isEmpty()) {
                TreeNode pop = helperStack.pop();
                recodeNode = pop.rightChild;
            }
        }
    }

    /**
     * 栈中序遍历
     */
    public void inOrderTraversalByStack(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Stack<TreeNode> helperStack = new Stack<>();
        TreeNode recoderNode = treeNode;
        while (recoderNode != null || !helperStack.isEmpty()) {
            while (recoderNode != null) {
                helperStack.push(recoderNode);
                recoderNode = recoderNode.leftChild;
            }
            if (!helperStack.isEmpty()) {
                TreeNode pop = helperStack.pop();
                System.out.print(pop.value + " ");
                recoderNode = pop.rightChild;
            }
        }
    }

    /**
     * 栈后序遍历
     */
    public void postOrderTraversalByStack(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Stack<TreeNode> helperStack = new Stack<>();
        TreeNode recodeNode = treeNode;
        TreeNode pre = null;
        while (recodeNode != null || !helperStack.isEmpty()) {
            while (recodeNode != null) {
                helperStack.push(recodeNode);
                recodeNode = recodeNode.leftChild;
            }
            recodeNode = helperStack.pop();
            if (recodeNode.rightChild == null || recodeNode.rightChild == pre) {
                System.out.print(recodeNode.value + " ");
                pre = recodeNode;
                recodeNode = null;
            } else {
                helperStack.push(recodeNode);
                recodeNode = recodeNode.rightChild;
            }
        }
    }

    public void postOrderTraversalByStack2(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Stack<TreeNode> helperStack = new Stack<>();
        TreeNode recodeNode = treeNode;
        TreeNode pre = null;
        while(recodeNode != null || !helperStack.isEmpty()) {
            while(recodeNode != null) {
                helperStack.push(recodeNode);
                recodeNode = recodeNode.leftChild;
            }
            recodeNode = helperStack.pop();
            if (recodeNode.rightChild == null || recodeNode.rightChild == pre) {
                System.out.print(recodeNode.value + " ");
                pre = recodeNode;
                recodeNode = null;
            } else {
                helperStack.push(recodeNode);
                recodeNode = recodeNode.rightChild;
            }

        }

    }

    public void preOrderTraversal01(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preOrderTraversal01(root.leftChild);
        preOrderTraversal01(root.rightChild);
    }

    public void inOrderTraversal01(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal01(root.leftChild);
        System.out.print(root .value + " ");
        inOrderTraversal01(root.rightChild);
    }

    public void postOrderTraversal01(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal01(root.leftChild);
        postOrderTraversal01(root.rightChild);
        System.out.print(root.value + " ");
    }

    public void preOrderTraversalByStack01(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                System.out.print(root.value + " ");
                stack.push(root);
                root = root.leftChild;
            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                root = node.rightChild;
            }
        }
    }

    public void inOrderTraversalByStack02(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.leftChild;
            }
            if (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                System.out.print(pop.value + " ");
                root = pop.rightChild;
            }
        }
    }

    public void postOrderTraversalByStack01(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.leftChild;
            }
            TreeNode node  = stack.pop();
            if (node.rightChild == null || pre == node.rightChild) {
                System.out.print(node.value + " ");
                pre = node;
            } else {
                stack.push(node);
                root = node.rightChild;

            }
        }
    }


    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(
                3, 2, 9, null, null, 10, null, null, 8, null, 4
        ));
        String str = new String("jajaj");
        BinaryTreeTraversal traversal = new BinaryTreeTraversal();
        TreeNode headNode = traversal.buildBinaryTree(inputList);
        traversal.preOrderTraversal01(headNode);
        System.out.println();
        traversal.inOrderTraversal01(headNode);
        System.out.println();
        traversal.postOrderTraversal01(headNode);
        System.out.println();
        traversal.preOrderTraversalByStack01(headNode);
        System.out.println();
        traversal.inOrderTraversalByStack02(headNode);
        System.out.println();
        traversal.postOrderTraversalByStack01(headNode);
        System.out.println();
        traversal.postOrderTraversalByStack2(headNode);
    }
}
