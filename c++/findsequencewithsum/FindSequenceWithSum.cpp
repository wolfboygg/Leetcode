//
// Created by 郭磊 on 2021/3/23.
//

#include "FindSequenceWithSum.h"

vector<vector<int>> FindSequenceWithSum::findSequenceWithSum(int sum) {
    vector<vector<int>> result;
    int start = 1;
    int end = 2;
    int curSum = 3;
    while (end < sum) {
        if (curSum < sum) {
            end++;
            curSum += end;
        } else if (curSum > sum) {
            curSum -= start;
            start++;
        } else {
            vector<int> tempResult;
            for (int i = start; i <= end; ++i) {
                tempResult.push_back(i);
            }
            result.push_back(tempResult);
            curSum -= start;
            start++;
            end++;
            curSum += end;
        }
    }
    return result;
}
