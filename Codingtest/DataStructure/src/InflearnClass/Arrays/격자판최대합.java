package InflearnClass.Arrays;

import java.util.Scanner;

public class 격자판최대합 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[][] arr = new int[count][count];

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(count, arr));
    }

    private static int solution(int count, int[][] arr) {
        int answer = 0;
        int tmp = 0;

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                tmp += arr[j][i];
            }
            answer = isMax(answer, tmp);
        }

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                tmp += arr[i][j];
            }
            answer = isMax(answer, tmp);
        }

        for (int i = 0; i < count; i++) {
            for (int j = count-1; j >= 0; j--) {
                tmp += arr[i][j];
            }
            answer = isMax(answer, tmp);
        }


        return answer;
    }

    private static int isMax(int answer, int tmp) {
        if (answer < tmp)
            answer = tmp;
        return answer;
    }

}
