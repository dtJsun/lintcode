class Solution {

    class TreeNode {
        int val;
        TreeNode lef;
        TreeNode right;
        public TreeNode(int v) {
            value = v;
            left = NULL;
            right = NULL;
        }
    }

    private int maxConnect = 0;

    public int solution(TreeNode root) {
        helper(root);
        return maxConnect;
    }

    private int helper(TreeNode root) {

        if (root == NULL) return 0;

        int sumLeft = helper(root.left);
        int sumRight = helper(root.right);
        int sum = 1;

        if (root.left != NULL && root.val == root.left.val) {
            sum += sumLeft;
        }
        if (root.right != NULL && root.val == root.right.val) {
            sum += sumRight;
        }

        maxConnect = Math.max(maxConnect, max);

        return sum;


    }
}