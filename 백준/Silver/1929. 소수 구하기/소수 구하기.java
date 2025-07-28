import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        boolean[] isNotPrime = new boolean[N + 1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        // 에라토스테네스의 체
        for (int i = 2; i * i <= N; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (!isNotPrime[i]) {
                sb.append(i).append('\n');
            }
        }
        System.out.print(sb);
    }
}
