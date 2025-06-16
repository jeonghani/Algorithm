import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(0, N - 1);

        System.out.println(arr[K - 1]);
    }

    // 퀵 정렬 구현
    static void quickSort(int left, int right) {
        if (left >= right) return;
        int pivot = arr[(left + right) / 2];
        int l = left;
        int r = right;

        while (l <= r) {
            while (arr[l] < pivot) l++;
            while (arr[r] > pivot) r--;
            if (l <= r) {
                swap(l, r);
                l++;
                r--;
            }
        }
        quickSort(left, r);
        quickSort(l, right);
    }

    static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
