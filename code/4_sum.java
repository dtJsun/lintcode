public class Solution {
    /*
     * @param numbers: Give an array
     * @param target: An integer
     * @return: Find all unique quadruplets in the array which gives the sum of zero
     */
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        // write your code here

        List<List<Integer>> ans = new ArrayList<>();
        if (numbers.length < 4) return ans;

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length - 3; i++) {
            if (i != 0 && numbers[i] == numbers[i - 1]) continue;

            for (int j = i + 1; j < numbers.length - 2; j++) {
                if  (j != i + 1 && numbers[j] == numbers[j - 1]) continue;
                int start = j + 1, end = numbers.length - 1;

                while (start < end) {
                    
                    int temp = numbers[i] + numbers[j] + numbers[start] + numbers[end];
                    if (temp == target) {
                        List<Integer> curr = new ArrayList<>();
                        curr.add(numbers[i]);
                        curr.add(numbers[j]);
                        curr.add(numbers[start]);
                        curr.add(numbers[end]);
                        ans.add(new ArrayList<>(curr));
                        start++;
                        end--;
                        while (start < end && numbers[start] == numbers[start - 1]) start++;
                        while (start < end && numbers[end] == numbers[end + 1]) end--;
                    } else if (temp < target) {
                        start++;
                    } else {
                        end--;
                    }
                }

            }

        }
        return ans;

    }
}