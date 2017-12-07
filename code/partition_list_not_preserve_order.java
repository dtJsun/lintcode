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

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        ListNode anchor = head;
        while (curr != null) {
            if (curr.val < x) {
                ListNode tempCurr = curr;
                ListNode tempAnchor = anchor;
                curr = curr.next;
                anchor = anchor.next;
                swap(dummy, anchor, curr);
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    private void swap(ListNode dummy, ListNode left, ListNode right) {
        
        if (left == right) return;

        ListNode prevLeft = dummy;
        while (prevLeft.next != left) {
            prevLeft = prevLeft.next;
        }

        ListNode prevRight = dummy;
        while (prevRight.next != right) {
            prevRight = prevRight.next;
        }

        prevLeft.next = right;
        prevRight.next = left;

        ListNode temp = left.next;
        left.next = right.next;
        right.next = temp;

    }


}

