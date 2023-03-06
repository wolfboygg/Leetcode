//
// Created by 郭磊 on 2021/3/9.
//

#ifndef C_LEETCODE_STACKTOQUEUE_H
#define C_LEETCODE_STACKTOQUEUE_H

#include <vector>
#include <stack>

using namespace std;

class StackToQueue {

public:
    StackToQueue();
    ~StackToQueue();

    void push(int value);
    int pop();
    int size();

private:
    stack<int> *in = NULL;
    stack<int> *out = NULL;


};


#endif //C_LEETCODE_STACKTOQUEUE_H
