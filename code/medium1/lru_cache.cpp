/*
1. hash 中hash[key] 指向的是 Node 的prev，因为这样才能做各种操作
2. movetotail中别忘了更新curr 和 curr->next 的hash！！！！！（蠢啊）
*/
#include<map>
#include<unordered_map>
#include<iostream>
#include<queue>
using namespace std;

class Node {
    public:
        int key;
        int value;
        Node* next;

        Node() : key(0), value(0), next(NULL) {}
        Node(int k, int v) : key(k), value(v), next(NULL) {}
};

class LRUCache {

private:

    unordered_map<int, Node*> hash;
    Node* head;
    Node* tail;
    int capacity;
    int size;

public:
    LRUCache(int capacity) {
        this->hash.clear();
        this->head = new Node();
        this->tail = head;
        this->capacity = capacity;
        this->size = 0;
    }

    void moveToTail(Node* prev) {

        if (prev->next == tail) return;

        Node* curr = prev->next;
        prev->next = curr->next;
        hash[curr->next->key] = prev;
        curr->next = NULL;
        tail->next = curr;
        hash[curr->key] = tail;
        tail = curr;
    }
    
    int get(int key) {
        if (hash.find(key) == hash.end()) return -1;
        // cout << hash[key]->value << endl;
        moveToTail(hash[key]);
        // cout << hash[key]->next->value << endl;
        // cout << hash[key]->value << endl;
        return hash[key]->next->value;
    }
    
    void put(int key, int value) {
        
        if (hash.find(key) != hash.end()) {
            hash[key]->next->value = value;
            moveToTail(hash[key]);
        } else {
            Node* curr = new Node(key, value);
            hash[key] = tail;
            tail->next = curr;
            tail = curr;
            // cout << tail->value << endl;
            size++;
            if (size > capacity) {
                // cout << head->next->key << endl;
                hash.erase(head->next->key);
                head->next = head->next->next;
                hash[head->next->key] = head;
                size--;
            }
        }
    }
};





/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

