#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int helper[nums.size() + 1] = {0};
        for (int i = 0; i < nums.size(); i++) {
            if (helper[nums[i]] > 0) return nums[i];
            helper[nums[i]]++;
        }
    }
};