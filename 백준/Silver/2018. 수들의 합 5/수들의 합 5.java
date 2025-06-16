import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int start = 1, end = 1, sum = 1, count = 0;

        while (start <= N) {
            if (sum < N) {
               end++;
               sum += end;
            }
            else if (sum > N) {
                sum -= start;
                start++;
            }
            else {
                count++;
                end++;
                sum += end;
            }
        }
        System.out.println(count);
    }
}