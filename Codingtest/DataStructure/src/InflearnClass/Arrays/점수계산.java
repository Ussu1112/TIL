package InflearnClass.Arrays;

import java.util.Scanner;

public class 점수계산 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] arr = new int[count];

        for (int i = 0; i < count; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(arr));
    }

    private static int solution(int[] arr) {
        int answer = 0;
        int tmp = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1){
                tmp++;
                answer += tmp;
            } else {
                tmp = 0;
            }
        }
        return answer;
    }
}
