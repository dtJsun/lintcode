public class Solution {

    class ListNode {
        int val;
        ListNode next;
        public ListNode(int n) {
            this.val = n;
        }
    }

    /**
     * 4 句话：
     * 1. 新建post
     * 2. 翻转current
     * 3. 后移prev
     * 4. 后移current
     */

    public reverseLinkedList(ListNode head) {

        ListNode prev = null;
        while (head != null) {
            ListNode post = head.next;
            head.next = prev;
            prev = head;
            head = post;
        }
        return prev;

    }


}