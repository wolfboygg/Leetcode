package leetcodereview01.new_top_100.top_55;

public class CanJump {


    public boolean canJump01(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        // 使用贪心算法，arr[i]表示能跳的最大长度
        int currentMax = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i <= currentMax) {
                currentMax = Math.max(currentMax, i + arr[i]);
                System.out.println(i +"," + currentMax);
                if (currentMax >= arr.length -1) {
                    return true;
                }
            }
        }
        return false;
    }

    // 计算是否能到达最后一个位置 通过记录最大的位置，看是否能超过
    public boolean canJump02(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i <= max) {
                max = Math.max(max, arr[i] + i);
                if (max >= arr.length - 1) {
                    return true;
                }
            }

        }
        return false;
    }

    // 是否能到达最后，记录最大的记录，看是否可以到达
    public boolean canJump03(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
           if (i <= max) {
               max = Math.max(arr[i] + i, max); // 超过表示能到达
               if (max >= arr.length - 1) {
                   return true;
               }
           }
        }
        return false;
    }

    // 贪心算法
    public boolean canJump04(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i <= max) {
                max = Math.max(arr[i] + i, max);
                if (max >= arr.length) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CanJump canJump = new CanJump();
//        int[] arr = new int[] {2,3,1,1,4};
        int[] arr = new int[] {3,2,1,0,4};
        boolean can = canJump.canJump04(arr);
        System.out.println(can);
    }
}
