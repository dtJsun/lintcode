public class Solution {
    /*
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(numbers[i])) {
                map.put(numbers[i], new ArrayList<>());
            }
            map.get(numbers[i]).add(i);
        }

        int[] ans = new int[2];

        for (int i = 0; i < numbers.length; i++) {

            int rest = target - numbers[i];

            if (rest == numbers[i] && map.get(rest).size() >= 2) {
                ans[0] = map.get(rest).get(0) + 1;
                ans[1] = map.get(rest).get(1) + 1;
                return ans;
            }

            if (map.containsKey(rest)) {
                ans[0] = map.get(numbers[i]).get(0) + 1;
                ans[1] = map.get(rest).get(0) + 1;
                return ans;
            }

        }

        return ans;
    }
}