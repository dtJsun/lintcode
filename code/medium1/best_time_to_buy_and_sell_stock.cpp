// 先求出每两天之间的差值，再用maximum subarray 做
// 注意maximum subarray 中的for循环是从i = 1 开始的
#include <vector>
using namespace std;

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        
        if (prices.size() <= 1) return 0;
        
        vector<int> diffs(prices.size() - 1, 0);
        
        for (int i = diffs.size(); i > 0; i--) {
            diffs[i - 1] = prices[i] - prices[i - 1];
        }
        
        int sum = diffs[0];
        int maxSum = diffs[0];
        for (int i = 1; i < diffs.size(); i++) {
            if (sum < 0) {
                sum = diffs[i];
            } else {
                sum += diffs[i];
            }
            maxSum = max(sum, maxSum);
        }
        return max(0, maxSum);
        
    }
};