// 仔细思考，很基础的bfs问题
#include <iostream>
#include <vector>
#include <utility>
#include <unordered_map>
#include <unordered_set>
#include <queue>
using namespace std;

class Solution {
public:
    bool canFinish(int numCourses, vector<pair<int, int>>& prerequisites) {
        
        unordered_map<int, unordered_multiset<int>> postCourses;
        vector<int> preCourses(numCourses, 0);

        for (int i = 0; i < prerequisites.size(); i++) {
            if (postCourses.find(prerequisites[i].second) == postCourses.end()) {
                postCourses[prerequisites[i].second] = unordered_multiset<int>();
            }
            postCourses[prerequisites[i].second].insert(prerequisites[i].first);
            preCourses[prerequisites[i].first]++;
        }

        queue<int> que;
        for (int i = 0; i < numCourses; i++) {
            if (preCourses[i] == 0) {
                que.push(i);
            }
        }

        int totalNum = 0;
        while (!que.empty()) {
            int curr = que.front();
            que.pop();
            totalNum++;
            unordered_multiset<int>::iterator itr = postCourses[curr].begin();
            while (itr != postCourses[curr].end()) {
                preCourses[*itr]--;
                if (preCourses[*itr] == 0) {
                    que.push(*itr);
                }
                itr++;
            }
        }

        return totalNum == numCourses;



    }

};