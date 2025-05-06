class Solution {
    int answer = Integer.MAX_VALUE; // 최소 단계 저장
    boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    void dfs(String current, String target, String[] words, int step) {
        if (current.equals(target)) {
            answer = Math.min(answer, step);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && isOneDiff(current, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, step + 1);
                visited[i] = false; // 백트래킹
            }
        }
    }

    boolean isOneDiff(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) count++;
            if (count > 1) return false;
        }
        return count == 1;
    }
}