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
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        // write your code here

        if (head == null || head.next == null) return null;

        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (slow != null && fast != null && fast.next != null) {
            if (slow == fast) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow == null || fast == null || fast.next == null) return null;

        ListNode keyPoint = fast;
        ListNode curr = head;
        while (curr != slow) {
            curr = curr.next;
            slow = slow.next;
        }

        return curr;
    }
}