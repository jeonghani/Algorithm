class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0, right = 0;
        int sum = sequence[0];

        int minLen = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while (right < sequence.length) {
            if (sum == k) {
                if (right - left < minLen) {
                    minLen = right - left;
                    answer[0] = left;
                    answer[1] = right;
                }
                sum -= sequence[left];
                left++;
            } else if (sum < k) {
                right++;
                if (right < sequence.length) {
                    sum += sequence[right];
                }
            } else { // sum > k
                sum -= sequence[left];
                left++;
            }
        }

        return answer;
    }
}
