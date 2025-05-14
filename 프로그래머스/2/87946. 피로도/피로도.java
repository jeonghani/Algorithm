class Solution {
    int max = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0);
        return max;
    }

    public void dfs(int k, int[][] dungeons, boolean[] visited, int count) {
        max = Math.max(max, count);

        for (int i = 0; i < dungeons.length; i++) {
            int minNeed = dungeons[i][0];
            int cost = dungeons[i][1];

            // 아직 방문하지 않았고, 피로도가 최소 요구치 이상인 경우
            if (!visited[i] && k >= minNeed) {
                visited[i] = true;
                dfs(k - cost, dungeons, visited, count + 1);
                visited[i] = false; // 백트래킹
            }
        }
    }
}