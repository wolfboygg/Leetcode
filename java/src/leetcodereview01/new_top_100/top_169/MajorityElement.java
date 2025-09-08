package leetcodereview01.new_top_100.top_169;

/**
 * 多数元素
 */
public class MajorityElement {

    public int majorityElement(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        // 通过
        int num = arr[0];
        int count = 0;
        for (int i : arr) {
            if (num == i) {
                count++;
            } else if (--count == 0) {
                num = i;
                count = 1;
            }
        }
        return num;
    }

    public int majorityElement01(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int num = arr[0];
        int count = 0;
        for (int item : arr) {
            if (num == item) {
                count++;
            } else if (--count == 0) {
                num = item;
                count = 1;
            }
        }
        return num;
    }

    public int majorityElement02(int[] arr) {
        // 多个数组的中的元素的最多的
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int count = 0;
        int num = arr[0];
        for (int item : arr) {
            if (num == item) {
                count++;
            } else if (--count == 0) {
                num = item;
                count = 1;
            }
        }
        return num;
    }

    //  求众数是那个
    public int majorityElement03(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int count = 0;
        int num = arr[0];
        for (int item : arr) {
            if (item == num) {
                count++;
            } else if (--count == 0) {
                count = 1;
                num = item;
            }
        }
        return num;
    }

    public int majorityElement04(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int num = arr[0];
        int count = 0;
        for (int item : arr) {
            if (item == num) {
                count++;
            } else if (--count == 0) {
                count = 1;
                num = item;
            }
        }
        return num;
    }

    public int majorityElement05(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int num = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == num) {
                count++;
            } else if (--count == 0) {
                num = arr[i];
                count = 1;
            }
        }
        return num;
    }

    public int majorityElement06(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int num = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (num == arr[i]) {
                count++;
            } else if (--count ==0) {
                num = arr[i];
                count = 1;
            }
        }
        return num;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 1, 1, 1, 2, 2,2, 1};
        MajorityElement bean = new MajorityElement();
        int i = bean.majorityElement06(arr);
        System.out.println(i);
    }

}
