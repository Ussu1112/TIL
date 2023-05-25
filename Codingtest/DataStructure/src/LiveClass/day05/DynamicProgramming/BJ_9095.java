package LiveClass.day05.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9095 {

    // dp[n] = dp[n-3] + dp[n-2] + dp[n-1] (n>3)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[11];

        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        int a = 0;
        for (int i = 0; i < num; i++) {
            a = Integer.parseInt(br.readLine());
            for (int j = 4; j < a; j++) {

            }
        }

    }
}
