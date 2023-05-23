package LiveClass.day05.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_24416 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        System.out.print(fib(num) +" " +fibonacci(num));
    }

    public static int fib(int n){
        int answer = 0;

        if (n == 1 || n == 2)
            answer = 1;
        else
            answer = fib(n-1) + fib(n-2);

        return answer;
    }

    public static int fibonacci(int n){
        int[] f = new int[100];
        int answer = 0;
        f[1] = 1;
        f[2] = 2;

        for (int i = 3; i <= n; i++) {
            f[i] = f[i-1] + f[i-2];
            answer++;
        }

        return answer;
    }
}
