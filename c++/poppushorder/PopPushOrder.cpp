//
// Created by 郭磊 on 2021/3/12.
//

#include "PopPushOrder.h"

bool PopPushOrder::isPopOrder(int *pushSequence, int length, int *popSequence) {
    stack<int> stack;
    for (int pushIndex = 0, popIndex = 0; pushIndex < length; pushIndex++) {
        stack.push(*(pushSequence + pushIndex));
        while (popIndex < length && !stack.empty() && *(popSequence + popIndex) == stack.top()) {
            stack.pop();
            popIndex++;
        }
    }
    return stack.empty();
}
