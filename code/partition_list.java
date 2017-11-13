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

        ListNode ptr = head;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                swap(head, ptr, curr);
                ptr = ptr.next;
            }
            curr = curr.next;
        }


    }

    private void swap(ListNode head, ListNode first, ListNode second) {

        ListNode curr = head;
        while (curr.next != first) {
            curr = curr.next;
        }

        curr.next = second;
        curr = first;
        while (curr.next != second) {
            curr = curr.next;
        }
        curr.next = first;
        curr = second.next;
        second.next = first.next;
        first.next = curr;

    }

}