#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());

        vector<vector<int>> ans;

        for (int i = 0; i < nums.size(); i++) {
            int target = -nums[i];
            int start = i + 1, end = nums.size() - 1;

            while (start < end) {
                int sum = nums[start] + nums[end];
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    vector<int> temp = {nums[i], nums[start], nums[end]};
                    ans.push_back(temp);
                    while (start + 1 < nums.size() && nums[start + 1] == nums[start]) start++;
                    start++;
                    while (end - 1 >= i && nums[end - 1] == nums[end]) end--;
                    end--;
                }
            }

            while (i + 1 < nums.size() && nums[i + 1] == nums[i]) i++;
        }

        return ans;
    }
};