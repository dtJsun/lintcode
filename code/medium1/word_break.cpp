#include <iostream>
#include <string>
#include <vector>
#include <set>
using namespace std;

class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {

        if (s.length() == 0) return true;

        set<string> dict;
        for (int i = 0; i < wordDict.size(); i++) {
            dict.insert(wordDict[i]);
        }

        return helper(s, dict);

    }

    bool helper(string& s, set<string>& dict) {

        if (s.length() == 0) return true;

        for (int i = 1; i <= s.length(); i++) {
            string temp = s.substr(0, i);
            if (dict.find(temp) != dict.end()) {
                string rest = s.substr(i);
                if (helper(rest, dict)) {
                    return true;
                }
            }
        }
        return false;
    }

};