import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;

        // i번째 set에는 N을 i번 사용해서 만들 수 있는 모든 수 저장
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        // N, NN, NNN, ... (붙여쓰기)
        for (int i = 1; i <= 8; i++) {
            int num = 0;
            for (int j = 0; j < i; j++) {
                num = num * 10 + N;
            }
            dp.get(i).add(num);
        }

        // DP
        for (int i = 1; i <= 8; i++) {
            // i를 1~i-1로 분할
            for (int j = 1; j < i; j++) {
                for (int a : dp.get(j)) {
                    for (int b : dp.get(i - j)) {
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        if (b != 0) dp.get(i).add(a / b);
                    }
                }
            }
            // 목표 수가 있으면 바로 리턴
            if (dp.get(i).contains(number)) return i;
        }
        return -1;
    }
}
