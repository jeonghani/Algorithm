import java.util.*;

class Solution {
    int n;
    long[][] dpMax, dpMin;
    long[] nums;
    char[] ops;

    public int solution(String[] arr) {
        n = (arr.length + 1) / 2;
        nums = new long[n];
        ops = new char[n - 1];

        // 숫자와 연산자 분리
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(arr[i * 2]);
        }
        for (int i = 0; i < n - 1; i++) {
            ops[i] = arr[i * 2 + 1].charAt(0);
        }

        dpMax = new long[n][n];
        dpMin = new long[n][n];

        // DP 배열 초기화
        for (int i = 0; i < n; i++) {
            Arrays.fill(dpMax[i], Long.MIN_VALUE);
            Arrays.fill(dpMin[i], Long.MAX_VALUE);
            dpMax[i][i] = nums[i];
            dpMin[i][i] = nums[i];
        }

        // 전체 구간의 최대값 계산
        return (int)dfs(0, n - 1);
    }

    // i~j 구간의 최대값 계산 (최솟값도 dpMin에 저장)
    private long dfs(int i, int j) {
        if (dpMax[i][j] != Long.MIN_VALUE) return dpMax[i][j];

        long maxVal = Long.MIN_VALUE;
        long minVal = Long.MAX_VALUE;

        for (int k = i; k < j; k++) {
            long leftMax = dfs(i, k);
            long leftMin = dpMin[i][k];
            long rightMax = dfs(k + 1, j);
            long rightMin = dpMin[k + 1][j];

            char op = ops[k];

            long[] candidates = new long[4];
            candidates[0] = calc(leftMax, rightMax, op);
            candidates[1] = calc(leftMax, rightMin, op);
            candidates[2] = calc(leftMin, rightMax, op);
            candidates[3] = calc(leftMin, rightMin, op);

            for (long val : candidates) {
                maxVal = Math.max(maxVal, val);
                minVal = Math.min(minVal, val);
            }
        }

        dpMax[i][j] = maxVal;
        dpMin[i][j] = minVal;
        return maxVal;
    }

    private long calc(long a, long b, char op) {
        if (op == '+') return a + b;
        else return a - b;
    }
}
