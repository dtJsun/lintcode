#include <iostream>
#include <unordered_map>
using namespace std;
/**
 * Definition for singly-linked list with a random pointer.
 * struct RandomListNode {
 *     int label;
 *     RandomListNode *next, *random;
 *     RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
 * };
 */

struct RandomListNode {
      int label;
      RandomListNode *next, *random;
      RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
};

class Solution {
public:
    RandomListNode *copyRandomList(RandomListNode *head) {

        unordered_map<RandomListNode*, RandomListNode*> nodeMap;
        RandomListNode* anchor = head;
        while (head != NULL) {
            RandomListNode* node = new RandomListNode(head->label);
            nodeMap[head] = node;
            head = head->next;
        }
        head = anchor;
        while (head != NULL) {
            RandomListNode* curr = nodeMap[head];
            curr->random = nodeMap[head->random];
            head = head->next;
        }

        return nodeMap[anchor];
    }
};