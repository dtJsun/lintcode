/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        if (head == null) return null;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        // ListNode prev = dummy;
        for (int i = 0; i < m - 1 && head != null; i++) {
            head = head.next;
        }
        
        ListNode tail = dummy;
        for (int i = 0; i < n + 1 && tail != null; i++) {
            tail = tail.next;
        }
        
        ListNode truePrev = m == 1 ? dummy : head;
        ListNode trueTail = tail;
        
        ListNode prev = truePrev;
        ListNode curr = prev.next;
        while (curr != trueTail) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        truePrev.next.next = trueTail;
        truePrev.next = prev;
        
        return dummy.next;        
     
    }
}

/**
 * 要点
 * 新建dummy后，head需要指向dummy
 * 记录truePrev和trueTail (trueTail可能没用，再想一想)
 * 翻转过后，使用truePrev将各部分连起来
 */