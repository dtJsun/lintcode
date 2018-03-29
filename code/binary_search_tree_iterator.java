/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    
    Stack<TreeNode> stk = new Stack();

    private void addToStack(TreeNode root) {
        while (root != null) {
            stk.push(root);
            root = root.left;
        }
    }

    public BSTIterator(TreeNode root) {
        addToStack(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stk.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        
        TreeNode curr = stk.pop();
        addToStack(curr.right);
        return curr.val;

    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */