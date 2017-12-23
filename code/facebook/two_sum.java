class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                map.put(nums[i], list);
            }
        }

        int ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int rest = target - nums[i];
            if (rest == nums[i] && map.get(rest).size() > 1) {
                ans[0] = map.get(rest).get(0);
                ans[1] = map.get(rest).get(1);
                return ans;
            } else if (map.containsKey(rest)) {
                int pos = map.get(rest).get(0);
                ans[0] = Math.min(i, pos);
                ans[1] = Math.max(i, pos);
                return ans;
            }
        }
        return ans;

    }
}