package leetcodereview01.new_top_100.top_39;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    private List<List<Integer>> ret = new ArrayList<>();

    // 同样使用回溯的方法进行处理
    public List<List<Integer>> findAllResult(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        backTracking(arr, target, 0, new ArrayList<>());
        return ret;
    }

    public void backTracking(int[] arr, int target, int start, List<Integer> list) {
        if (target == 0) {
            this.ret.add(new ArrayList<>(list));
            return;
        }
        // 开始遍历处理
        for (int i = start; i < arr.length; i++) {
            if (target - arr[i] < 0) {
                break;
            }
            list.add(arr[i]);
            backTracking(arr, target - arr[i], i, list); // 这里要注意去重
            list.removeLast();
        }
    }

    // 所有能组成target的元素集合，可以无限去某一个元素
    // 通过遍历的方式进行求解
    public List<List<Integer>> findAllResult01(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        backTracking01(arr, target, 0, new ArrayList<>());
        return ret;
    }

    public void backTracking01(int[] arr, int target, int start, List<Integer> list) {
        if (target == 0) {
            ret.add(new ArrayList<>(list));
            return;
        }
        if (start >= arr.length) {
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (target - arr[i] < 0) {
                break;
            }
            list.add(arr[i]);
            backTracking01(arr, target - arr[i], i, list);
            list.removeLast();
        }
    }

    public List<List<Integer>> findAllResult02(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        // 进行递归查找
        backTracking02(arr, target, 0, new ArrayList<>());
        return ret;
    }

    public void backTracking02(int[] arr, int target, int start, List<Integer> list) {
        if (target == 0) {
            ret.add(new ArrayList<>(list));
        }
        for (int i = start; i < arr.length; i++) {
            if (target - arr[i] < 0) {
                break;
            }
            list.add(arr[i]);
            backTracking02(arr, target - arr[i], i, list);
            list.removeLast();
        }
    }

    //  需要使用回溯的方式进行处理
    public List<List<Integer>> findAllResult03(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        backTracking03(arr, target, 0, new ArrayList<>());
        return ret;
    }

    public void backTracking03(int[] arr, int target, int start, List<Integer> list) {
        if (target == 0) {
            ret.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (target - arr[i] < 0) {
                break;
            }
            list.add(arr[i]);
            // 这里要传递的是i，要不然会重复
            backTracking03(arr, target - arr[i], i, list);
            list.removeLast();
        }
    }

    public List<List<Integer>> findAllResult04(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        backTracking04(arr, 0, target, new ArrayList<>());
        return ret;
    }

    public void backTracking04(int[] arr, int index, int target, List<Integer> list) {
        if (index == arr.length) {
            return;
        }
        if (target == 0) {
            System.out.println(list.toString());
            ret.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < arr.length; i++) {
//            if (target < 0) {
//                break;
//            }
//            target -= arr[i]; // 不能先减，减完没有恢复 恢复版本，如果不使用这种方式就不能这样使用
//            list.add(arr[i]);
//            backTracking04(arr, i, target, list);
//            Integer i1 = list.removeLast();
//            target += i1;
            if (target - arr[i] < 0) {
                break;
            }
            list.add(arr[i]);
            backTracking04(arr, i, target - arr[i], list);
            list.removeLast();
        }
    }


    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] arr = new int[]{2, 3, 6, 7};
        List<List<Integer>> allResult = combinationSum.findAllResult04(arr, 7);
        System.out.println(allResult.toString());
    }
}
