#include<iostream>
using namespace std;
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
struct ListNode{
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* reverseList(ListNode* head) {

        // ListNode* dummy = new ListNode(0);
        // dummy->next = head;
        ListNode* prev = NULL;
        while (head != NULL) {
            ListNode* post = head->next;
            head->next = prev;
            prev = head;
            head = post;
        }
        return prev;
    }
};