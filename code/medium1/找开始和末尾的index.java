class Solution {

    public List<Integer> solution(int[] nums, int target) {

        List<Integer> ans = new ArrayList<>();

        int init = helper(nums, target, 0, nums.length - 1);
        if (init == -1) {
            ans.add(-1);
            ans.add(-1);
            return ans;
        }

        int left = init, right = init;
        int tempLeft = left, tempRight = right;
        while (tempLeft != -1) {
            left = tempLeft;
            tempLeft = helper(nums, target, start, tempLeft - 1);
        }
        while (tempRight != -1) {
            right = tempRight;
            tempRight = helper(nums, target, tempRight + 1, end);
        }
        
        ans.add(left);
        ans.add(right);
        return ans;
    }

    private int helper(int[] nums, int target, int start, int end) {

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (nums[start] == target) return start;
        if (num[end] == target) return end;
        return -1;

    }

}