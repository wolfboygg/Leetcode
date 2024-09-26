//
// Created by 郭磊 on 2021/3/10.
//

#include "MinStack.h"

MinStack::MinStack() {
    dataStack = new stack<int>();
    minStack = new stack<int>();
}


MinStack::~MinStack() {
    if (dataStack != NULL) {
        delete dataStack;
        dataStack = NULL;
    }

    if (minStack != NULL) {
        delete minStack;
        minStack = NULL;
    }
}

void MinStack::push(int value) {
    dataStack->push(value);
    minStack->push(minStack->empty() ? value : min(minStack->top(), value));
}

void MinStack::pop() {
    dataStack->pop();
    minStack->pop();
}

int MinStack::top() {
    return dataStack->top();
}

int MinStack::stack_min() {
    return minStack->top();
}

void MinStack::printString() {
    cout << "data stack:" << dataStack->top() << endl;
}

