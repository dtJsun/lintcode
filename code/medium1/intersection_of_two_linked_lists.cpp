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
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        
        if (!headA || !headB) return NULL;

        ListNode* currA = headA;
        ListNode* currB = headB;

        int lenA = 1, lenB = 1;

        while (currA->next != NULL) {
            currA = currA->next;
            lenA++;
        }
        while (currB->next != NULL) {
            currB = currB->next;
            lenB++;
        }

        if (currA != currB) return NULL;

        currA = headA;
        currB = headB;

        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                currA = currA->next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                currB = currB->next;
            }
        }

        while (currA != currB) {
            currA = currA->next;
            currB = currB->next;
        }

        return currA;
    }
};