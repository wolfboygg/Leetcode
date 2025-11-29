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

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<List<String>> list = generateParenthesis.generate01(3);
        System.out.println(list.toString());
    }
}
