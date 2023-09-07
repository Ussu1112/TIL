package InflearnClass;

import java.util.Scanner;

public class 소수_에라토스테네스체 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        solution(count);
    }

    private static void solution(int count) {
        int answer = 1;

        for (int i = 3; i < count; i++) {
            for(int j = 2; j*j <= i; j++){
                if(i % j != 0) {
                    System.out.print("i = " + i);
                    System.out.println(" j = " + j);
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
