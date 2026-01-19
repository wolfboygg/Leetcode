package leetcodereview01.new_top_100.top_287;


public class FindRepeatNumber {

    public int findRepeatNumber(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            // 需要注意的就是1 - n
            while (arr[i] != i + 1) {
                if (arr[arr[i] - 1] != arr[i]) { // 注意这个判断就行了
                    int temp = arr[i];
                    arr[i] = arr[temp - 1];
                    arr[temp - 1] = temp;
                } else {
                    return arr[i];
                }
            }
        }
        return -1;
    }

    // 找到重复的数字
    public int findRepeatNumber01(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i + 1) {
                if (arr[i] != arr[arr[i] - 1]) {
                    int temp = arr[i];
                    arr[i] = arr[temp - 1];
                    arr[temp - 1] = temp;
                } else {
                    return arr[i];
                }
            }
        }
        return -1;
    }

    public int findRepeatNumber02(int[] arr) {
        //找到重复的输
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // 1 - n 放到对应的位置
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i + 1) {
                if (arr[i] != arr[arr[i]]) {
                    int temp = arr[i];
                    arr[i] = arr[temp];
                    arr[temp] = temp;
                } else {
                    return arr[i];
                }
            }
        }
        return -1;
    }

    // 找到重复的数字
    public int findRepeatNumber03(int[] arr) {
        if (arr == null) {
            return -1;
        }
        // 将数字放到原来位置
        for (int i = 0; i < arr.length; i++) { // 交换知道位置相等
            while (arr[i] != i + 1) {
                if (arr[i] != arr[arr[i]]) {
                    int temp = arr[i];
                    arr[i] = arr[temp];
                    arr[temp] = temp;
                } else {
                    return arr[i];
                }
            }
        }
        return -1;
    }

    public int findRepeatNumber05(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            while(arr[i] != i+1) {
                if (arr[i] != arr[arr[i]]) {
                    int temp = arr[i];
                    arr[i] = arr[temp];
                    arr[temp] = temp;
                } else {
                    return arr[i];
                }
            }
        }
        return -1;
    }


    public int findRepeatNumber06(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            while(arr[i] != i) {
                if (arr[i] != arr[arr[i]]) {
                    int value = arr[i];
                    arr[i] = arr[value];
                    arr[value] = value;
                } else {
                    return arr[i];
                }
            }
        }
        return -1;
    }

    //  {1, 3, 4, 3, 2};
    //   0, 1, 2, 3, 4
    //  {3, 1, 4, 3, 2};
    public int findRepeatNumber07(int[] arr) {
        //将当前的数字放到对应的位置上
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            while(arr[i] != i) {
                if (arr[i] == arr[arr[i]]) {
                    return arr[i];
                } else {
                    int temp = arr[i];
                    arr[i] = arr[temp];
                    arr[temp] = temp;
                }
            }
        }
        return -1;
    }

    public int findRepeatNumber08(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i + 1) {
                if(arr[i] != arr[arr[i]]) {
                    int temp = arr[i];
                    arr[i] = arr[temp];
                    arr[temp]  = temp;
                } else {
                    return arr[i];
                }
            }
        }
        return -1;
    }

    public int findRepeatNumber09(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            while(arr[i] != i) {
                if (arr[i] != arr[arr[i]]) {
                    int temp = arr[i];
                    arr[i] = arr[temp];
                    arr[temp] = temp;
                } else {
                    return arr[i];
                }
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 3, 2};
        FindRepeatNumber findRepeatNumber = new FindRepeatNumber();
        int result = findRepeatNumber.findRepeatNumber09(arr);
        System.out.println(result);
    }
}
