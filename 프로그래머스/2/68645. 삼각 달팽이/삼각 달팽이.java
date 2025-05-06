import java.util.*;

class Solution {
    public int[] solution(int n) {
        // 삼각형 배열을 생성
        int[][] triangle = new int[n][n];
        int num = 1; // 채워 넣을 숫자
        int x = -1, y = 0; // 시작 위치 (첫 방향은 아래이므로 x=-1)
        int direction = 0; // 방향: 0(아래), 1(오른쪽), 2(위왼쪽)
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (direction == 0) { // 아래
                    x++;
                } else if (direction == 1) { // 오른쪽
                    y++;
                } else if (direction == 2) { // 위왼쪽 대각
                    x--;
                    y--;
                }
                triangle[x][y] = num++;
            }
            direction = (direction + 1) % 3; // 방향 변경
        }
        
        // 결과를 1차원 배열로 변환
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result.add(triangle[i][j]);
            }
        }

        // List -> int[] 변환
        return result.stream().mapToInt(i -> i).toArray();
    }
}