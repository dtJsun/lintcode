class Solution {

    public int maxDifference(int[] arr) {

        int maxDiff = Integer.MIN_VALUE;
        int minNum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - minNum > maxDiff) {
                maxDiff = arr[i] - minNum;
            }
            if (arr[i] < minNum) {
                minNum = arr[i];
            }
        }
        return maxDiff;
    }


}