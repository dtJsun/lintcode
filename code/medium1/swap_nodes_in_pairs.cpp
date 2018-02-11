#include <iostream>
using namespace std;

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

struct ListNode {
    int val;
    ListNode* next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        ListNode* curr = head;

        ListNode* prev = dummy;
        while (curr->next->next) {
            ListNode* temp = curr->next;
            curr->next = curr->next->next;
            curr->next->next = curr;
            prev->next = curr->next;
            prev = curr;
            curr = curr->next;
        }
        return dummy->next;
    }
};
