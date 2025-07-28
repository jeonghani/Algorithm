import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        int size = (int)(max - min + 1);
        boolean[] isNotSquareFree = new boolean[size]; // false: 제곱ㄴㄴ 후보

        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long start = ((min + pow - 1) / pow) * pow; // min 이상에서 pow의 배수 첫 값
            for (long j = start; j <= max; j += pow) {
                isNotSquareFree[(int)(j - min)] = true; // 제곱수의 배수라서 제외!
            }
        }

        int answer = 0;
        for (int i = 0; i < size; i++) {
            if (!isNotSquareFree[i]) answer++; // 배수 아니면 제곱ㄴㄴ수
        }
        System.out.println(answer);
    }
}
