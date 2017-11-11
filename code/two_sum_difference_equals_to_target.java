public class Solution {
    /*
     * @param nums: an array of Integer
     * @param target: an integer
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum7(int[] nums, int target) {
        // write your code here

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }

        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int rest = nums[i] + target;
            if (rest == nums[i] && map.get(rest).size() >= 2) {
                ans[0] = map.get(rest).get(0) + 1;
                ans[1] = map.get(rest).get(1) + 1;
                return ans;
            }

            if (map.containsKey(rest)) {
                
                int index1 = map.get(nums[i]).get(0) + 1;
                int index2 = map.get(rest).get(0) + 1;
                
                ans[0] = index1 < index2 ? index1 : index2;
                ans[1] = index1 < index2 ? index2 : index1;
                return ans;
            }
        }
        return ans;

    }
}