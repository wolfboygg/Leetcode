#include <iostream>
#include "repeatnum/RepeatNumber.h"

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

int main() {
    cout << "Hello, World!" << std::endl;
    // 数字重复
    findRepeatNumber();
    return 0;
}
