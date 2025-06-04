import java.util.*;

class Solution {
    // 방 번호 매핑을 저장할 HashMap
    Map<Long, Long> roomMap = new HashMap<>();

    public long[] solution(long k, long[] room_number) {
        int n = room_number.length;
        long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            answer[i] = find(room_number[i]);
        }

        return answer;
    }

    // 다음 가능한 방을 찾는 재귀 함수 (with 경로 압축)
    private long find(long room) {
        if (!roomMap.containsKey(room)) {
            roomMap.put(room, room + 1); // 다음 가능한 방 번호로 연결
            return room;
        }

        long next = find(roomMap.get(room)); // 다음 빈 방 탐색
        roomMap.put(room, next); // 경로 압축
        return next;
    }
}
