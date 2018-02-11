// dfs循环中是i + 1
// dfs循环中是i + 1
// dfs循环中是i + 1
// 重要的事情说三遍
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();

        dfs(ans, curr, nums, 0);

        return ans;
    }

    private void dfs(
        List<List<Integer>> ans,
        ArrayList<Integer> curr,
        int[] nums,
        int start
    ) {
        ans.add(new ArrayList<Integer>(curr));
        if (start == nums.length) return;

        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            dfs(ans, curr, nums, i + 1);
            curr.remove(curr.size() - 1);
        }

    }

}