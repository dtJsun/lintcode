public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ArrayList<Integer> curr = new ArrayList<Integer>();

        helper(candidates, target, ans, curr);

        return ans;
    }

    private void helper(
        int[] candidates,
        int target,
        List<List<Integer>> ans,
        ArrayList<Integer> curr
    ) {
        if (target == 0) {
            ans.add(new ArrayList<Integer>(curr));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            target -= candidates[i];
            curr.add(candidates[i]);
            helper(candidates, target, ans, curr);
            target += candidates[i];
            curr.remove(curr.size() - 1);
        }

    }
}