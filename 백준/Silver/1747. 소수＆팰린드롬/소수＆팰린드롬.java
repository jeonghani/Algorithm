import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int MAX = 1100000; // 1,000,000보다 조금 더 큰 범위
        boolean[] isNotPrime = new boolean[MAX + 1];
        isNotPrime[0] = isNotPrime[1] = true;

        // 에라토스테네스의 체
        for (int i = 2; i * i <= MAX; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        for (int i = N; i <= MAX; i++) {
            if (!isNotPrime[i] && isPalindrome(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    static boolean isPalindrome(int n) {
        String s = Integer.toString(n);
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) return false;
        }
        return true;
    }
}
