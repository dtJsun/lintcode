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
        
        Stack<Integer> stk1 = new Stack();
        Stack<Integer> stk2 = new Stack();

        while (l1 != null) {
            stk1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stk2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        Stack<Integer> stk = new Stack();

        while (!stk1.isEmpty() && !stk2.isEmpty()) {
            int sum = stk1.pop() + stk2.pop() + carry;
            int curr = sum % 10;
            carry = sum / 10;
            stk.push(curr);
        }

        while (!stk1.isEmpty()) {
            int sum = stk1.pop() + carry;
            int curr = sum % 10;
            carry = sum / 10;
            stk.push(sum);
        }

        while (!stk2.isEmpty()) {
            int sum = stk2.pop() + carry;
            int curr = sum % 10;
            carry = sum / 10;
            stk.push(sum);
        }

        if (carry != 0) {
            stk.push(carry);
        }

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (!stk.isEmpty()) {
            ListNode node = new ListNode(stk.pop());
            head.next = node;
            head = head.next;
        }
        return dummy.next;

    }
}