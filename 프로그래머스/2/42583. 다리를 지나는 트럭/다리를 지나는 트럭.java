import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int totalWeight = 0;
        int index = 0; // 다음에 올라갈 트럭 인덱스

        // 다리 길이만큼 0으로 초기화
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        while (!bridge.isEmpty()) {
            time++; // 매 초 증가
            totalWeight -= bridge.poll(); // 한 칸 이동 (가장 앞 트럭 다리에서 빠짐)

            if (index < truck_weights.length) {
                int nextTruck = truck_weights[index];
                if (totalWeight + nextTruck <= weight) {
                    bridge.offer(nextTruck);  // 트럭 다리에 올림
                    totalWeight += nextTruck;
                    index++;
                } else {
                    bridge.offer(0);  // 트럭 못 올라가면 빈 칸
                }
            }
        }

        return time;
    }
}
