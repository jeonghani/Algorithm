import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expr = br.readLine(); // 입력 받기

        String[] minusSplit = expr.split("-");
        int result = 0;

        // 첫 조각: 무조건 더함
        for (String s : minusSplit[0].split("\\+")) {
            result += Integer.parseInt(s);
        }

        // 나머지 조각: 각각 +로 쪼개서 전부 합한 뒤 빼준다
        for (int i = 1; i < minusSplit.length; i++) {
            int temp = 0;
            for (String s : minusSplit[i].split("\\+")) {
                temp += Integer.parseInt(s);
            }
            result -= temp;
        }

        System.out.println(result);
    }
}
