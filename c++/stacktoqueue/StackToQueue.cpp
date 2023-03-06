//
// Created by 郭磊 on 2021/3/9.
//

#include "StackToQueue.h"

StackToQueue::StackToQueue() {
    in = new stack<int>();
    out = new stack<int>();
}

StackToQueue::~StackToQueue() {
    if (in != NULL) {
        delete in;
        in = NULL;
    }
    if (out != NULL) {
        delete out;
        out = NULL;
    }
}

void StackToQueue::push(int value) {
    in->push(value);
}

int StackToQueue::pop() {
    if (out->empty()) {
        while (!in->empty()) {
            out->push(in->top());
            in->pop(); // 移除掉
        }
    }
    int value = -1;
    if (!out->empty()) {
        value = out->top();
        out->pop();
    }
    return value;
}

int StackToQueue::size() {
    return in->size() + out->size();
}
