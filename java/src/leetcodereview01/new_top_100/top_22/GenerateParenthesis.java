package leetcodereview01.new_top_100.top_22;

import java.util.ArrayList;
import java.util.List;

/** 括号的生成 */
public class GenerateParenthesis {

    private List<List<String>> ret = new ArrayList<>();

    public List<List<String>> generate01(int n) {
        // 使用回溯的方式进行处理
        if (n < 0) {
            return null;
        }
        backTracking01(new ArrayList<String>(), 0, 0, n);
        return ret;
    }

    public void backTracking01(List<String> list, int open, int close, int max) {
        if (list.size() == max * 2) {
            ret.add(new ArrayList<>(list));
            return;
        }
        if(open < max) {
            list.add("(");
            System.out.println("11111---add");
            backTracking01(list, open + 1, close , max);
            list.remove(list.size() - 1);
            System.out.println("111111-remove");
        }

        if (close < open) {
            list.add(")");
            backTracking01(list, open, close + 1, max);
            list.remove(list.size() - 1);
        }
    }


    public List<List<String>> generate02(int n) {
        if (n == 0) {
            return null;
        }
        backTracking02(n, 0, 0, new ArrayList<>());
        return ret;
    }

    public void backTracking02(int max, int start, int end, List<String> list) {
        System.out.println(list.size() + "start," + start + ",end" + end);
        if (list.size() == max * 2) {
            ret.add(new ArrayList<>(list));
            return;
        }
        if (start < max) {
            list.add("(");
            backTracking02(max, start + 1, end, list);
            list.remove(list.size() - 1);
        }
        if (end < start) {
            list.add(")");
            backTracking02(max, start, end + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public List<List<String>> generate03(int n) {
        if (n == 0) {
            return null;
        }
        backTracking03(n, 0, 0, new ArrayList<>());
        return ret;
    }

    public void backTracking03(int max, int start, int end, List<String> list) {
        if (list.size() == max * 2) {
            ret.add(new ArrayList<>(list));
            return;
        }
        if(start < max) {
            list.add("(");
            backTracking03(max, start + 1, end, list);
            list.remove(list.size() - 1);
            System.out.println("1111");
        }

        if(end < start) {
            list.add(")");
            backTracking03(max, start, end + 1, list);
            list.remove(list.size() - 1);
            System.out.println("2222:" + start + ",end" + end);
        }

    }


    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<List<String>> list = generateParenthesis.generate03(3);
        System.out.println(list.toString());
    }
}
