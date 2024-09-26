package leetcodereview01.new_top_100.top_42;

/**
 * 接雨水
 */
public class GetRainWater {

    public int trap(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // 采用双指针的方式
        int left = 0;
        int right = arr.length - 1;
        int lmax = 0;
        int rmax = 0;
        int res = 0;
        while (left < right) {
            lmax = Math.max(lmax, arr[left]);
            rmax = Math.max(rmax, arr[right]);
            if (lmax < rmax) {
                res += lmax - arr[left];
                left++;
            } else {
                res += rmax - arr[right];
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        GetRainWater getRainWater = new GetRainWater();
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = getRainWater.trap(arr);
        System.out.println(result);
    }

}
