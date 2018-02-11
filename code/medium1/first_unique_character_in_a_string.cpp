#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;

class Solution {
public:
    int firstUniqChar(string s) {
        
        unordered_map<char, int> cMap;
        for (int i = 0; i < s.length(); i++) {
            if (cMap.find(s[i]) == cMap.end()) {
                cMap[s[i]] = 0;
            } else {
                cMap[s[i]]++;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (cMap[s[i]] == 1) return i;
        }
        return -1;
    }
};