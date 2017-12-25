/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    class NodeComparator implements Comparator<ListNode> {
        public int compare(ListNode node1, ListNode node2) {
            return node1.val - node2.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> que = new PriorityQueue<>(lists.length, new NodeComparator());

        for (int i = 0; i < lists.length; i++) {
            que.offer(lists[i]);
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!que.isEmpty()) {
            ListNode curr = que.poll();
            tail.next = curr;
            tail = tail.next;
            curr = curr.next;
            if (curr != null) {
                que.offer(curr);
            }
        }

        return dummy.next;
    }

}