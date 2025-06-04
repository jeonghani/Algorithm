class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        long max1 = Long.MIN_VALUE; // 펄스 1로 시작
        long max2 = Long.MIN_VALUE; // 펄스 -1로 시작
        long sum1 = 0; // 현재 펄스 1로 시작 부분합
        long sum2 = 0; // 현재 펄스 -1로 시작 부분합

        for (int i = 0; i < n; i++) {
            int pulse1 = (i % 2 == 0) ? 1 : -1;
            int pulse2 = (i % 2 == 0) ? -1 : 1;

            long v1 = sequence[i] * pulse1;
            long v2 = sequence[i] * pulse2;

            sum1 = Math.max(v1, sum1 + v1);
            sum2 = Math.max(v2, sum2 + v2);

            max1 = Math.max(max1, sum1);
            max2 = Math.max(max2, sum2);
        }

        return Math.max(max1, max2);
    }
}
