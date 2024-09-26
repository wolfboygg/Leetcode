//
// Created by 郭磊 on 2021/3/8.
//

#include "FindFirstCharInString.h"

int FindFirstCharInString::findFirstChar(char *str) {
    int ctns[128] = {0};
    int i = 0;
    while (*(str + i) != '\0') {
        ctns[*(str + i)]++;
        i++;
    }

    i = 0;
    while (*(str + i) != '\0') {
        if (ctns[*(str + i)] == 1) {
            return i;
        }
        i++;
    }
    return -1;
}
