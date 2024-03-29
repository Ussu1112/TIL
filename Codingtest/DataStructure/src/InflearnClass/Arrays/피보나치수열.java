package InflearnClass.Arrays;

import java.util.Scanner;

public class 피보나치수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        solution(count);
    }

    private static void solution(int count) {
        int[] arr = new int[count];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i-2] + arr[i-1];
        }

        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
