/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here

        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        ListNode curr = dummy;
        while (curr.next != null) {
            if (curr.next.val >= x) {
                tail.next = curr.next;
                curr.next = curr.next.next;
                tail.next.next = null;
                tail = tail.next;
            } else {
                curr = curr.next;
            }
            
        }

        return dummy.next;

    }
}