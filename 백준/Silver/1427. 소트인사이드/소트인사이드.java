import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int len = N.length();
        char[] arr = N.toCharArray();

        // 선택정렬(내림차순)
        for (int i = 0; i < len - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }
            // swap
            char temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
        }

        System.out.println(new String(arr));
    }
}
