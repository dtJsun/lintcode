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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        if (root == null) return null;
        
        if (root.val <= p.val) { // 说明successor在右边
            return inorderSuccessor(root.right, p); // 从右边找
        } else { // 说明successor在左边
            TreeNode left = inorderSuccessor(root.left, p); //从左边找
            return left != null ? left : root; // 找到了不为null，就反悔left，如果没找到说明左边没有比p大的，那么也就说明successor是root
        }
        
    }
}