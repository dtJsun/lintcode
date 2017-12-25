class Solution {
    public int maxArea(int[] height) {
        
        int start = 0, end = height.length - 1;

        int ans = Integer.MIN_VALUE;

        while (start < end) {
            int vol = (end - start) * Math.min(height[start], height[end]);
            ans = Math.max(vol, ans);
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return ans;

    }
}

/**
 * 这个题不会做是因为 智商低
 */