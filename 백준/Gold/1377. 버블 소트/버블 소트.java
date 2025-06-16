import java.io.*;
import java.util.*;

public class Main {
    static class Num implements Comparable<Num> {
        int value, idx;
        Num(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }
        public int compareTo(Num o) {
            return Integer.compare(this.value, o.value);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Num[] arr = new Num[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new Num(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(arr);

        int maxMove = 0;
        for (int i = 0; i < N; i++) {
            // arr[i].idx: 원래 위치, i: 정렬된 위치
            // 원래 위치에서 정렬된 위치로 올 때 앞으로 얼마나 왔는지
            if (arr[i].idx - i > maxMove) {
                maxMove = arr[i].idx - i;
            }
        }
        System.out.println(maxMove + 1);
    }
}
