/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here

        RandomListNode dummy = new RandomListNode(0);

        RandomListNode origin = head;
        RandomListNode prev = dummy;
 
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

        while (origin != null) {
            RandomListNode node = new RandomListNode(origin.val);
            map.put(origin, node);
            prev.next = node;
            prev = prev.next;
            origin = origin.next;
        }

        origin = head;
        while (origin != null) {
            map.get(origin).random = map.get(origin.random);
        }

        return dummy.next;

    }
}