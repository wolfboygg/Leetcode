package leetcodereview01.top100.top_55;

/**
 * 跳跃游戏，判断是否可以跳到数组的结尾给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 */
public class CanJump {

    public boolean jump(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int last = arr.length - 1;
        for(int i = arr.length - 1; i >=0; i--) {
            if (arr[i] + i >= last) {
                last = i;
            }
        }
        return last == 0;
    }


    public static void main(String[] args){
        int[] arr1 = {2,3,1,1,4};
        int[] arr2 = {3,2,1,0,4};
        CanJump canJump = new CanJump();
        boolean result1 = canJump.jump(arr1);
        System.out.println(result1);
        boolean result2 = canJump.jump(arr2);
        System.out.println(result2);
    }
}
