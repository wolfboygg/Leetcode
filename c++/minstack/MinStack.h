//
// Created by 郭磊 on 2021/3/10.
//

#ifndef C_LEETCODE_MINSTACK_H
#define C_LEETCODE_MINSTACK_H

#include <stack>
#include <cmath>
#include <iostream>

using namespace std;

class MinStack {
private:
    stack<int> *dataStack = NULL;
    stack<int> *minStack = NULL;

public:
    MinStack();

    ~MinStack();

public:
    void push(int value);

    void pop();

    int top();

    int stack_min();

    void printString();
};


#endif //C_LEETCODE_MINSTACK_H
