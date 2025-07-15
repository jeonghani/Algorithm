import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] lectures = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0, sum = 0;
        for (int i = 0; i < N; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, lectures[i]);
            sum += lectures[i];
        }

        int left = max;       // 블루레이 최소 크기 (가장 긴 강의)
        int right = sum;      // 블루레이 최대 크기 (모든 강의 합)
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            int tempSum = 0;
            int count = 1; // 블루레이 개수
            for (int l : lectures) {
                if (tempSum + l > mid) {
                    count++;
                    tempSum = 0;
                }
                tempSum += l;
            }

            if (count > M) {
                left = mid + 1; // 크기 늘려야 함
            } else {
                answer = mid;
                right = mid - 1; // 크기 줄여보기
            }
        }

        System.out.println(answer);
    }
}
