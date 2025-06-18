import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] values = new int[N];
        Integer[] idxArr = new Integer[N]; // 반드시 Integer 배열이어야 Comparator 사용 가능

        // 입력받으면서 idxArr도 같이 초기화
        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(br.readLine());
            idxArr[i] = i;
        }

        // 값 기준으로 인덱스 배열 정렬 (Comparator 필수!)
        Arrays.sort(idxArr, Comparator.comparingInt(i -> values[i]));

        int maxMove = 0;
        for (int sortedIdx = 0; sortedIdx < N; sortedIdx++) {
            int before = idxArr[sortedIdx]; // 원래 위치
            int move = before - sortedIdx;  // 앞으로 이동한 칸 수
            if (move > maxMove) maxMove = move;
        }

        System.out.println(maxMove + 1);
    }
}
