import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] count = new long[M];
        long sum = 0;
        long answer = 0;

        st = new StringTokenizer(br.readLine());
        count[0] = 1;

        for (int i=0;i<N;i++) {
            sum += Integer.parseInt(st.nextToken());
            int mod = (int)(sum%M);
            if (mod < 0) {
                mod += M;
            }
            answer += count[mod];
            count[mod]++;
        }
        System.out.println(answer);
    }
}