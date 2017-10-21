public class Solution {
    /*
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(num);
        helper(num, target, ans, curr, 0);

        return ans;
    }

    private void helper(
        int[] num,
        int target,
        List<List<Integer>> ans,
        List<Integer> curr,
        int start
    ) {
        if (target == 0) {
            ans.add(new ArrayList<Integer>(curr));
            return;
        }

        if (target < 0) return;

        for (int i = start; i < num.length; i++) {
            target -= num[i];
            curr.add(num[i]);
            helper(num, target, ans, curr, i + 1);
            target += num[i];
            curr.remove(curr.size() - 1);

            while (num[i + 1] == num[i])
                i++;

        }

    }
}