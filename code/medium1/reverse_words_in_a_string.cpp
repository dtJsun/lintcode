// 首先 实现trim，去掉首尾的space，以及两个word中间的spaces们
// reverseSingleWord的时候，考虑这个word是在中间，还是在末尾
// 坑不多，就上面说的两个，但是trim很蛋疼
#include <string>
using namespace std;

class Solution {
public:
    void swap(string& s, int a, int b) {
        char temp = s[a];
        s[a] = s[b];
        s[b] = temp;
    }

    void reverseSingleWord(string& s, int start, int end) {
        while (start < end) {
            swap(s, start, end);
            start++;
            end--;
        }
    }
    
    void trim(string& s) {
        int i = 0;
        for (; i < s.length(); i++) {
            if (s[i] != ' ') {
                break;
            }
        }
        s.erase(0, i);
        i = s.length() - 1;
        for (; i >= 0; i--) {
            if (s[i] != ' ') {
                s.erase(i + 1);
                break;
            }
        }
        i = 0;
        int j = 0;
        string newS = "";
        for (; i < s.length(); i++) {
            if (s[i] == ' ') {
                newS += s.substr(j, i - j);
                newS += ' ';
                while (s[i] == ' ') {
                    i++;
                }
                j = i;
            }
        }
        newS += s.substr(j, i - j);
        s = newS;
    }

    void reverseWords(string &s) {
        
        trim(s);
        
        int start = 0, end = s.length() - 1;

        while (start < end) {
            swap(s, start, end);
            start++;
            end--;
        }

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s[i] == ' ') {
                reverseSingleWord(s, j, i - 1);
                j = i + 1;
            } else if (i == s.length() - 1) {
                reverseSingleWord(s, j, i);
            }
        }

    }

};