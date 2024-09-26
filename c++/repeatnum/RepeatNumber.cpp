//
// Created by 郭磊 on 2021/3/1.
//

#include "RepeatNumber.h"


bool RepeatNumber::repeat(int *num, int length, int &repeatArray) {
    for (int i = 0; i < length; i++) {
        while (i != num[i]) {
            if (num[i] == num[num[i]]) {
                repeatArray = num[i];
                return true;
            }
            swap(num, i, num[i]);
        }
    }
}


void RepeatNumber::swap(int *num, int i, int j) {
    int temp = num[i];
    num[i] = num[j];
    num[j] = temp;
}

