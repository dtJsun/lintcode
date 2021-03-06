public class Solution {
    
    /*
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> temp = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                temp.add(nums2[i]);
            }
        }
        int[] ans = new int[temp.size()];
        int index = 0;
        for (Integer i : temp) {
            ans[index] = i;
            index++;
        }

        return ans;

    }
};