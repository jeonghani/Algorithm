import java.util.*;

class Solution {
    public int solution(int n, int[][] lighthouse) {
        // 인접 리스트 생성
        List<Integer>[] adj = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : lighthouse) {
            int a = edge[0];
            int b = edge[1];
            adj[a].add(b);
            adj[b].add(a);
        }

        int[][] dp = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = 1; // 초기값 설정 (자신을 켤 경우)
        }

        Deque<Object[]> stack = new ArrayDeque<>();
        stack.push(new Object[]{1, -1, false});

        while (!stack.isEmpty()) {
            Object[] entry = stack.pop();
            int u = (int) entry[0];
            int parent = (int) entry[1];
            boolean visited = (boolean) entry[2];

            if (!visited) {
                stack.push(new Object[]{u, parent, true});
                for (int v : adj[u]) {
                    if (v != parent) {
                        stack.push(new Object[]{v, u, false});
                    }
                }
            } else {
                dp[u][0] = 0;
                dp[u][1] = 1; // 기본값 재설정
                for (int v : adj[u]) {
                    if (v != parent) {
                        dp[u][0] += dp[v][1];
                        dp[u][1] += Math.min(dp[v][0], dp[v][1]);
                    }
                }
            }
        }

        return Math.min(dp[1][0], dp[1][1]);
    }
}
