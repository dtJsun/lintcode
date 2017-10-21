/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class Solution {
    /*
     * @param head: a ListNode
     * @param k: An integer
     * @return: a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (true) {
            head = reverse(head, k);
            if (head == null) return dummy.next;
        }
        return null;
    }

    public ListNode reverse(ListNode head, int k) {

        if (head == null) return null;
        ListNode nk = head;
        for (int i = 0; i < k; i++) {
            nk = nk.next;
            if (nk == null) {
                return null;
            }
        }

        ListNode n1 = head.next;
        ListNode post = nk.next;
        ListNode curr = n1;
        ListNode prev = null;
        while (curr != post) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        head.next = nk;
        n1.next = post;
        return n1;

    }
}
