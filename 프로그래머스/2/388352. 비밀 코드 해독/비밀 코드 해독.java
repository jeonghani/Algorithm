import java.util.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        List<int[]> combinations = new ArrayList<>();
        generateCombinations(n, 5, 1, new int[5], 0, combinations);

        int validCount = 0;
        for (int[] code : combinations) {
            boolean isValid = true;
            for (int i = 0; i < q.length; i++) {
                int match = countMatches(code, q[i]);
                if (match != ans[i]) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) validCount++;
        }

        return validCount;
    }

    // 조합 생성 함수
    void generateCombinations(int n, int k, int start, int[] comb, int depth, List<int[]> result) {
        if (depth == k) {
            result.add(Arrays.copyOf(comb, k));
            return;
        }
        for (int i = start; i <= n - (k - depth) + 1; i++) {
            comb[depth] = i;
            generateCombinations(n, k, i + 1, comb, depth + 1, result);
        }
    }

    // 두 배열 사이의 교집합 원소 개수 세기
    int countMatches(int[] a, int[] b) {
        int count = 0;
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                count++;
                i++; j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
        return count;
    }
}
