import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> {
                int absA = Math.abs(a);
                int absB = Math.abs(b);
                if (absA == absB) return a - b; // 절댓값 같으면 실제 값 작은 것 우선
                return absA - absB; // 절댓값 작은 것 우선
            }
        );

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                pq.offer(x);
            } else {
                if (pq.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(pq.poll()).append('\n');
                }
            }
        }
        System.out.print(sb);
    }
}
