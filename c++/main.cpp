#include <iostream>
#include "repeatnum/RepeatNumber.h"
#include "findinarray/FindNumInEWArray.h"
#include "replacespace/ReplaceSpace.h"
#include "clockprintarray/ClockPrintArray.h"
#include "findfirstcharinstring/FindFirstCharInString.h"
#include "stacktoqueue/StackToQueue.h"
#include "minstack/MinStack.h"
#include "poppushorder/PopPushOrder.h"
#include "findnumberswithsum/FindNumbersWithSum.h"
#include "findsequencewithsum/FindSequenceWithSum.h"

using namespace std;

void findRepeatNumber() {
    int nums[] = {2, 3, 1, 0, 2, 5};
    int repeatNum = 0;
    RepeatNumber repeatNumber;
    bool isExit = repeatNumber.repeat(nums, sizeof(nums) / sizeof(int), repeatNum);
    if (isExit) {
        cout << "find repeat num:" << repeatNum << std::endl;
    } else {
        cout << "can not find repeat num" << std::endl;
    }
}

void findNumInEWArray() {
    int matrix[5][5] = {
            {1,  4,  7,  11, 15},
            {2,  5,  8,  12, 19},
            {3,  6,  9,  16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
    };
    int len = sizeof(matrix) / sizeof(int);
    int columns = sizeof(matrix[0]) / sizeof(int);
    int rows = len / columns;
    FindNumInEWArray findNumInEwArray;
    bool isExit = findNumInEwArray.findNumInEWArray(21, matrix, rows, columns);
    cout << "find 21 in Array is:" << isExit << endl;
}

void replaceSpace() {
    ReplaceSpace replaceSpace;
    string str = "A B ";
    string result = replaceSpace.replaceSpace(str);
    cout << "result:" << result << endl;
    char c_str[100] = "A B ";
    replaceSpace.replaceSpace(c_str);
    cout << "c_result:" << c_str << endl;
}

void clockPrintArray() {
    int matrix[][4] = {
            {1,  2,  3,  4},
            {5,  6,  7,  8},
            {9,  10, 11, 12},
            {13, 14, 15, 16}
    };
    ClockPrintArray obj;
    vector<int> result = obj.clockPrintArray(matrix, 4, 4);
    cout << "[";
    for (int i = 0; i < result.size(); ++i) {
        cout << result[i];
        if (i != result.size() - 1) {
            cout << ",";
        }
    }
    cout << "]" << endl;
}

void findFirstCharInString() {
    FindFirstCharInString findFirstCharInString;
    int index = findFirstCharInString.findFirstChar("abbvvacc");
    if (index != -1) {
        cout << "查找到index:" << index << endl;
    } else {
        cout << "未找到" << endl;
    }
}

void stackToQueue() {
    StackToQueue stackToQueue;
    stackToQueue.push(1);
    stackToQueue.push(2);
    stackToQueue.push(3);
    stackToQueue.push(4);
    while (stackToQueue.size() != 0) {
        cout << "元素：" << stackToQueue.pop() << endl;
    }
}

void minStack() {
    MinStack minStack;
    minStack.push(3);
    minStack.push(4);
    minStack.push(2);
    minStack.push(1);
    minStack.printString();
    cout << "min value:" << minStack.stack_min() << endl;
    minStack.pop();
    minStack.pop();
    minStack.push(0);
    cout << "min value:" << minStack.stack_min() << endl;
    minStack.printString();
}

void poppushOrder() {
    int pushSequence[5] = {1, 2, 3, 4, 5};
    int popSequence[5] = {4, 3, 5, 1, 2};
    PopPushOrder popPushOrder(1212);
    bool ok = popPushOrder.isPopOrder(pushSequence, 5, popSequence);
    cout << ok << endl;
}

void findNumbersWithSum() {
    int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    FindNumbersWithSum findNumbersWithSum;
    int leftNum = 0;
    int rightNum = 0;
    int result = findNumbersWithSum.findNumbersWithSum(nums, 9, 11, leftNum, rightNum);
    if (result == 0) {
        cout << "找到了:[" << leftNum << "," << rightNum << "]" << endl;
    } else {
        cout << "没找到" << endl;
    }
}

void findSequenceWithSum() {
    FindSequenceWithSum findSequenceWithSum;
    vector<vector<int>> result = findSequenceWithSum.findSequenceWithSum(100);
    cout << "[";
    for (int i = 0; i < result.size(); ++i) {
        vector<int> tempResult = result[i];
        cout << "[";
        for (int j = 0; j < tempResult.size(); ++j) {
            cout << tempResult[j] << ",";
        }
        cout << "]";
    }
    cout << "]" << endl;
}

int main() {
    cout << "Hello, World!" << std::endl;
    // 数字重复
    findRepeatNumber();
    findNumInEWArray();
    replaceSpace();
    clockPrintArray();
    findFirstCharInString();
    stackToQueue();
    minStack();
    poppushOrder();
    findNumbersWithSum();
    findSequenceWithSum();
    return 0;
}
