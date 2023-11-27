package leetcodereview01.jiandan.leetcode42;


public class MaxSubArray {
    public void findSum03(int[] arr) {
        int pre = 0;
        int curSum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            pre = Math.max(pre + arr[i], arr[i]);
            curSum = Math.max(curSum, pre);
        }
        System.out.println(curSum);
    }

    public void findSum04(int[] arr) {
        // 求最大子数组的和
        int pre = 0;
        int maxValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            pre = Math.max(arr[i], pre + arr[i]);
            maxValue = Math.max(maxValue, pre);
        }
        System.out.println(maxValue);
    }

    static class Person {

    }

    public void findSum05(int[] arr) {
        // 最大子数组的和，就和当前的最大值 + arr[i] 和arr[i]进行比较
        // 用pre记录当前已经到了多少了，如果比+arr[i]比arr[i]小 那么就要重新赋值
        int preValue = 0;
        int maxValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
              preValue = Math.max(preValue + arr[i], arr[i]);
              maxValue = Math.max(maxValue, preValue);
        }
        System.out.println(maxValue);
    }

    public void findSum06(int[] arr) {
        int pre = 0;
        int maxValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
              pre = Math.max(arr[i], pre + arr[i]);
              maxValue = Math.max(maxValue, pre);
        }
        System.out.println(maxValue);
    }


    public int findSum07(int[] arr) {
        // 找到连续数组的最大和 通过遍历记录当前的最大值和总的最大值
        int maxValue = arr[0];
        int preValue = 0;
        for (int i = 0; i < arr.length; i++) {
            preValue = Math.max(preValue + arr[i], arr[i]);
            maxValue = Math.max(maxValue, preValue);
        }
        System.out.println(maxValue);
        return maxValue;
    }

    public void findSum08(int[] arr) {
        // 最大子数组的和，一次进行相加判断是否大于最大值和当前值进行比较
        int max = 0;
        int curSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            curSum = Math.max(arr[i], curSum + arr[i]);
            max = Math.max(max, curSum);
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        // 使用动态规划求解
        MaxSubArray maxSubArray = new MaxSubArray();
        maxSubArray.findSum(arr);
        maxSubArray.findSum08(arr);
        String str = "abc";
        String str2 = "abc";
        System.out.println(str == str2);
        System.out.println(str.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(new String("abc").hashCode());
        System.out.println(new Integer(4).hashCode());
        System.out.println(new Integer(4).hashCode());

        System.out.println(new Person().hashCode());
        System.out.println(new Person().hashCode());
        // Object的hashcode方法是通过native方法实现的，买一个对象的HashCode方法都是不一样的。
        // 对于String Integer对象而言他们个字都实现了自己的hashCode方法
        // String 通过拿到value遍历买一个字符求hash，而Integer通过对应的value求hash，所以
        // 尽管new出来的两个对象的地址是不同的，但是hash值是相同的。
        // 反观Object，由于是默认实现，native底层会对每一个创建的对象求出的Hash值是不同的。
        // 所以我们在对对象使用HashMap的时候一定要复写对象的hashCode方法同时复写equals
        // 判断规则是相同的对象的的HashCode值应该是相同的。
        // 先通过hash判断，在通过equals进行判断对象是否相同
    }

    public void findSum02(int[] arr) {
        // 使用动态规划求解
        int curSum = arr[0];
        int pre = 0;
        for (int i = 0; i< arr.length; i++) {
            pre = Math.max(arr[i], pre + arr[i]); // 如果加完之后还要比这个值小，那么重新开始统计
            curSum = Math.max(pre, curSum);
        }
        System.out.println(curSum);
    }

    private void findSum(int[] arr) {
        int pre = 0;
        int maxValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            pre = Math.max(pre + arr[i], arr[i]);
            maxValue = Math.max(maxValue, pre);
        }
        System.out.println(maxValue);
    }
}
