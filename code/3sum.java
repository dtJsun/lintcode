public class Solution {
    /*
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here

        List<List<Integer>> ans = new ArrayList<>();
        int len = numbers.length;
        if (len <= 0) return ans;
        Arrays.sort(numbers);
        for (int i = 0; i < len - 2; i++) {
            twoSum(numbers, ans, i, len - 1);
            while (i < len - 2 && numbers[i] == numbers[i + 1])
                i++;
        }
        return ans;
    }

    private void twoSum(int[] numbers, List<List<Integer>> ans, int start, int end) {
        int target = -numbers[start];

        int i = start + 1;
        int j = end;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                List<Integer> curr = new ArrayList<>();
                curr.add(numbers[start]);
                curr.add(numbers[i]);
                curr.add(numbers[j]);
                ans.add(curr);

                while (i < j && numbers[i] == numbers[i + 1]) i++;
                while (i < j && numbers[j] == numbers[j - 1]) j--;
                i++;
                j--;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
    }


}