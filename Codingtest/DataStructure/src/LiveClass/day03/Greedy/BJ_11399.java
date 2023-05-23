package LiveClass.day03.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] P = new int[N];

        int temp = 0;
        int answer = 0;

        for (int i = 0; i < P.length; i++) {
            P[i] = sc.nextInt();
        }

        Arrays.sort(P);

        for (int i = 0; i < P.length; i++) {
            answer += temp + P[i];
            temp += P[i];
        }

        System.out.println(answer);
    }
}
