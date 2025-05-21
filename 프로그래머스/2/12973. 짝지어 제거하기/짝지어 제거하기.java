import java.util.ArrayList;
class Solution
{
    public int solution(String s) {
        ArrayList<Character> stack = new ArrayList<>();

        for (char c : s.toCharArray()) {
            int size = stack.size();
            if (size > 0 && stack.get(size - 1) == c) {
                stack.remove(size - 1); // 짝 제거
            } else {
                stack.add(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}