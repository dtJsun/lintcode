public class Stack {

    Queue<Integer> queue1 = new Queue<>();
    Queue<Integer> queue2 = new Queue<>();

    private void moveQ() {
        while (queue1.size() != 1) {
            queue2.offer(queue1.poll);
        }
    }

    private void swapQ() {
        Queue<Integer> temp = queue2;
        queue2 = queue1;
        queue1 = temp;
    }

    /*
     * @param x: An integer
     * @return: nothing
     */
    public void push(int x) {
        // write your code here
        queue1.offer(x);
    }

    /*
     * @return: nothing
     */
    public void pop() {
        // write your code here
        moveQ();
        queue1.poll();
        swapQ();
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        moveQ();
        int curr = queue1.poll();
        swapQ();
        queue1.offer(curr);
        return curr;
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        // write your code here
        return queue1.isEmpty();
    }
}