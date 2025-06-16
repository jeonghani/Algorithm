import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {
            queue.poll(); // 맨 앞 카드 버리기
            queue.offer(queue.poll()); // 맨 앞 카드를 맨 뒤로 보내기
        }

        System.out.println(queue.poll());
    }
}
