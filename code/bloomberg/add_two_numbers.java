/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        int carry = 0;

        while (p1 != null && p2 != null) {
            int current = p1.val + p2.val + carry;
            carry = current / 10;
            current = current % 10;
            prev.next = new ListNode(current);
            prev = prev.next;
            p1 = p1.next;
            p2 = p2.next;
        }

        if (p1 != null) {
            while (p1 != null) {
                int current = p1.val + carry;
                carry = current / 10;
                current = current % 10;
                prev.next = new ListNode(current);
                prev = prev.next;
                p1 = p1.next;
            }
        } else if (p2 != null) {
            while (p2 != null) {
                int current = p2.val + carry;
                carry = current / 10;
                current = current % 10;
                prev.next = new ListNode(current);
                prev = prev.next;
                p2 = p2.next;
            }
        }
        
        if (carry != 0) {
            prev.next = new ListNode(carry);
        }

        return dummy.next;


    }
}