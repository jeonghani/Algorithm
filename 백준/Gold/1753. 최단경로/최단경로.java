import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        
        ArrayList<Node>[] graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) graph[i] = new ArrayList<>();
        
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }
        
        int[] dist = new int[V + 1];
        boolean[] visited = new boolean[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;
        
        for (int i = 1; i <= V; i++) {
            int u = -1;
            int minDist = Integer.MAX_VALUE;
            // 방문하지 않은 노드 중 가장 가까운 노드 선택
            for (int j = 1; j <= V; j++) {
                if (!visited[j] && dist[j] < minDist) {
                    minDist = dist[j];
                    u = j;
                }
            }
            if (u == -1) break; // 더 이상 갈 수 있는 노드 없음
            visited[u] = true;
            
            // 선택된 노드를 통해 인접 노드 거리 갱신
            for (Node node : graph[u]) {
                if (!visited[node.vertex] && dist[u] + node.weight < dist[node.vertex]) {
                    dist[node.vertex] = dist[u] + node.weight;
                }
            }
        }
        
        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(dist[i]).append("\n");
        }
        System.out.print(sb);
    }
    
    static class Node {
        int vertex, weight;
        public Node(int v, int w) {
            vertex = v;
            weight = w;
        }
    }
}
