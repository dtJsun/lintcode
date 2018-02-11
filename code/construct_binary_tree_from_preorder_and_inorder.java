/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

    }

    private TreeNode helper(
        int[] preorder,
        int preStart,
        int preEnd,
        int[] inorder,
        int inStart,
        int inEnd
    ) {
        if (inStart < 0) return null;

        if (inStart == inEnd) return new TreeNode(inorder[inStart]);

        TreeNode root = new TreeNode(preorder[preStart]);

        int pivot = findIndex(inorder, inStart, inEnd, preorder[preStart]);
        
        TreeNode left = helper(preorder, preStart + 1, preStart + pivot - inStart, inorder, inStart, inStart + pivot - 1);

        TreeNode right = helper(preorder, preStart + pivot - inStart + 1, preEnd, inorder, pivot + 1, inEnd );

        root.left = left;
        root.right = right;
        return root;
    }
    
    private int findIndex(int[] nums, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }


}