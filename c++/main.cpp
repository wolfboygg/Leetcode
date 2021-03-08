#include <iostream>
#include "repeatnum/RepeatNumber.h"
#include "findinarray/FindNumInEWArray.h"
#include "replacespace/ReplaceSpace.h"
#include "clockprintarray/ClockPrintArray.h"
#include "findfirstcharinstring/FindFirstCharInString.h"

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


int main() {
    cout << "Hello, World!" << std::endl;
    // 数字重复
    findRepeatNumber();
    findNumInEWArray();
    replaceSpace();
    clockPrintArray();
    findFirstCharInString();
    return 0;
}
