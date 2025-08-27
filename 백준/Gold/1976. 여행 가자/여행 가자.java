import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    // Find 연산 
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    // Union 연산
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        
        // 도시 연결 정보 입력
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int connected = Integer.parseInt(st.nextToken());
                if (connected == 1) {
                    union(i, j);
                }
            }
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int firstCity = Integer.parseInt(st.nextToken()); // 여행 일정 첫 도시
        boolean possible = true;
        
        // 여행 계획 안의 도시들이 모두 같은 집합에 속하는지 확인
        for (int i = 1; i < M; i++) {
            int city = Integer.parseInt(st.nextToken());
            if (find(firstCity) != find(city)) {
                possible = false;
                break;
            }
        }
        
        System.out.println(possible ? "YES" : "NO");
    }
}
