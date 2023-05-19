package day03.Greedy;

import java.util.Scanner;

public class BJ_11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] coins = new int[N];
        int K = sc.nextInt();
        int answer = 0;

        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }

        for (int i = N-1; i >= 0; i--) {
            if (K >= coins[i]){
                answer += K / coins[i];
                K = K % coins[i];
            }
        }
        System.out.println(answer);
    }
}
