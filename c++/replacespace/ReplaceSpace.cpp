//
// Created by 郭磊 on 2021/3/3.
//

#include "ReplaceSpace.h"


string ReplaceSpace::replaceSpace(string &str) {
    int p1 = str.length() - 1;
    for (int i = 0; i <= p1; i++) {
        if (str[i] == ' ') {
            str.append("  ");
        }
    }
    int p2 = str.length() - 1;
    while (p1 >= 0 && p2 >= p1) {
        char c = str[p1--];
        if (c == ' ') {
            str[p2--] = '0';
            str[p2--] = '2';
            str[p2--] = '%';
        } else {
            str[p2--] = c;
        }
    }
    return str;
}

void ReplaceSpace::replaceSpace(char *str) {
    // 先进行计算
    int length = 0;
    int count = 0;
    int index = 0;
    while (*(str + index) != '\0') {
        length++;
        if (*(str + index) == ' ') {
            count++;
        }
        index++;
    }
    int p1 = length - 1;
    int p2 = p1 + count * 2;

    while (p1 >= 0 && p2 >= p1) {
        char c = *(str + p1--);
        if (c == ' ') {
            str[p2--] = '0';
            str[p2--] = '2';
            str[p2--] = '%';
        } else {
            str[p2--] = c;
        }
    }
}

