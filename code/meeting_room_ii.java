/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    
    class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }
    
    // 注意que里面是按照end排序的, 因为当判断一个新的interval的时候，在乎的是 它的开始时间 是不是和 在它之前最早的结束时间 有重合
    class IntervalComparatorQue implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.end - b.end;
        }
    }
    
    public int minMeetingRooms(Interval[] intervals) {
        
        if (intervals.length == 0) return 0;
        
        Arrays.sort(intervals, new IntervalComparator());
        
        PriorityQueue<Interval> que = new PriorityQueue(intervals.length, new IntervalComparatorQue());
        
        que.offer(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            Interval curr = que.poll();
            
            if (intervals[i].start >= curr.end) {
                curr.end = intervals[i].end;
            } else {
                que.offer(intervals[i]);
            }
            que.offer(curr);
        }
        
        return que.size();
        
        
        
        
    }
}