/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /*
     * @param node: a list node in the list
     * @param x: An integer
     * @return: the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
        // write your code here
        if (node == null) {
            ListNode newNode = new ListNode(x);
            newNode.next = newNode;
            return newNode;
        }
        ListNode maxPointer = node;
        ListNode curr = node;
        do {
            // System.out.println(curr.val);
            if (curr.val >= maxPointer.val) {
                maxPointer = curr;
            }
            if (x >= curr.val && x <= curr.next.val) {
                // System.out.println(curr.val);
                ListNode newNode = new ListNode(x);
                newNode.next = curr.next;
                curr.next = newNode;
                return newNode;
            }
            curr = curr.next;
        } while (curr != node);
        ListNode newNode = new ListNode(x);
        newNode.next = maxPointer.next;
        maxPointer.next = newNode;
        return newNode;

    }
}