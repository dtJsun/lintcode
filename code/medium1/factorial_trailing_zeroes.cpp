// so 核心思想是找里面有多少个5！！
// 一直除下去就好了。。。
// [palmface]
#include <iostream>
using namespace std;

class Solution {
public:
    int trailingZeroes(int n) {
        int ans = 0;
        while (n > 0) {
            ans += n / 5;
            n /= 5;
        }
        return ans;
    }
};