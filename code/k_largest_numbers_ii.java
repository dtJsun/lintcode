public class Solution {

    private PriorityQueue<Integer> que;

    class CompareLarge implements Comparator<Integer> {
        int compare(Integer a, Integer b) {
            return b - a;
        }
    } 


    /*
    * @param k: An integer
    */public Solution(int k) {
        // do intialization if necessary
        que = new PriorityQueue<>(new CompareLarge());

    }

    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) {
        // write your code here
    }

    /*
     * @return: Top k element
     */
    public List<Integer> topk() {
        // write your code here
    }
}