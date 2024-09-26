//
// Created by 郭磊 on 2021/3/1.
//

#ifndef C___REPEATNUMBER_H
#define C___REPEATNUMBER_H

class RepeatNumber {
public:
    bool repeat(int *num, int length, int &repeatArray);

private:
    void swap(int *num, int i, int j);
};

#endif //C___REPEATNUMBER_H
