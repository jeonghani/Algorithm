import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int suNo = scanner.nextInt();
        int quizNo = scanner.nextInt();
        long[] S = new long[suNo + 1];
        for (int i = 1; i <= suNo; i++) {
            S[i] = S[i - 1] + scanner.nextInt();
        }
        for (int q = 0; q < quizNo; q++) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            System.out.println(S[j] - S[i - 1]);
        }
        scanner.close();
    }
}
