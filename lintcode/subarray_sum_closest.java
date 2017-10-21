class Pair {
    int sum;
    int index;
    public Pair(int s, int i) {
        this.sum = s;
        this.index = i;
    }
}

public class Solution {
    /*
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int len = nums.length;

        if (len == 0) return new int[]{};

        if (len == 1) return new int[]{0, 0};

        int[] ans = new int[2];
        
        Pair[] sums = new Pair[len + 1];
        sums[0] = new Pair(0, -1);

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            sums[i + 1] = new Pair(sum, i);
        }

        Arrays.sort(sums, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.sum - b.sum;
            }
        });
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i <= len; i++) {
            if (sums[i].sum - sums[i - 1].sum < minDiff) {
                minDiff = sums[i].sum - sums[i - 1].sum;
                int[] temp = new int[]{sums[i - 1].index, sums[i].index};
                Arrays.sort(temp);
                ans[0] = temp[0] + 1;
                ans[1] = temp[1];
            }
        }
        return ans;
    }
}