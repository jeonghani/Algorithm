import java.io.*;
import java.util.*;

public class Main {
    static int[] arr, output;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        output = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        radixSort(arr, output, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append('\n');
        }
        System.out.print(sb);
    }

    // 기수 정렬 (LSD, 0~10000)
    static void radixSort(int[] arr, int[] output, int N) {
        int max = 10000; // 입력 조건상 최대값
        int exp = 1; // 1의 자리부터 시작

        while (max / exp > 0) {
            int[] count = new int[10];

            // 각 자릿수별 개수 세기
            for (int i = 0; i < N; i++) {
                count[(arr[i] / exp) % 10]++;
            }

            // 누적합
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            // output 배열에 정렬 결과 저장 (뒤에서부터 해야 안정정렬)
            for (int i = N - 1; i >= 0; i--) {
                int idx = (arr[i] / exp) % 10;
                output[--count[idx]] = arr[i];
            }

            // output → arr 복사
            for (int i = 0; i < N; i++) {
                arr[i] = output[i];
            }

            exp *= 10; // 다음 자릿수로
        }
    }
}
