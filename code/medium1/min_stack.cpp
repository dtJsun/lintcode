// pop 之后不要忘记更新minValue的值
#include <iostream>
#include <stack>
#include <climits>
using namespace std;

class MinStack {

private:
    stack<int> stk;
    stack<int> minStk;
    int minValue;

public:
    /** initialize your data structure here. */
    MinStack() {
        minValue = INT_MAX;
    }
    
    void push(int x) {
        stk.push(x);
        minValue = min(x, minValue);
        minStk.push(minValue);        
    }
    
    void pop() {
        stk.pop();
        minStk.pop();
        if (stk.empty()) {
            minValue = INT_MAX;
            return;
        }
        minValue = minStk.top();
    }
    
    int top() {
        return stk.top();
    }
    
    int getMin() {
        return minStk.top();
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */