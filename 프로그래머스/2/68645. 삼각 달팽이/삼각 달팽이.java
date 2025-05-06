import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] triangle = new int[n][n]; // 2차원 배열 만들기
        int x = -1, y = 0, num = 1;

        // 각 단계마다 채우는 수가 줄어들면서 반복
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {      // 아래로 이동
                    x++;
                } else if (i % 3 == 1) { // 오른쪽 이동
                    y++;
                } else if (i % 3 == 2) { // 위 대각선 이동
                    x--;
                    y--;
                }
                triangle[x][y] = num++;
            }
        }

        // 결과 담을 배열 크기 미리 계산
        int size = n * (n + 1) / 2;
        int[] answer = new int[size];
        int idx = 0;

        // 삼각형 모양으로만 꺼내기 (i행은 i+1개만 채워져 있음)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = triangle[i][j];
            }
        }

        return answer;
    }
}