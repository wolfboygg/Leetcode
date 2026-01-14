package leetcodereview01.top100.top_108;

public class IncrementArrayToTree {

    public class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;
    }

    public void traversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        traversal(node.left);
        traversal(node.right);
    }

    public TreeNode build(int[] arr) {
        if (arr == null) {
            return null;
        }
        return rebuild(arr, 0, arr.length - 1);
    }

    // 递归进行构建
    public TreeNode rebuild(int[] arr, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        int root = arr[mid];
        TreeNode node = new TreeNode();
        node.value = root;
        node.left = rebuild(arr, left, mid - 1);
        node.right = rebuild(arr, mid + 1, right);
        return node;
    }


    public static void main(String[] args) {
        int[] arr = new int[] {-10,-3,0,5,9};
        IncrementArrayToTree incrementArrayToTree = new IncrementArrayToTree();
        TreeNode build = incrementArrayToTree.build(arr);
        incrementArrayToTree.traversal(build);
    }

}
