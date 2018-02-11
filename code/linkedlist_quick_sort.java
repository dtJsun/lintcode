/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode sortList(ListNode head) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = head;
        while (tail.next.next != null) {
            tail = tail.next;
        }
        

        
        
    }

    private void quickSort(ListNode head, ListNode tail) {

        ListNode pivot = partition(head, tail);

    }

    private ListNode partition(ListNode head, ListNode tail) {

        ListNode curr = head;
        
        while (curr != tail) {

        }

    }
    
    
    private void swap() {
        
    }
    
}