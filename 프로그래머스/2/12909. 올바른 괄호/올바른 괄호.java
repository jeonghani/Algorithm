import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else { // c == ')'
                if (stack.isEmpty()) {
                    return false; // 짝이 안 맞음
                }
                stack.pop();
            }
        }

        return stack.isEmpty(); // 스택이 비어있어야 모든 괄호가 짝지어진 것
    }
}