import java.io.*;
import java.util.*;

public class Main {
    static int[] map = new int[256];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String s = br.readLine().trim();

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        map['A'] = 0;
        map['C'] = 1;
        map['G'] = 2;
        map['T'] = 3;

        int[] counts = new int[4];
        int result = 0;

        for(int i=0;i<P;i++) {
            char ch = s.charAt(i);
            counts[map[ch]]++;
        }
        if (isValid(counts, a, c, g, t)) result++;

        for (int i = 1; i <= N - P; i++) {
            int outgoingIndex = i - 1;
            counts[map[s.charAt(outgoingIndex)]]--; // 이전 문자 제거

            int incomingIndex = i + P - 1;
            counts[map[s.charAt(incomingIndex)]]++; // 새 문자 추가

            if (isValid(counts, a, c, g, t)) result++;
        }
        System.out.println(result);
    }
    private static boolean isValid(int[] counts, int a, int c, int g, int t) {
        return counts[0] >= a && counts[1] >= c && counts[2] >= g && counts[3] >=t;
    }
}