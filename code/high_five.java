/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here

        Map<Integer, Double> ans = new HashMap<>();

        HashMap<Integer, PriorityQueue> studentRecord = new HashMap<>();

        for (int i = 0; i < results.length; i++) {
            Record curr = results[i];
            if (!studentRecord.containsKey(curr.id)) {
                PriorityQueue<Integer> que = new PriorityQueue<Integer>();
                que.offer(curr.score);
                studentRecord.put(curr.id, que);
            } else {
                if (studentRecord.get(curr.id).size() == 5) {
                    if (((Integer)studentRecord.get(curr.id).peek()).intValue() < curr.score) {
                        studentRecord.get(curr.id).poll();
                        studentRecord.get(curr.id).offer(curr.score);
                    }
                } else {
                    studentRecord.get(curr.id).offer(curr.score);
                }
            }
        }

        for (int studentID : studentRecord.keySet()) {
            if (studentRecord.get(studentID).size() == 5) {
                int sum = 0;
                while (!studentRecord.get(studentID).isEmpty()) {
                    sum += ((Integer)studentRecord.get(studentID).poll()).intValue();
                }
                ans.put(studentID, sum / 5.0);
            }
        }
        
        return ans;

    }
}