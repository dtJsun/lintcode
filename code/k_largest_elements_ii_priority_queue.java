public class Solution {
    
        PriorityQueue<Integer> que;
        int capacity;
    
        /*
        * @param k: An integer
        */public Solution(int k) {
            // do intialization if necessary
            que = new PriorityQueue<Integer>();
            capacity = k;
        }
    
        /*
         * @param num: Number to be added
         * @return: nothing
         */
        public void add(int num) {
            // write your code here
            que.offer(num);
            if (que.size() > capacity) {
                que.poll();
            }
        }
    
        /*
         * @return: Top k element
         */
        public List<Integer> topk() {
            // write your code here
            List<Integer> ans = new ArrayList<>();
            Iterator it = que.iterator();
            while (it.hasNext()) {
                ans.add((Integer)it.next());
            }
            Collections.sort(ans, Collections.reverseOrder());
            // Collections.sort(ans, new Comparator<Integer>() {
            //     public int compare(Integer a, Integer b) {
            //         Integer temp = b - a;
            //         return temp.intValue();
            //     }
            // });
            return ans;
        }
    }