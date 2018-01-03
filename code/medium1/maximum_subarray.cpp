// 先判断sum，如果sum小于0，就不要了，从nums[i]开始重新加

#include <vector>
#include <iostream>
#include <climits>
#include <math>
using namespace std;

class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        
        int maxSum = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.size(); i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            maxSum = max(sum, maxSum);
        }
        return maxSum;

    }
};