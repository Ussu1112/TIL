package InflearnClass.Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class 등수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] arr = new int[count];

        for (int i = 0; i < count; i++) {
            arr[i] = sc.nextInt();
        }

        for (int x : solution(arr)) {
            System.out.print(x + " ");
        }
    }

    private static ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int cnt = 1;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] < arr[j])
                    cnt++;
            }
            answer.add(cnt);
        }
        return answer;
    }
}
