class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        if (nums.length == 0 || k <= 0) return nums;
        
        int[] ans = new int[nums.length - k + 1];

        Deque<Integer> que = new LinkedList<>();

        for (int i = 0; i < k - 1; i++) {
            inQue(que, nums[i]);
        }

        for (int i = k - 1; i < nums.length; i++) {
            inQue(que, nums[i]);
            ans[i - k + 1] = que.peekFirst();
            outQue(que, nums[i - k + 1]);
        }
        return ans;
    }

    private void inQue(Deque<Integer> que, int num) {
        while (!que.isEmpty() && que.peekLast() < num) {
            que.pollLast();
        }
        que.offerLast(num);
    }
    
    private void outQue(Deque<Integer> que, int num) {
        if (que.peekFirst() == num) {
            que.pollFirst();
        }
    }
}