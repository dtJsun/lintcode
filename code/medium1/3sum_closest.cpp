// 不要搞中间突然break，不对
// 比如：{-55,-24,-18,-11,-7,-3,4,5,6,9,11,23,33}
// 因为vector中及有正，又有负，加出来以后sum不一定是单调变化的
#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {

        sort(nums.begin(), nums.end());
        
        int minDiff = INT_MAX;
        int ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            int tempTarget = target - nums[i];
            int start = i + 1, end = nums.size() - 1;
            int sum = 0;
            int diff = INT_MAX;
            while (start < end) {
                sum = nums[start] + nums[end];
                if (sum < tempTarget) {
                    // if (tempTarget - sum > diff) break;
                    diff = tempTarget - sum;
                    if (diff <= minDiff) {
                        ans = sum + nums[i];
                        minDiff = tempTarget - sum;
                    }
                    start++;
                } else if (sum > tempTarget) {
                    // if (sum - tempTarget > diff) break;
                    diff = sum - tempTarget;
                    if (sum - tempTarget <= minDiff) {
                        ans = sum + nums[i];
                        minDiff = sum - tempTarget;
                    }
                    end--;
                } else {
                    return target;
                }
            }
        }
        return ans;
    }
};

// the lower bound for 3sum is O(n2)