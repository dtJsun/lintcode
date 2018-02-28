//用一个32位的数的每一位表示某一位出现几次，出现3次就给它归零

class Solution {
    public int singleNumber(int[] nums) {
        
        int[] bits = new int[32];
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < nums.length; j++) {
                bits[i] += ((nums[j] >> i) & 1);
                bits[i] %= 3;
            }
            ans |= bits[i] << i;
        }
        return ans;
    }
}
