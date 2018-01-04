//自己写出来的 ：）
#include <iostream>
#include <vector>
#include <stdio>
using namespace std;

class Solution {
public:
    int trap(vector<int>& height) {

        vector<int> maxLeft(height.size(), 0);
        vector<int> maxRight(height.size(), 0);

        int maxVal = INT_MIN;
        for (int i = 0; i < maxLeft.size(); i++) {
            maxVal = max(maxVal, height[i]);
            maxLeft[i] = maxVal;
        }
        maxVal = INT_MIN;
        for (int i = maxRight.size() - 1; i >= 0; i--) {
            maxVal = max(maxVal, height[i]);
            maxRight[i] = maxVal;
        }

        int ans = 0;
        for (int i = 0; i < height.size(); i++) {
            if (maxLeft[i] <= height[i] || maxRight[i] <= height[i]) {
                continue;
            }
            ans += (min(maxLeft[i], maxRight[i]) - height[i]);
        }
        return ans;

    }
};