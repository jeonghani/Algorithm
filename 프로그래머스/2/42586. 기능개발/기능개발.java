import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        
        int n = progresses.length;
        int[] days = new int[n];

        // 1단계: 각 기능별로 완료까지 필요한 일수 계산
        for (int i = 0; i < n; i++) {
            int remain = 100 - progresses[i];
            days[i] = (int) Math.ceil((double) remain / speeds[i]);
        }

        // 2단계: 배포 그룹 계산
        int currentMaxDay = days[0];
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (days[i] <= currentMaxDay) {
                // 같은 날 또는 그 전에 끝나면 같은 배포 그룹
                count++;
            } else {
                // 새로운 배포 그룹 시작
                result.add(count);
                count = 1;
                currentMaxDay = days[i];
            }
        }
        result.add(count); // 마지막 그룹 추가

        // List를 int[]로 변환
        return result.stream().mapToInt(i -> i).toArray();
    }
}