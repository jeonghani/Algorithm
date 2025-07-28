import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        // P^2 <= B 이므로 √B 까지만 소수를 구하면 됩니다.
        int max = (int) Math.sqrt(B) + 1;
        boolean[] isNotPrime = new boolean[max + 1];

        // 에라토스테네스의 체로 소수 찾기
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for (int i = 2; i * i <= max; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        int count = 0;

        for (int i = 2; i <= max; i++) {
            if (!isNotPrime[i]) {
                long prime = i;
                long val = prime * prime; // 최소 제곱수
                while (val <= B) {
                    if (val >= A) count++;
                    if (val > B / prime) break; // overflow 방지
                    val *= prime;
                }
            }
        }
        System.out.println(count);
    }
}
