import java.util.Arrays;

class Solution {
    public int[] solution(int[] numlist, int n) {
         // Integer 배열로 변환 (정렬 기준을 주기 위해 필요)
        Integer[] arr = new Integer[numlist.length];
        for (int i = 0; i < numlist.length; i++) {
            arr[i] = numlist[i];
        }

        // 정렬: 거리 기준 오름차순, 거리 같으면 더 큰 수가 앞에
        Arrays.sort(arr, (a, b) -> {
            int diffA = Math.abs(a - n);
            int diffB = Math.abs(b - n);

            if (diffA == diffB) {
                return b - a; // 거리 같으면 큰 수 먼저
            } else {
                return diffA - diffB; // 거리 가까운 순
            }
        });

        // 다시 int[]로 변환
        int[] answer = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            answer[i] = arr[i];
        }

        return answer;
    }
}