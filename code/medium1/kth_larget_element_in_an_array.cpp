// 别忘了find中得到新的pivot以后，和k-1比较时，是相对于当前start的，所以要用 pivot - start， 而不是单独的pivot

#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        return find(nums, 0, nums.size() - 1, k);
    }

private:

    int find(vector<int>& nums, int start, int end, int k) {

        if (start > end) return -1;
        if (start == end) return nums[start];

        int pivot = partition(nums, start, end);

        if (pivot - start == k - 1) return nums[pivot];
        if (pivot - start > k - 1) return find(nums, start, pivot - 1, k);
        return find(nums, pivot + 1, end, k - (pivot - start + 1));
    }

    int partition(vector<int>& nums, int start, int end) {

        int i = start;
        for (int j = start; j < end; j++) {
            if (nums[j] >= nums[end]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        int temp = nums[i];
        nums[i] = nums[end];
        nums[end] = temp;
        return i;

    }

};