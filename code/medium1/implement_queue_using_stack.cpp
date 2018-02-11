#include <iostream>
#include <stack>
using namespace std;

class MyQueue {
public:
    /** Initialize your data structure here. */
    MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    void push(int x) {
        while (!stk2.empty()) {
            stk1.push(stk2.top());
            stk2.pop();
        }
        stk1.push(x);
        while (!stk1.empty()) {
            stk2.push(stk1.top());
            stk1.pop();
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        int x = stk2.top();
        stk2.pop();
        return x;
    }
    
    /** Get the front element. */
    int peek() {
        return stk2.top();
    }
    
    /** Returns whether the queue is empty. */
    bool empty() {
        return stk2.empty();
    }

private:

    stack<int> stk1;
    stack<int> stk2;

};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * bool param_4 = obj.empty();
 */