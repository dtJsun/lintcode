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
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if (hashTable.length == 0) return hashTable;

        int capacity = hashTable.length * 2;
        // System.out.println(capacity);
        ListNode[] newTable = new ListNode[capacity];
        

        for (int i = 0; i < hashTable.length; i++) {

            while (hashTable[i] != null) {
                int value = hashTable[i].val;
                int index = (value % capacity + capacity) % capacity;
                // System.out.println(index);
                if (newTable[index] != null) {
                    ListNode dummy = newTable[index];
                    while (dummy.next != null) {
                        dummy = dummy.next;
                    }
                    dummy.next = new ListNode(hashTable[i].val);
                } else {
                    newTable[index] = new ListNode(hashTable[i].val);
                }
                hashTable[i] = hashTable[i].next;
            }

        }
        return newTable;

    }



};
