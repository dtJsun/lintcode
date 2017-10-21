public class Solution {
    /*
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        ans.add(new ArrayList<>());
        
        Arrays.sort(nums);

        helper(nums, ans, curr, 0);

        return ans;
    }

    private void helper(
        int[] nums,
        List<List<Integer>> ans,
        List<Integer> curr,
        int start
    ) {

        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            ans.add(new ArrayList<Integer>(curr));
            helper(nums, ans, curr, i + 1);
            curr.remove(curr.size() - 1);

            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }

    }
}