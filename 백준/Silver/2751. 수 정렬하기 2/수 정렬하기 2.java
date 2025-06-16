import java.io.*;

public class Main {
    static int[] arr, temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        temp = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0, N - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append('\n');
        }
        System.out.print(sb);
    }

    static void mergeSort(int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        mergeSort(left, mid);
        mergeSort(mid + 1, right);

        merge(left, mid, right);
    }

    static void merge(int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        // 임시 배열에 정렬된 값 복사
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        // 원본 배열에 복사
        for (int l = left; l <= right; l++) {
            arr[l] = temp[l];
        }
    }
}
