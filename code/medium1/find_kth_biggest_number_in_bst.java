class Solution {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int v) {
            val = v;
            left = null;
            right = null;
        }
    }

    // private int counter = 0;
    private int ans;

    public int findKthBiggest(TreeNode root, int k) {
        helper(root, k, 0);
        return ans;
    }

    private void helper(TreeNode root, int k, int counter) {

        if (root == null) {
            return;
        }

        helper(root.right, k, counter);
        counter++;
        if (counter == k) {
            ans = root.val;
        }
        helper(root.left, k, counter);
    }

}