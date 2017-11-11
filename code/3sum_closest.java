public class Solution {
    /*
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        // write your code here

        Arrays.sort(numbers);
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < numbers.length; i++) {
            rest = target - numbers[i];
            int start = i + 1;
            int end = numbers.length - 1;
            while (start < end) {
                int sum = numbers[start] + numbers[end];
                int tempDiff = Math.abs(rest - sum);
                if (tempDiff < diff) {
                    diff = tempDiff;
                    ans = sum + numbers[i];
                    if (tempDiff == 0) return ans;
                }
                if (sum > rest) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return ans;

    }

}