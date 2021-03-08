//
// Created by 郭磊 on 2021/3/2.
//


#include "FindNumInEWArray.h"

bool FindNumInEWArray::findNumInEWArray(int target, int array[][5], int rows, int columns) {
    if (array == NULL || rows == 0 || columns == 0) {
        return false;
    }
    int r = 0;
    int c = columns - 1;
    while (r <= rows - 1 && c >= 0) {
        if (array[r][c] == target) {
            return true;
        } else if (array[r][c] > target) {
            c--;
        } else {
            r++;
        }
    }
    return false;
}
