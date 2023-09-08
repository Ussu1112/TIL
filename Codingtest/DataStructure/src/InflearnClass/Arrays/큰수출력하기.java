package InflearnClass.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 큰수출력하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = Integer.parseInt(sc.nextLine());
        int[] inputArr = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            inputArr[i] = sc.nextInt();
        }

        for (int x : solution(inputArr)) {
            System.out.print(x + " ");
        }
    }

    private static List<Integer> solution(int[] inputArr) {
        List<Integer> answer = new ArrayList<>();
        answer.add(inputArr[0]);

        for (int i = 1; i < inputArr.length; i++) {
            if (inputArr[i-1] < inputArr[i])
                answer.add(inputArr[i]);
        }

        return answer;
    }
}
