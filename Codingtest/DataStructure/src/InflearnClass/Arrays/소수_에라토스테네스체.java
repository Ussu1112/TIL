package InflearnClass.Arrays;

import java.util.Scanner;

public class 소수_에라토스테네스체 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        solution(count);
    }

    private static void solution(int count) {
        int answer = 0;
        int[] ch = new int[count+1];
        for (int i = 2; i < count; i++) {
            if(ch[i] == 0){
                answer++;
                for (int j = 0; j <= count; j= j+i) {
                    ch[j] = 1;
                }
            }
        }
        System.out.println(answer);
    }
}
