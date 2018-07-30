/**
 * 判断括号匹配是否正确，用栈的思想来解决
 * 当出现左括号的时候入栈，当遇到右括号，判断栈顶的左括号是否匹配，不匹配的话直接返回
 * false，最终判断是否空栈，这里可以用数组模拟栈使其操作更快
 * 
 * 
 */
public class ValidParentheses {
    public static void main(String[] args) {
        boolean valid1 = isValid("({{}})");

        System.out.println(valid1);

        boolean valid2 = isValid("({{{})");

        System.out.println(valid2);

        boolean valid3 = isValid("({[[}");
        System.out.println(valid3);
    }

    public static boolean isValid(String s) {
        char[] stack = new char[s.length() + 1];
        int top = 1;

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack[top++] = c;
            } else if (c == ')' && stack[--top] != '(') {
                return false;
            } else if (c == '}' && stack[--top] != '{') {
                return false;
            } else if (c == ']' && stack[--top] != '[') {
                return false;
            } 
        }
        return top == 1;
    }
}