#include <string>

using namespace std;

class Solution {
    public:
        string longestPalindrome(string s) {
            
            string ans = "";
            int maxLen = 0;

            for (int i = 0; i < s.length(); i++) {

                // cout << "--------" << i << endl;
                // when the length for the palindrome is odd
                int count = 0;
                while (i - count >= 0 && (i + count) < s.length() && s[i - count] == s[i + count]) {
                    count++;
                }
                count--;
                // cout << count << endl;
                if (2 * count + 1 > maxLen) {
                    maxLen = 2 * count + 1;
                    ans = s.substr(i - count, maxLen);                                        
                }

                // when the length for the palindromeis even
                count = 0;
                while (i - count >= 0 && (i + count + 1) < s.length() && s[i - count] == s[i + count + 1]) {
                    count++;
                }
                count--;
                // cout << count << endl;
                if (2 * (count + 1) > maxLen) {
                    maxLen = 2 * (count + 1);
                    ans = s.substr(i - count, maxLen);
                }

            }

            return ans;
        }
};
/*
 * solution 1. find all substrings and get the longest palindrome => time limit exceeded
 * solution 2. gotta be an O(n) solution....but how???? manacher algorithm, but it looks too difficult
 * solution 3. choose the central position of the substring and look it up from both side, get the longest palindrome substring
 * /