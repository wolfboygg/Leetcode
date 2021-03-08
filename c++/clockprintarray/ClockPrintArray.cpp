//
// Created by 郭磊 on 2021/3/4.
//

#include "ClockPrintArray.h"

vector<int> ClockPrintArray::clockPrintArray(int (*matrix)[4], int row, int column) {
    vector<int> result;
    int rowTop = 0;
    int rowBottom = row - 1;
    int colLeft = 0;
    int colRight = column - 1;

    while (rowTop <= rowBottom && colLeft <= colRight) {
        // 上
        for (int i = colLeft; i <= colRight; ++i) {
            result.push_back(matrix[rowTop][i]);
        }

        // 右
        for (int i = rowTop + 1; i <= rowBottom; ++i) {
            result.push_back(matrix[i][colRight]);
        }

        // 下
        if (colLeft != colRight) {
            for (int i = colRight - 1; i >= colLeft; i--) {
                result.push_back(matrix[rowBottom][i]);
            }
        }

        // 左
        if (rowTop != rowBottom) {
            for (int i = rowBottom - 1; i > rowTop; i--) {
                result.push_back(matrix[i][colLeft]);
            }
        }

        rowTop++;
        rowBottom--;
        colLeft++;
        colRight--;
    }

    return result;
}
