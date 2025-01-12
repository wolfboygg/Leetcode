package leetcodereview01.new_top_100.top_20;

import java.util.Stack;

/**
 * 有效的括号
 */
public class ValidKH {

    public boolean valid(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        // 使用栈来实现判断
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && (stack.isEmpty() || stack.pop() != '(')) {
                return false;
            } else if (c == ']' && (stack.isEmpty() || stack.pop() != '[')) {
                return false;
            } else if (c == '}' && (stack.isEmpty() || stack.pop() != '{')) {
                return false;
            }
        }
        return true;
    }

    public boolean valid01(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] charArr = str.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '(' || charArr[i] == '[' || charArr[i] == '{') {
                stack.push(charArr[i]);
            } else if (charArr[i] == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (charArr[i] == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (charArr[i] == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str1 = "([)]";
        String str2 = "{[]}";
        ValidKH validKH = new ValidKH();
        System.out.println(validKH.valid01(str1));
        System.out.println(validKH.valid01(str2));

    }

}
