public class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] wins = new boolean[n+1][n+1];

        // 경기 결과 입력
        for (int[] result : results) {
            wins[result[0]][result[1]] = true;
        }

        // 플로이드-워셜 알고리즘 적용
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    // 선수 i가 k를 이기고, k가 선수 j를 이기면, 선수 i는 선수 j를 이긴다.
                    if (wins[i][k] && wins[k][j]) {
                        wins[i][j] = true;
                    }
                }
            }
        }

        int count = 0;
        
        // 순위를 확정할 수 있는 선수 수 찾기
        for (int i = 1; i <= n; i++) {
            int knownCount = 0;
            for (int j = 1; j <= n; j++) {
                if (wins[i][j] || wins[j][i]) {
                    knownCount++;
                }
            }
            if (knownCount == n - 1) {
                count++;
            }
        }

        return count;
    }
}