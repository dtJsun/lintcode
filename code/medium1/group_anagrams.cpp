#include <vector>
#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> strMap;

        for (int i = 0; i < strs.size(); i++) {
            string temp = strs[i];
            sort(temp.begin(), temp.end());
            if (strMap.find(temp) == strMap.end()) {
                strMap[temp] = vector<string>(1, strs[i]);
            } else {
                strMap[temp].push_back(strs[i]);
            }
        }

        vector<vector<string>> ans;
        
        unordered_map<string, vector<string>>::iterator itr = strMap.begin();
        while (itr != strMap.end()) {
            ans.push_back(itr->second);
            itr++;
        }
        
        return ans;
    }
};