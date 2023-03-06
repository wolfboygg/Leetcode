//
// Created by 郭磊 on 2021/3/17.
//

#include "FindNumbersWithSum.h"

/**
 *
 * @param nums
 * @param targer
 * @param leftNum
 * @param rightNum
 * @return -1表示没找到，0表示找到了
 */
int FindNumbersWithSum::findNumbersWithSum(int *nums, int length, int targer, int &leftNum, int &rightNum) {
    int headPointer = 0;
    int tailPointer = length - 1;
    while (headPointer < tailPointer) {
        int tempSum = *(nums + headPointer) + *(nums + tailPointer);
        if (tempSum == targer) {
            leftNum = *(nums + headPointer);
            rightNum = *(nums + tailPointer);
            return 0;
        }
        if (tempSum > targer) {
            tailPointer--;
        } else {
            headPointer++;
        }
    }
    return -1;
}
