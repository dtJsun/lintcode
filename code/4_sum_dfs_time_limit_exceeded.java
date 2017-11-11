public class Solution {
    /*
     * @param numbers: Give an array
     * @param target: An integer
     * @return: Find all unique quadruplets in the array which gives the sum of zero
     */
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        // write your code here
        Arrays.sort(numbers);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        if (numbers.length <= 4) return ans; 
        dfs(ans, curr, target, 0, numbers);
        return ans;
    }

    private void dfs(
        List<List<Integer>> ans,
        List<Integer> curr,
        int target,
        int start,
        int[] numbers
        ) {
            
            if (curr.size() == 4 && target == 0) {
                ans.add(new ArrayList<>(curr));
                return;
            }

            for (int i = start; i < numbers.length; i++) {

                curr.add(numbers[i]);
                dfs(ans, curr, target - numbers[i], i + 1, numbers);
                curr.remove(curr.size() - 1);
                while (i < numbers.length - 1 && numbers[i + 1] == numbers[i]) {
                    i++;
                }
            }

    }
}