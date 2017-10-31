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
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        
        if (lists.size() == 0) return null;

        return helper(lists, 0, lists.size() - 1);

    }

    private ListNode helper(List<ListNode> lists, int start, int end) {

        if (start == end) return lists.get(start);

        int mid = start + (end - start) / 2;

        ListNode left = helper(lists, start, mid);
        ListNode right = helper(lists, mid + 1, end);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }

        if (left == null) {
            curr.next = right;
        } else {
            curr.next = left;
        }

        return dummy.next;
    }



}
