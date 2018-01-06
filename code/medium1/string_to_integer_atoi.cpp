#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    int myAtoi(string str) {
        
        if (str.length() == 0) return 0;

        str.erase(0, str.find_first_not_of(' '));
        str.erase(str.find_last_not_of(' ') + 1);

        int i = 0;
        int len = str.length();
        long ans = 0;
        int sign = 1;

        if (str[i] == '-') {
            sign = -1;
            i++;
        } else if (str[i] == '+') {
            i++;
        }

        for (; i < len; i++) {
            if (str[i] < '0' || str[i] > '9') {
                break;
            }
            ans = ans * 10 + (str[i] - '0');
            if (ans > INT_MAX) {
                break;
            }
        }

        if (ans > INT_MAX) {
            return sign == 1 ? INT_MAX : INT_MIN;
        } else {
            ans *= sign;
            return (int)ans;
        }

    }
};