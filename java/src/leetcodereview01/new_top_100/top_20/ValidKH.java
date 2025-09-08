package leetcodereview01.new_top_100.top_20;


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


    /** 就看栈顶的字符是否是匹配的那个 */
    public boolean validKH01(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '[' || chars[i] == '(' || chars[i] =='{') {
                stack.push(chars[i]);
            }
            if (chars[i] == ')' && (stack.isEmpty() || stack.pop() != '(')) {
                return false;
            }
            if (chars[i] == ']' && (stack.isEmpty() || stack.pop() != '[')) {
                return false;
            }
            if (chars[i] == '}' && (stack.isEmpty() || stack.pop() != '{')) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean validKH02(String str) {
        // 验证是否是一个正确的括号，需要使用stack来进行匹配
        if (str == null || str.length() == 0) {
            return false;
        }
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
                stack.push(chars[i]);
            } else if (chars[i]== ')' && (stack.isEmpty() || stack.pop() != '(')) {
                System.out.println("1111");
                return false;
            } else if (chars[i]=='}' && (stack.isEmpty() || stack.pop() != '{')) {
                System.out.println("2222");
                return false;
            } else if (chars[i] == ']' && (stack.isEmpty() || stack.pop() != '[')) {
                System.out.println("3333");
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean validKH03(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) =='[' || str.charAt(i) == '{') {
                stack.push(str.charAt(i));
            } else if (str.charAt(i) == ')' && (stack.isEmpty() || stack.pop() != '(')) {
                return false;
            } else if (str.charAt(i) == ']' && (stack.isEmpty() || stack.pop() != '[')) {
                return false;
            } else if (str.charAt(i) == '}' && (stack.isEmpty() || stack.pop() != '{')) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean validKH04(String str) {
        // 通过栈来实现验证括号
        if (str == null || str.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) =='(' || str.charAt(i)=='[' || str.charAt(i) == '{') {
                stack.push(str.charAt(i));
            } else if (str.charAt(i) == ')' && (stack.isEmpty() || stack.pop() != '(')) {
                return false;
            } else if (str.charAt(i) == '}' && (stack.isEmpty() || stack.pop() != '{')) {
                return false;

            } else if (str.charAt(i) == ']' && (stack.isEmpty() || stack.pop() != '[')) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean validKH05(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        // 使用栈来处理
        Stack<Character> stack = new Stack<>();
        char[] charArray = str.toCharArray();
        for (char item : charArray) {
            if (item == '(' || item == '{' || item == '[') {
                stack.push(item);
            } else if (item == ')' && (stack.isEmpty() || stack.pop() != '(')) {
                return false;
            } else if (item == ']' && (stack.isEmpty() || stack.pop() != '[')) {
                return false;
            } else if (item == '}' && (stack.isEmpty() || stack.pop() != '{')) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean validKH06(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] charArr = str.toCharArray();
        for (char c : charArr) {
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
        return stack.isEmpty();
    }

    public static void main(String[] args){
        String str1 = "([)]";
        String str2 = "{[]}";
        ValidKH validKH = new ValidKH();
        System.out.println(validKH.validKH06(str1));
        System.out.println(validKH.validKH06(str2));
    }
}
