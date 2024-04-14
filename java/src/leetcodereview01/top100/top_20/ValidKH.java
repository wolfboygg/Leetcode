package leetcodereview01.top100.top_20;

import java.util.Stack;

/**
 * 有效的括号
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class ValidKH {

    public boolean valid(String s) {
        // 判断包含括号的字符串是否有效
        // 思路通过栈来进行校验 判断当前元素和栈顶的元素是否相同 遇到开始的元素只管入栈
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && (stack.isEmpty() || stack.pop() != '(')) { // 只检查最后的闭合
                System.out.println("1111");
                return false;
            } else if (c == ']' && (stack.isEmpty() || stack.pop() != '[')) {
                System.out.println("2222");
                return false;
            } else if (c == '}' && (stack.isEmpty() || stack.pop() != '{')) {
                System.out.println("3333");
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean validKH(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        char[] charArr = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[i];
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            if (c == ')' && (stack.isEmpty() || stack.pop() != '(')) {
                return false;
            }
            if (c == ']' && (stack.isEmpty() || stack.pop() != '[')) {
                return false;
            }
            if (c == '}' && (stack.isEmpty() || stack.pop() != '{')) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        String str1 = "([)]";
        String str2 = "{[]}";
        ValidKH validKH = new ValidKH();
        System.out.println(validKH.validKH(str1));
        System.out.println(validKH.validKH(str2));
    }
}
