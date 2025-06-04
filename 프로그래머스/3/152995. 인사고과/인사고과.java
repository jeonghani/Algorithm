import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int targetA = scores[0][0];
        int targetB = scores[0][1];
        int targetSum = targetA + targetB;

        List<int[]> employees = new ArrayList<>();
        for (int[] score : scores) {
            employees.add(new int[]{score[0], score[1]});
        }

        // 근무 태도 내림차순, 동료평가 내림차순 정렬
        employees.sort((a, b) -> {
            if (a[0] == b[0]) return Integer.compare(b[1], a[1]);
            return Integer.compare(b[0], a[0]);
        });

        int maxPeer = 0;
        int prevA = -1;
        int groupMaxB = 0;
        List<int[]> incentiveList = new ArrayList<>();

        for (int[] emp : employees) {
            int a = emp[0];
            int b = emp[1];

            if (a != prevA) {
                maxPeer = Math.max(maxPeer, groupMaxB);
                groupMaxB = b;
                prevA = a;
            } else {
                groupMaxB = Math.max(groupMaxB, b);
            }

            if (b >= maxPeer) {
                incentiveList.add(emp);
            }
        }

        // 첫 번째 직원이 인센티브 대상인지 확인
        boolean isTargetIncentive = false;
        for (int[] emp : incentiveList) {
            if (emp[0] == targetA && emp[1] == targetB) {
                isTargetIncentive = true;
                break;
            }
        }
        if (!isTargetIncentive) return -1;

        // 합계 기준 내림차순 정렬
        List<Integer> sumList = new ArrayList<>();
        for (int[] emp : incentiveList) {
            sumList.add(emp[0] + emp[1]);
        }
        sumList.sort(Collections.reverseOrder());

        // targetSum보다 큰 합계의 개수 + 1이 등수
        int rank = 1;
        for (int sum : sumList) {
            if (sum > targetSum) rank++;
            else break;
        }
        return rank;
    }
}
