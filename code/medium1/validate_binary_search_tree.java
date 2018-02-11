// 注意在check leftReturn 和 rightReturn 之前，别忘了看roo.left 和 root.right 是否存在
// 当root = null的时候 返回的maxVal和minVal的值无所谓，因为有上面说的check
// 之所以有前两条是因为edge case：[Integer.MIN_VALUE 或者 Integer.MAX_VALUE] 只有一个节点，里面的value是最大或者最小值

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

    class ReturnType {
        boolean isBST;
        int minVal;
        int maxVal;
        public ReturnType (boolean i, int v1, int v2) {
            isBST = i;
            minVal = v1;
            maxVal = v2;
        }
    }

    public boolean isValidBST(TreeNode root) {
        ReturnType ans = helper(root);
        return ans.isBST;
    }
    
    private ReturnType helper(TreeNode root) {
        
        if (root == null) return new ReturnType(true, 0, 0);

        ReturnType leftReturn = helper(root.left);
        ReturnType rightReturn = helper(root.right);
        

        if (root.left != null && (!leftReturn.isBST || leftReturn.maxVal >= root.val)) {
            return new ReturnType (false, 0, 0);
        }

        if (root.right != null && (!rightReturn.isBST || rightReturn.minVal <= root.val)) {
            return new ReturnType (false, 0, 0);
        }

        int minVal = root.left == null ? root.val : leftReturn.minVal;
        int maxVal = root.right == null ? root.val : rightReturn.maxVal;
        return new ReturnType(true, minVal, maxVal);
        
    }
    
}