#include <iostream>
#include <vector>
using namespace std;

/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */

struct Interval {
    int start;
    int end;
    Interval() : start(0), end(0) {}
    Interval(int s, int e) : start(s), end(e) {}
};

/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Solution {
public:

    // bool intervalCmp(Interval& a, Interval& b) {
    //     if (a.start == b.start) {
    //         return a.end < b.end;
    //     } else {
    //         return a.start < b.start;
    //     }
    // }

    class IntervalComparator {
    public:
        bool operator() (const Interval& a, const Interval& b) {
                if (a.start == b.start) {
                    return a.end < b.end;
                } else {
                    return a.start < b.start;
                }
            }
    };

    vector<Interval> merge(vector<Interval>& intervals) {
        
        sort(intervals.begin(), intervals.end(), IntervalComparator());

        vector<Interval> ans;
        for (int i = 1; i <= intervals.size(); i++) {
            int start = intervals[i - 1].start;
            int end = intervals[i - 1].end;
            while (i < intervals.size() && intervals[i].start <= end) {
                end = max(intervals[i].end, end);
                i++;
            }
            ans.push_back(Interval(start, end));
        }
        return ans;
    }
};