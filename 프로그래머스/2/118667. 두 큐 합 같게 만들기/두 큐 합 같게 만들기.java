import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0, sum2 = 0;
        int n = queue1.length;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int num : queue1) {
            sum1 += num;
            q1.offer(num);
        }
        for (int num : queue2) {
            sum2 += num;
            q2.offer(num);
        }

        long target = (sum1 + sum2);
        if (target % 2 != 0) return -1;
        target /= 2;

        int maxOperations = n * 3;
        int count = 0;
        while (count <= maxOperations) {
            if (sum1 == target) return count;

            if (sum1 > target) {
                int num = q1.poll();
                sum1 -= num;
                sum2 += num;
                q2.offer(num);
            } else {
                int num = q2.poll();
                sum2 -= num;
                sum1 += num;
                q1.offer(num);
            }
            count++;
        }

        return -1;
    }
}